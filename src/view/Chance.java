package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;

import dao.UserDao;
import model.User;
import util.Conn;
import util.Is;

import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Chance extends JInternalFrame {
	private JTextField text1;
	private JTextField text3;
	private JPasswordField text2;
	private JTextField text4;
	private JTextField text5;
	private JTextField text6;
	private JRadioButton radio1;
	private JRadioButton radio2;
	private JTextField text7;
	private ButtonGroup group;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chance frame = new Chance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	public JTextField getText1() {
		return text1;
	}

	public JTextField getText7() {
		return text7;
	}

	public void setText7(JTextField text7) {
		this.text7 = text7;
	}

	public void setText1(JTextField text1) {
		this.text1 = text1;
	}

	public JTextField getText3() {
		return text3;
	}

	public void setText3(JTextField text3) {
		this.text3 = text3;
	}

	public JPasswordField getText2() {
		return text2;
	}

	public void setText2(JPasswordField text2) {
		this.text2 = text2;
	}

	public JTextField getText4() {
		return text4;
	}

	public void setText4(JTextField text4) {
		this.text4 = text4;
	}

	public JTextField getText5() {
		return text5;
	}

	public void setText5(JTextField text5) {
		this.text5 = text5;
	}

	public JTextField getText6() {
		return text6;
	}

	public void setText6(JTextField text6) {
		this.text6 = text6;
	}

	public JRadioButton getRadio1() {
		return radio1;
	}

	public void setRadio1(JRadioButton radio1) {
		this.radio1 = radio1;
	}

	public JRadioButton getRadio2() {
		return radio2;
	}

	public void setRadio2(JRadioButton radio2) {
		this.radio2 = radio2;
	}

	/**
	 * Create the frame.
	 */
	public Chance(User u,UserMain main) {           //传入一个user
		setTitle("\u7528\u6237\u4FEE\u6539");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 600, 550);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("账号");
		label.setFont(new Font("宋体", Font.PLAIN, 23));
		label.setBounds(24, 32, 72, 34);
		getContentPane().add(label);
		
		text1 = new JTextField();
		text1.setFont(new Font("宋体", Font.PLAIN, 23));
		text1.setBounds(88, 32, 191, 33);
		getContentPane().add(text1);
		text1.setColumns(10);
		
		JLabel label_1 = new JLabel("密码");
		label_1.setFont(new Font("宋体", Font.PLAIN, 23));
		label_1.setBounds(24, 91, 46, 34);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("部门号");
		label_2.setFont(new Font("宋体", Font.PLAIN, 23));
		label_2.setBounds(14, 151, 72, 34);
		getContentPane().add(label_2);
		
		text3 = new JTextField();
		text3.setFont(new Font("宋体", Font.PLAIN, 23));
		text3.setColumns(10);
		text3.setBounds(88, 151, 191, 33);
		getContentPane().add(text3);
		
		text2 = new JPasswordField();
		text2.setFont(new Font("宋体", Font.PLAIN, 23));
		text2.setBounds(88, 91, 191, 34);
		getContentPane().add(text2);
		
		JLabel label_3 = new JLabel("地址");
		label_3.setFont(new Font("宋体", Font.PLAIN, 23));
		label_3.setBounds(24, 210, 55, 34);
		getContentPane().add(label_3);
		
		text4 = new JTextField();
		text4.setFont(new Font("宋体", Font.PLAIN, 23));
		text4.setColumns(10);
		text4.setBounds(88, 211, 191, 33);
		getContentPane().add(text4);
		
		JLabel label_4 = new JLabel("用户名");
		label_4.setFont(new Font("宋体", Font.PLAIN, 23));
		label_4.setBounds(303, 32, 72, 34);
		getContentPane().add(label_4);
		
		text5 = new JTextField();
		text5.setFont(new Font("宋体", Font.PLAIN, 23));
		text5.setColumns(10);
		text5.setBounds(379, 32, 191, 33);
		getContentPane().add(text5);
		
		JLabel label_5 = new JLabel("性别");
		label_5.setFont(new Font("宋体", Font.PLAIN, 23));
		label_5.setBounds(319, 93, 55, 30);
		getContentPane().add(label_5);
		group=new ButtonGroup();        // 设置ButtonGroup组件
		radio1 = new JRadioButton("男");
		radio1.setFont(new Font("宋体", Font.PLAIN, 23));
		radio1.setBounds(394, 95, 60, 27);
		/*getContentPane().add(radio1);*/
		group.add(radio1);
		radio2 = new JRadioButton("女");
		radio2.setFont(new Font("宋体", Font.PLAIN, 23));
		radio2.setBounds(481, 95, 60, 27);
	/*	getContentPane().add(radio2);*/
		group.add(radio2);
	    getContentPane().add(radio1);
	    getContentPane().add(radio2);
		JLabel label_6 = new JLabel("电话");
		label_6.setFont(new Font("宋体", Font.PLAIN, 23));
		label_6.setBounds(315, 157, 60, 22);
		getContentPane().add(label_6);
		
		text6 = new JTextField();
		text6.setFont(new Font("宋体", Font.PLAIN, 23));
		text6.setColumns(10);
		text6.setBounds(379, 151, 191, 33);
		getContentPane().add(text6);
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {              // 修改的事件监听器
				JOptionPane option = new JOptionPane();
				Connection connection;
				int result = option.showConfirmDialog(null, "确认修改?", "确认", JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.INFORMATION_MESSAGE);
				if (JOptionPane.OK_OPTION == result) {
					User user = new User();
					String st = "^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$"; // 电子邮件的正则表达式
					String mo1 = "^[1][3,4,5,7,8][0-9]{9}$"; // 手机号码的正则
					String mo2 = "^[1-9]{1}[0-9]{5,8}$"; // 没有区号的电话号码
					UserDao dao = new UserDao();
					connection = Conn.getConnection();
					if (Is.isEmpty(text1.getText()) || Is.isEmpty(new String(text2.getPassword()))
							|| Is.isEmpty(text3.getText()) || Is.isEmpty(text4.getText()) || Is.isEmpty(text5.getText())
							|| Is.isEmpty(text6.getText()) || Is.isEmpty(text7.getText())) {
						option.showMessageDialog(null, "你还有未填写完信息", "警告", JOptionPane.ERROR_MESSAGE);
					} else if (text5.getText().matches("\\d+")) {
						option.showMessageDialog(null, "用户名不能为数字，请重新输入", "警告", JOptionPane.ERROR_MESSAGE);
						text5.setText("");
					} else if (!text3.getText().matches("[12345]")) {
						option.showMessageDialog(null, "部门号格式不对或没有该部门", "警告", JOptionPane.ERROR_MESSAGE);
						text3.setText("");
					} else if (!text7.getText().matches(st)) {
						option.showMessageDialog(null, "电子邮件的格式不对，请重新输入", "警告", JOptionPane.ERROR_MESSAGE);
						text7.setText("");
					} else if (!text6.getText().matches(mo1) && !text6.getText().matches(mo2)) { // 两个都不匹配时
						option.showMessageDialog(null, "电话号码的格式不对，请重新输入", "警告", JOptionPane.ERROR_MESSAGE);
						text6.setText("");
					} else if (text4.getText().matches("\\d+") || text4.getText().matches("\\w+")) {
						option.showMessageDialog(null, "家庭住址不能为数字或英文，请重新输入", "警告", JOptionPane.ERROR_MESSAGE);
						text4.setText("");
					}else {
						user.setuId(text1.getText());
						user.setuPassword(new String(text2.getPassword()));
						user.setuName(text5.getText());
						if (radio1.isSelected()) {
							user.setuSex(radio1.getText());
						} else {
							user.setuSex(radio2.getText());
						}
						user.setuDepartmentID(Integer.parseInt(text3.getText()));
						user.setuTelephone(text6.getText());
						user.setuAddress(text4.getText());
						user.setuEmail(text7.getText());
						user.setUsNumber(u.getUsNumber());
						if (!user.getuId().equals(u.getuId())) {
							try {
								if (!dao.back(connection, user)) {
									option.showMessageDialog(null, "你的账号已经注册了，请重新输入账号", "警告",
											JOptionPane.ERROR_MESSAGE);
									text1.setText("");
								} else {
									UserDao.delete(connection, u.getuId());
									int i = dao.get(connection, user);
									option.showMessageDialog(null, "你已经修改成功,请重新登陆");
									new UserLog().setVisible(true);
									main.setVisible(false);     //将外部窗体设置为不可见
									dispose(); // 退出当前界面
									
									
								}
							} /*
								 * catch (HeadlessException e1) { // TODO Auto-generated catch block
								 * e1.printStackTrace(); }
								 */catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						} else {
							try { // 修改成功后
								UserDao.delete(connection, u.getuId());
								dao.get(connection, user);
								option.showMessageDialog(null, "你已经修改成功，请重新登陆");
								new UserLog().setVisible(true);
								main.setVisible(false);
								dispose();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
					try {
						connection.close();          //关闭连接
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 23));
		btnNewButton.setBounds(107, 401, 113, 27);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); 
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 23));
		btnNewButton_1.setBounds(377, 401, 113, 27);
		getContentPane().add(btnNewButton_1);
		
		JLabel label_7 = new JLabel("邮件");
		label_7.setFont(new Font("宋体", Font.PLAIN, 23));
		label_7.setBounds(320, 210, 55, 34);
		getContentPane().add(label_7);
		
		text7 = new JTextField();
		text7.setFont(new Font("宋体", Font.PLAIN, 23));
		text7.setColumns(10);
		text7.setBounds(379, 210, 191, 33);
		getContentPane().add(text7);
	}
}
