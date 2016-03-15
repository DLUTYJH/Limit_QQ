package javaSe_Project_Communication_Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JFrame;

import javaSe_Project_Communication_Util.StringUtil;

/**
 * 
 * 线程:接受客户端的登陆信息:用户名,服务器地址,端口号
 * 
 * 
 * @author answer
 *
 */

public class ConnectThread extends Thread {

	private JFrame jFrame;
	private ServerSocket serverSocket;
	private Socket socket;
	private InputStream in;
	private OutputStream out;

	public ConnectThread(JFrame jFrame, int port) {
		this.jFrame = jFrame;
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void run() {

		while (true) {

			try {
				socket = serverSocket.accept();
				in = socket.getInputStream();
				out = socket.getOutputStream();

				byte[] data = new byte[1024];
				int len = in.read(data);

				String infoFromClient = new String(data, 0, len);

				// 解析从客户端收到的信息
				int index = infoFromClient.lastIndexOf("@@@");
				String username = infoFromClient.substring(0, index);
				int lastindex = infoFromClient.lastIndexOf("@");
				String clientport = infoFromClient.substring(lastindex + 1);

				Service service = (Service) jFrame;
				Map<String, Integer> map = service.getMap();

				if (StringUtil.isUsernameDuplicated(map, username)) {
					out.write(StringUtil.ERROR.getBytes());
					in.close();
					out.close();
					socket.close();
				} else {
					map.put(username, Integer.parseInt(clientport));
					service.setUseList();
					String info = "";
					for (Iterator<String> i = map.keySet().iterator(); i.hasNext();) {
						info = (String) i.next() + "@";
					}
					out.write(info.getBytes());

				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}
