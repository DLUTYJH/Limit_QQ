package javaSe_Project_Communication_Cilent;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javaSe_Project_Communication_Util.StringUtil;

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

		jButton1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Login.this.execute();
			}
		});

		jButton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Login.this.clear();
			}
		});
	}

	private void clear() {
		jTextField1.setText("");
		jTextField2.setText("");
		jTextField3.setText("");
		jTextField1.requestFocus();
	}

	private void execute() {
		String userName = this.jTextField1.getText();
		String hostAddress = this.jTextField2.getText();
		String port = this.jTextField3.getText();

		// 用户名的判断
		if (StringUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(this, "用户名不能为空!", "警告", JOptionPane.WARNING_MESSAGE);
			this.jTextField1.requestFocus();
			return;
		}

		// 服务器地址的判断
		if (StringUtil.isEmpty(hostAddress)) {
			JOptionPane.showMessageDialog(this, "服务器地址不能为空!", "警告", JOptionPane.WARNING_MESSAGE);
			this.jTextField2.requestFocus();
			return;
		}

		// 端口号的判断
		if (StringUtil.isEmpty(port)) {
			JOptionPane.showMessageDialog(this, "端口号不能为空!", "警告", JOptionPane.WARNING_MESSAGE);
			this.jTextField3.requestFocus();
			return;
		}
		if (!StringUtil.isNumber(port)) {
			JOptionPane.showMessageDialog(this, "端口号只能为数字!", "警告", JOptionPane.WARNING_MESSAGE);
			this.jTextField3.setText("");
			this.jTextField3.requestFocus();
			return;
		}
		if (!StringUtil.isPortCrrect(port)) {
			JOptionPane.showMessageDialog(this, "端口号范围为1024-65535!", "警告", JOptionPane.WARNING_MESSAGE);
			this.jTextField3.setText("");
			this.jTextField3.requestFocus();
			return;
		}
		
		StringUtil.SERVICE_PORT = Integer.parseInt(port) ;
		StringUtil.SERVICE_HOST = hostAddress ;
		StringUtil.CLIENT_NAME = userName ;
		
		new ClientConnectionThread(this,hostAddress,Integer.parseInt(port),userName).start();
		
	}

	public static void main(String[] args) {
		new Login();
	}
}
