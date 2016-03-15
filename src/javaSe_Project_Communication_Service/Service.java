package javaSe_Project_Communication_Service;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javaSe_Project_Communication_Util.StringUtil;

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

	private Map<String, Integer> map = new HashMap<String, Integer>();

	public Map<String, Integer> getMap() {
		return map;
	}

	public void setMap(Map<String, Integer> map) {
		this.map = map;
	}

	public JLabel getjLabel1() {
		return jLabel1;
	}

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
		jButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Service.this.execute();
			}
		});

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

	private void execute() {
		String hostPort = this.jTextField.getText();
		if (StringUtil.isEmpty(hostPort)) {
			JOptionPane.showMessageDialog(this, "端口号不能为空!", "警告", JOptionPane.WARNING_MESSAGE);
			this.jTextField.requestFocus();
			return;
		}
		if (!StringUtil.isNumber(hostPort)) {
			JOptionPane.showMessageDialog(this, "端口号只能为数字!", "警告", JOptionPane.WARNING_MESSAGE);
			this.jTextField.setText("");
			this.jTextField.requestFocus();
			return;
		}
		if (!StringUtil.isPortCrrect(hostPort)) {
			JOptionPane.showMessageDialog(this, "端口号范围为1024-65535!", "警告", JOptionPane.WARNING_MESSAGE);
			this.jTextField.setText("");
			this.jTextField.requestFocus();
			return;
		}

		new ConnectThread(this, Integer.parseInt(hostPort)).start();
		jLabel1.setText("服务器启动");
	}

	// 更新用户在线列表
	public void setUseList() {
		this.jTextArea.setText("");
		for (Iterator<String> i = map.keySet().iterator(); i.hasNext();) {
			String username = (String) i.next();
			this.jTextArea.setText(username + "\n");

		}

	}

	public static void main(String[] args) {
		new Service("服务器");
	}
}
