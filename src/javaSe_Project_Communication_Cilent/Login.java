package javaSe_Project_Communication_Cilent;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jPanel;

	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;

	private JTextField jTextField1;
	private JTextField jTextField2;
	private JTextField jTextField3;

	private JButton jButton1;
	private JButton jButton2;

	public Login() {
		super("用户登陆");
		init();
	}

	private void init() {
		GridLayout gridLayout = new GridLayout(4, 2);
		gridLayout.setVgap(40);
		jPanel = new JPanel(gridLayout);
		jPanel.setBorder(BorderFactory.createTitledBorder("用户登陆"));

		jLabel1 = new JLabel("用户名");
		jLabel2 = new JLabel("服务器地址");
		jLabel3 = new JLabel("端口号");

		jTextField1 = new JTextField(14);
		jTextField2 = new JTextField(14);
		jTextField3 = new JTextField(14);

		jButton1 = new JButton("登陆");
		jButton2 = new JButton("重置");

		jPanel.add(jLabel1);
		jPanel.add(jTextField1);

		jPanel.add(jLabel2);
		jPanel.add(jTextField2);

		jPanel.add(jLabel3);
		jPanel.add(jTextField3);

		jPanel.add(jButton1);
		jPanel.add(jButton2);

		this.getContentPane().add(jPanel, BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(500, 280);
		this.pack();
		this.setResizable(false);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		 new Login();
		//new Client("聊天室").init();
	}
}
