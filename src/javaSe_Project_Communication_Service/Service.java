package javaSe_Project_Communication_Service;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Service extends JFrame {

	private static final long serialVersionUID = 1L;

	// 控制面板布局
	private JPanel jPanel1;
	private JPanel jPanel2;
	private JPanel jPanel3;

	// 显示补课更改的文字
	private JLabel jLabel1;
	private JLabel jLabel2;

	// 输入文本框
	private JTextArea jTextArea;

	// 输入框
	private JTextField jTextField;

	// 按钮
	private JButton jButton;

	// 滚动条
	private JScrollPane jsPane;

	public Service(String name) {
		super(name);
		init();
	}

	private void init() {
		jPanel1 = new JPanel();
		jPanel2 = new JPanel();
		jPanel3 = new JPanel();

		jLabel1 = new JLabel("停止");
		jLabel1.setForeground(new Color(255, 0, 125));
		jLabel2 = new JLabel("端口号");

		jTextField = new JTextField(10);

		jButton = new JButton("启动服务器");

		jTextArea = new JTextArea();

		jsPane = new JScrollPane();

		jPanel1.setBorder(BorderFactory.createTitledBorder("服务器状态"));
		jPanel2.setBorder(BorderFactory.createTitledBorder("在线用户列表"));
		jPanel3.setBorder(BorderFactory.createTitledBorder("启动服务器"));

		jPanel1.add(jLabel1);

		jPanel3.add(jLabel2);
		jPanel3.add(jTextField);
		jPanel3.add(jButton);

		jTextArea.setEditable(false);
		jTextArea.setForeground(new java.awt.Color(245, 0, 0));
		jTextArea.setColumns(30);
		jTextArea.setRows(20);
		jsPane.setViewportView(jTextArea);
		jPanel2.add(jsPane);

		this.getContentPane().add(jPanel1, BorderLayout.NORTH);
		this.getContentPane().add(jPanel3, BorderLayout.CENTER);
		this.getContentPane().add(jPanel2, BorderLayout.SOUTH);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocation(500, 150);
		this.pack();
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Service("服务器");
	}
}
