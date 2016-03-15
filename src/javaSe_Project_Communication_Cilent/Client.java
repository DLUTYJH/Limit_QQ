package javaSe_Project_Communication_Cilent;

import java.awt.BorderLayout;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client extends JFrame {

	private static final long serialVersionUID = 1L;

	private JTextArea jTextArea1;
	private JTextArea jTextArea2;

	private JTextField jTextField;

	private JButton jButton1;
	private JButton jButton2;

	private JPanel jPanel1;
	private JPanel jPanel2;
	private JPanel jPanel3;

	public Client(String name) {
		super(name);
	}

	public void init() {

		jTextArea1 = new JTextArea(20, 30);
		jTextArea1.setEditable(false);
		jTextArea2 = new JTextArea(24, 10);
		jTextArea2.setEditable(false);

		jTextField = new JTextField(20);

		jButton1 = new JButton("发送");
		jButton2 = new JButton("清屏");

		jPanel1 = new JPanel(new BorderLayout());
		jPanel2 = new JPanel();
		jPanel3 = new JPanel();
		jPanel1.setBorder(BorderFactory.createTitledBorder("聊天室消息"));
		jPanel2.setBorder(BorderFactory.createTitledBorder("在线列表"));

		jPanel1.add(jTextArea1, BorderLayout.NORTH);
		jPanel3.add(jTextField);
		jPanel3.add(jButton1);
		jPanel3.add(jButton2);
		jPanel1.add(jPanel3, BorderLayout.SOUTH);

		jPanel2.add(jTextArea2);

		this.getContentPane().add(jPanel1, BorderLayout.WEST);
		this.getContentPane().add(jPanel2, BorderLayout.EAST);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(500, 280);
		this.pack();
		this.setResizable(false);
		this.setVisible(true);
	}

	public void setUseList(String str) {
		String temp = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != '@') {
				temp += str.charAt(i);
			} else {
				jTextArea2.setText(temp + "\n");
				temp = "";
			}
		}

	}
}
