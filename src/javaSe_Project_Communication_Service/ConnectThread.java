package javaSe_Project_Communication_Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;


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
				socket = serverSocket.accept() ;
				in = socket.getInputStream() ;
				out = socket.getOutputStream() ;
				
				byte[] data = new byte[1024] ;
				int len = in.read(data) ;
				
				String infoFromClient = new String(data,0,len) ;
				
				
				
				
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
			
			
			
			
		}
		
		
		
	}
	
	
	
	
	
	
	
	

}
