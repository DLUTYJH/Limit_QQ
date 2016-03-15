package javaSe_Project_Communication_Cilent;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JFrame;

import javaSe_Project_Communication_Util.StringUtil;

public class ClientConnectionThread extends Thread {

	private JFrame frame;
	private String hostAddress;
	private int hostPort;
	private String username;
	private Client client = new Client("聊天室");

	public ClientConnectionThread(JFrame jFrame, String hostAddress, int hostport, String username) {
		this.frame = jFrame;
		this.hostAddress = hostAddress;
		this.hostPort = hostport;
		this.username = username;
	}

	@Override
	public void run() {
		Socket socket = null;
		InputStream in = null;
		OutputStream out = null;

		try {
			InetAddress host = InetAddress.getByName(hostAddress);

			// 客户端向服务器发起连接
			socket = new Socket(host, hostPort);

			in = socket.getInputStream();
			out = socket.getOutputStream();

			int randomPort1 = StringUtil.generatePort();
			int randomPort2 = StringUtil.generatePort();

			// 构造客户端向服务器发送的消息内容
			InetAddress address = InetAddress.getLocalHost();
			String clientAddress = address.toString();
			int l = clientAddress.indexOf("/");
			clientAddress = clientAddress.substring(l + 1);
			String info = username + "@@@" + randomPort1;

			// 向服务器发送信息
			out.write(info.getBytes());

			client.init();
			frame.setVisible(false);

			byte[] data = new byte[104];
			int len = in.read(data);
			String str = new String(data, 0, len);
			client.setUseList(str);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
