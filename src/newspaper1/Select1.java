package newspaper1;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import JDBC.Connect_newspaper;
import JDBC.Connect_user;
import dao.UserDao;
import util.Conn;

public class Select1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Select frame = new Select();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Select1() {
		setTitle("添加");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 468);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {               //确定的监听器
			public void actionPerformed(ActionEvent arg0) {
				Connection con=Conn.getConnection();
				Ab_add b = new Ab_add();
				String text = textField.getText();
				String text_1 = textField_1.getText();				
				String text_2 = textField_2.getText();				
				String text_3 = textField_3.getText();				
				String text_4 = textField_4.getText();
				String text_5 = textField_5.getText();				
				String text_6 = textField_6.getText();				
				String text_7 = textField_7.getText();				
				String text_8 = textField_8.getText();
				if (text.equals("") || text_1.equals("") || text_2.equals("") || text_3.equals("") || text_4.equals("")
						|| text_5.equals("") || text_6.equals("") || text_7.equals("") || text_8.equals("")) {
					JOptionPane.showMessageDialog(null, "请补全录入信息");
				} else
					try {
						if (UserDao.back(con, text)) {                // 有相同账号时
							JOptionPane.showMessageDialog(null, "你输入的账号已存在，请重新输入");
							textField.setText("");
						} else if (text_2.matches("\\d+")) {          // 当输入的用户名字为数字的时候
							JOptionPane.showMessageDialog(null, "输入的用户名为数字，请重新输入");
							textField_2.setText("");               // 将用户名设置为空
						} else if (!(text_3.equals("男") || text_3.equals("女"))) { // 但输入的性别不为男女时
							JOptionPane.showMessageDialog(null, "你输入的性别有误，请重新输入");
							textField_3.setText("");              // 将用户名设置为空
						} else if (text_4.matches("\\d+")) {           // 当输入的地址为数字时
							JOptionPane.showMessageDialog(null, "你输入的用户地址有误，请重新输入");
							textField_4.setText("");                  // 将用户名设置为空
						} else if (!(text_5.matches("^[1][3,4,5,7,8][0-9]{9}$")
								|| text_5.matches("^[1-9]{1}[0-9]{5,8}$"))) { // 当输入的电话号码有误时
							JOptionPane.showMessageDialog(null, "你输入的电话号码有误，请重新输入");
							textField_5.setText("");
						} else if (!text_6.matches(
								"^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$")) { // 当用户邮箱输入有误时
							JOptionPane.showMessageDialog(null, "电子邮件的格式不对，请重新输入");
							textField_6.setText("");
						} else if (!text_7.matches("[12345]")) {
							JOptionPane.showMessageDialog(null, "输入的部门号不存在，请重新输入");
							textField_7.setText("");
						} else if (!text_8.matches("\\d+")) {
							JOptionPane.showMessageDialog(null, "你输入的订阅数量格式不对，请重新输入");
							textField_8.setText("");
						} else {
							b.setuName(text);
							b.setuId(text_1);
							b.setuPassword(text_2);
							b.setuSex(text_3);
							b.setuAddress(text_4);
							b.setuTelephone(text_5);
							b.setuEmail(text_6);
							b.setuDepartmentID(text_7);
							b.setUsNumber(text_8);
							Connect_user u = new Connect_user();
							u.bbbb(b);
							JOptionPane.showMessageDialog(null, "录入成功");
							setVisible(false);
						}
					} catch (HeadlessException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}

		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("用户密码");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		JLabel label = new JLabel("用户账号");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		label_1 = new JLabel("用户姓名");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		label_2 = new JLabel("性别");
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		label_3 = new JLabel("地址");
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		label_4 = new JLabel("电话号码");
		label_4.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		label_5 = new JLabel("用户邮箱");
		label_5.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		label_6 = new JLabel("用户部门号");
		label_6.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		label_7 = new JLabel("订阅数量");
		label_7.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_6)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton)
							.addGap(70)))
					.addGap(52))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(42)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
							.addComponent(label)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(40)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
							.addGap(38)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
							.addGap(38)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_6)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(111)
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addGap(44)
							.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton)
						.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(36))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
