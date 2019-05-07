package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.UserDao;
import model.User;
import util.Conn;
import util.Is;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class UserLog extends JFrame {            
	JOptionPane pane=new JOptionPane();        //����ѡ�����
	private JPanel contentPane;
	private JTextField text1;
	private JPasswordField text2;
    static UserMain main=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLog frame = new UserLog();
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
	public UserLog() {
		setTitle("\u62A5\u520A\u8BA2\u9605\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(600,600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("��ӭʹ�ñ������Ĺ���ϵͳ");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 37));
		
		JLabel lblNewLabel_1 = new JLabel("�û��˺�");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 22));
		
		text1 = new JTextField();
		text1.setFont(new Font("����", Font.PLAIN, 23));
		text1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("�û�����");
		lblNewLabel_2.setFont(new Font("����", Font.PLAIN, 22));
		
		JButton reg = new JButton("ע��");
		reg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserReg userReg=new UserReg();           //�л���ע��ҳ��
				userReg.setVisible(true);
				dispose();         //���ٴ���
			}
		});
		reg.setFont(new Font("����", Font.PLAIN, 23));
		
		JButton button = new JButton("����");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			   new Select().setVisible(true);
			}
		});
		button.setFont(new Font("����", Font.PLAIN, 23));
		
		JButton button_1 = new JButton("����");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = Conn.getConnection();
				ResultSet set = null;
				try {
					set = UserDao.log(con);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String a = text1.getText();
				String b = new String(text2.getPassword());
				if (Is.isEmpty(a) || Is.isEmpty(b)) {
					pane.showMessageDialog(null, "�벹ȫ��ĵ�½��Ϣ", "����", JOptionPane.ERROR_MESSAGE);
				} else                                               //���û�������ʱ
					try {
						if (!UserDao.back(con, text1.getText())) {                  
							JOptionPane.showMessageDialog(null, "���˺Ų�����");
							text1.setText("");                    //�˺�Ϊ��ʱ�����������������Ϊ��
							text2.setText("");
						} else {                                   //���û���������ȫ��Ϣʱ
							try {
								while (set.next()) {
									if (text1.getText().equals(set.getString(1))) {             //�˺�
										if (new String(text2.getPassword()).equals(set.getString(2))) {              //����Ҳ��ȷʱ
											pane.showMessageDialog(null, "��½�ɹ�");        // ������ʾ���ڣ���½�ɹ�
											new UserMain(new User(text1.getText())).setVisible(true);         // ������ҳ��,����user����ȥ
											/*main = new UserMain(new User(text1.getText()));
											main.setVisible(true);*/
											dispose(); // ���ٵ�ǰ����
										} else { // �������ʱ
											pane.showMessageDialog(null, "����������벻��ȷ������������", "����", JOptionPane.ERROR_MESSAGE);
											text2.setText("");
										}
									} // �������ѭ����֤��û���ҵ�
								} // ��δ���õ��˻�������ʱ
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} finally {
								try {
									set.close(); // �ر�ResultSet
									con.close();
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} // �ر�Collection
							}

						}
					} catch (HeadlessException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		button_1.setFont(new Font("����", Font.PLAIN, 23));
		
		text2 = new JPasswordField();
		text2.setFont(new Font("����", Font.PLAIN, 23));
		text2.setColumns(10);
		text2.addKeyListener(new KeyAdapter() {                  //�������ϰ���enter���ͻ����
				@Override
				public void keyPressed(KeyEvent e) {
					// TODO Auto-generated method stub
					 if(e.getKeyCode() == KeyEvent.VK_ENTER) {        //�жϰ��µļ��Ƿ��ǻس���
						 Connection con = Conn.getConnection();
							ResultSet set = null;
							try {
								set = UserDao.log(con);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							String a = text1.getText();
							String b = new String(text2.getPassword());
							if (Is.isEmpty(a) || Is.isEmpty(b)) {
								pane.showMessageDialog(null, "�벹ȫ��ĵ�½��Ϣ", "����", JOptionPane.ERROR_MESSAGE);
							} else                                               //���û�������ʱ
								try {
									if (!UserDao.back(con, text1.getText())) {                  
										JOptionPane.showMessageDialog(null, "���˺Ų�����");
										text1.setText("");                    //�˺�Ϊ��ʱ�����������������Ϊ��
										text2.setText("");
									} else {                                   //���û���������ȫ��Ϣʱ
										try {
											while (set.next()) {
												if (text1.getText().equals(set.getString(1))) {             //�˺�
													if (new String(text2.getPassword()).equals(set.getString(2))) {              //����Ҳ��ȷʱ
														pane.showMessageDialog(null, "��½�ɹ�");        // ������ʾ���ڣ���½�ɹ�
														new UserMain(new User(text1.getText())).setVisible(true);         // ������ҳ��,����user����ȥ
														/*main = new UserMain(new User(text1.getText()));
														main.setVisible(true);*/
														dispose(); // ���ٵ�ǰ����
													} else { // �������ʱ
														pane.showMessageDialog(null, "����������벻��ȷ������������", "����", JOptionPane.ERROR_MESSAGE);
														text2.setText("");
													}
												} // �������ѭ����֤��û���ҵ�
											} // ��δ���õ��˻�������ʱ
										} catch (SQLException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										} finally {
											try {
												set.close(); // �ر�ResultSet
												con.close();
											} catch (SQLException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											} // �ر�Collection
										}

									}
								} catch (HeadlessException | SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
					 }

				}
			});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(72, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 456, GroupLayout.PREFERRED_SIZE)
					.addGap(44))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(102)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(reg, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addGap(76))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addGap(18)
									.addComponent(text1, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(66)
											.addComponent(button, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(text2, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)))))
							.addContainerGap(126, Short.MAX_VALUE))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(58)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addGap(62)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(text1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(text2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(62)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(reg, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(147, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
