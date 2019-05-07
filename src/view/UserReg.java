package view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.UserDao;
import model.User;
import util.Conn;
import util.Is;
import util.SendMail;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class UserReg extends JFrame {

	private JPanel contentPane;
	private JTextField text1;
	private JTextField text4;
	private JTextField text5;
	private JTextField text6;
	private JTextField text7;
	private JPasswordField text2;
	private JPasswordField text3;
	private JTextField text8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserReg frame = new UserReg();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserReg() {
		setResizable(false);
		setTitle("\u7528\u6237\u6CE8\u518C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(800,500);
		setLocationRelativeTo(null);
		contentPane =  new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("用户注册");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 34));
		
		JLabel lblNewLabel_1 = new JLabel("用户账号");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 23));
		JLabel lblNewLabel_2 = new JLabel("*密码");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 23));
		
		JLabel lblNewLabel_3 = new JLabel("确认密码");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 23));
		
		JLabel lblNewLabe = new JLabel("用户名");
		lblNewLabe.setFont(new Font("宋体", Font.PLAIN, 23));
		
		JLabel lblNewLabel_4 = new JLabel("性别");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 23));
		
		text1 = new JTextField();
		text1.setFont(new Font("宋体", Font.PLAIN, 23));
		text1.setColumns(10);
		
		text4 = new JTextField();
		text4.setFont(new Font("宋体", Font.PLAIN, 23));
		text4.setColumns(10);
		ButtonGroup buttonGroup=new ButtonGroup();        //创建单选框
		JRadioButton radio1 = new JRadioButton("男");
		radio1.setSelected(true);
		radio1.setFont(new Font("宋体", Font.PLAIN, 23));
		
		JRadioButton radio2 = new JRadioButton("女");
		buttonGroup.add(radio1);      //将radio加入到buttonGroup中去
		buttonGroup.add(radio2);
		radio2.setFont(new Font("宋体", Font.PLAIN, 23));
		
		JLabel label = new JLabel("*部门号");
		label.setFont(new Font("宋体", Font.PLAIN, 23));
		
		text5 = new JTextField();
		text5.setFont(new Font("宋体", Font.PLAIN, 23));
		text5.setColumns(10);
		
		JLabel label_1 = new JLabel("联系电话");
		label_1.setFont(new Font("宋体", Font.PLAIN, 23));
		
		text6 = new JTextField();
		text6.setFont(new Font("宋体", Font.PLAIN, 23));
		text6.setColumns(10);
		
		JLabel label_2 = new JLabel("家庭住址");
		label_2.setFont(new Font("宋体", Font.PLAIN, 23));
		
		text7 = new JTextField();
		text7.setFont(new Font("宋体", Font.PLAIN, 23));
		text7.setColumns(10);
		
		JButton btnNewButton = new JButton("注册");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {             //创建一个新用户
				String st="^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";    //电子邮件的正则表达式
				String mo1="^[1][3,4,5,7,8][0-9]{9}$";         //手机号码的正则
				String mo2="^[1-9]{1}[0-9]{5,8}$";         //没有区号的电话号码
				User user=new User();           //创建user,不能设置为空，否则会出现空指针异常
				UserDao dao=new UserDao();
				Connection connection=Conn.getConnection();
				JOptionPane option=new JOptionPane();
				if(Is.isEmpty(text1.getText())||Is.isEmpty(new String(text2.getPassword()))||Is.isEmpty(new String(text3.getPassword()))||Is.isEmpty(text4.getText())||Is.isEmpty(text5.getText())||Is.isEmpty(text6.getText())||Is.isEmpty(text7.getText())||Is.isEmpty(text8.getText())) {
					option.showMessageDialog(null, "你还有未填写信息", "警告", JOptionPane.ERROR_MESSAGE);
				}else if(!new String(text2.getPassword()).equals(new String(text3.getPassword()))) {
					option.showMessageDialog(null, "两次密码不相同，请重新输入", "警告", JOptionPane.ERROR_MESSAGE);
					text2.setText("");
					text3.setText("");
				}else if(text4.getText().matches("\\d+")) {
					option.showMessageDialog(null, "用户名不能为数字，请重新输入", "警告", JOptionPane.ERROR_MESSAGE);
					text4.setText("");
				}else if(!text5.getText().matches("[12345]")) {
					option.showMessageDialog(null, "部门号格式不对或没有该部门", "警告", JOptionPane.ERROR_MESSAGE);
					text5.setText("");
				}else if(!text8.getText().matches(st)) {
					option.showMessageDialog(null, "电子邮件的格式不对，请重新输入", "警告", JOptionPane.ERROR_MESSAGE);
					text8.setText(""); 
				}else if(!text6.getText().matches(mo1)&&!text6.getText().matches(mo2)) {                  //两个都不匹配时
					option.showMessageDialog(null, "联系方式的格式不对，请重新输入", "警告", JOptionPane.ERROR_MESSAGE);
					text6.setText("");
				}
				else if(text7.getText().matches("\\d+")||text7.getText().matches("\\w+")) {
					option.showMessageDialog(null, "家庭住址不能为数字或英文，请重新输入", "警告", JOptionPane.ERROR_MESSAGE);
					text7.setText("");
				}else {
					user.setuId(text1.getText());
					user.setuPassword(new String(text2.getPassword()));
					user.setuName(text4.getText());
					if(radio1.isSelected()) {
						user.setuSex(radio1.getText());
					}else {
						user.setuSex(radio2.getText());
					}
					user.setuDepartmentID(Integer.parseInt(text5.getText()));
					user.setuTelephone(text6.getText());
					user.setuAddress(text7.getText());
					user.setuEmail(text8.getText());
					user.setUsNumber(0);
					try {
						if(!dao.back(connection, user)) {
							option.showMessageDialog(null, "你的账号已经注册了，请重新输入账号", "警告", JOptionPane.ERROR_MESSAGE);
							text1.setText("");
						}else {
							int i=dao.get(connection, user);
							option.showMessageDialog(null, "你已经注册成功");
							dispose();           //退出当前界面
							new UserLog().setVisible(true);     //创建登陆窗口
							try {
								Thread.sleep(500);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						new SendMail(text8.getText(),"你已经成功注册了报刊订阅系统，用户账号为:"+text1.getText()+","+"用户名为:"+text4.getText()+","+"\r\n"+"请依据你的账号密码登陆系统.......").start();            //根据text8里面的电子邮件来提示用户注册成功
						}
					} catch (HeadlessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}finally {
						try {
							connection.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				try {
					connection.close();         //关闭资源
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JButton button = new JButton("返回");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new UserLog().setVisible(true);
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 20));
		
		text2 = new JPasswordField();
		text2.setFont(new Font("宋体", Font.PLAIN, 23));
		
		text3 = new JPasswordField();
		text3.setFont(new Font("宋体", Font.PLAIN, 23));
		
		JLabel label_3 = new JLabel("电子邮件");
		label_3.setFont(new Font("宋体", Font.PLAIN, 23));
		
		text8 = new JTextField();
		text8.setFont(new Font("宋体", Font.PLAIN, 23));
		text8.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(197)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED, 301, Short.MAX_VALUE)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addGap(134))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(305, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
					.addGap(243))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(34, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabe)
							.addGap(16))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addGap(38))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_3)
							.addGap(18)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(text3, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
						.addComponent(text1, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
						.addComponent(text4, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
						.addComponent(text2, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(label_3)
									.addComponent(label)
									.addComponent(label_1))
								.addComponent(label_2))
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_4)
							.addGap(27)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(41)
							.addComponent(radio1)
							.addGap(55)
							.addComponent(radio2))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(30)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(text8, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
								.addComponent(text6, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
								.addComponent(text7, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
								.addComponent(text5, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))))
					.addGap(44))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(text1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_4))
							.addGap(38)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2)
								.addComponent(text2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(label)
								.addComponent(text5, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(radio1)
							.addComponent(radio2)))
					.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(text3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3))
							.addGap(58))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_3)
								.addComponent(text8, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
							.addGap(29)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_1)
								.addComponent(text6, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
							.addGap(18)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(text4, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabe))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(9)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(text7, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_2))))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(14))
		);
		contentPane.setLayout(gl_contentPane);
	}
}