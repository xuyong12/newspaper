package view;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import dao.MagazineDao;
import dao.SubscribeDao;
import dao.UserDao;
import model.Subscribe;
import model.User;
import util.Conn;
import util.Is;
import util.SendMail;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Buy extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JScrollPane pane;
	private Vector<String> title;
	private Vector<Vector<String>> data;
	private Connection con;
	private ResultSet set;
	private JTextField text2;
	private JTextField text1;
	private JTextField text3;
	private JTextField text4;
	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Buy frame = new Buy();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Buy(User user) {
		getContentPane().setFont(new Font("����", Font.PLAIN, 23));
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 600, 550);
		JLabel lblNewLabel = new JLabel("��������");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 33));
	    title=new Vector<>();
	    title.add("������");
	    title.add("��������");
	    title.add("��������");
	    title.add("����������");
	    title.add("�����۸�");
	    data=new Vector<>();
	    con=Conn.getConnection();
	    try {
			set=MagazineDao.get(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}try {
			while(set.next()) {              //�������صı�������Ϣ
				Vector<String> vec=new Vector<>();
				vec.add(""+set.getInt(1));
				vec.add(set.getString(2));
				vec.add(""+set.getDate(3));
				vec.add(set.getString(4));
				vec.add(""+set.getInt(5));
				data.add(vec);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table = new JTable(data,title);
		table.setEnabled(false);     //���ñ�񲻿ɱ༭
		table.setFont(new Font("����", Font.PLAIN, 13));
		table.getTableHeader().setReorderingAllowed(false);             //���ñ����в��ɼ�
		/*table.setAutoResizeMode(0);        //�����Ƿ��Զ�����
*/		pane=new JScrollPane(table);          //��table�ӽ����������
		JLabel lblNewLabel_1 = new JLabel("�û��˺�");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 23));
		
		JLabel label = new JLabel("�������");
		label.setFont(new Font("����", Font.PLAIN, 23));
		
		text2 = new JTextField();
		text2.setFont(new Font("����", Font.PLAIN, 23));
		text2.setColumns(10);
		
		JLabel label_1 = new JLabel("��������");
		label_1.setFont(new Font("����", Font.PLAIN, 23));
		
		text1 = new JTextField();
		text1.setFont(new Font("����", Font.PLAIN, 23));
		text1.setColumns(10);
		
		text3 = new JTextField();
		text3.setFont(new Font("����", Font.PLAIN, 23));
		text3.setColumns(10);
		
		JLabel label_2 = new JLabel("��������");
		label_2.setFont(new Font("����", Font.PLAIN, 23));
		
		JComboBox<String> box = new JComboBox<>();
		box.setFont(new Font("����", Font.PLAIN, 23));
		try {                       //��������������
			set=MagazineDao.getUName(con);
			while(set.next()) {
				box.addItem(set.getString(1));          //��ȡȫ��������
			}
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JButton button = new JButton("ȷ��");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {              //ȷ���ļ�����
				con = Conn.getConnection();
				try {
					if (Is.isEmpty(text1.getText()) || Is.isEmpty(text2.getText()) || Is.isEmpty(text3.getText())||Is.isEmpty(text4.getText())) {
						JOptionPane.showMessageDialog(null, "�벹ȫ��Ķ�����Ϣ", "����", JOptionPane.ERROR_MESSAGE);
					} else if (!UserDao.back(con, text1.getText())) {
						JOptionPane.showMessageDialog(null, "�û��������ڣ���ȷ��������", "����", JOptionPane.ERROR_MESSAGE);
						text1.setText("");
					} else if (!text1.getText().equals(user.getuId())) {
						JOptionPane.showMessageDialog(null, "���������Լ����˺�!!!", "����", JOptionPane.ERROR_MESSAGE);
					} else if (!text2.getText().matches("\\d+")) {
						JOptionPane.showMessageDialog(null, "�����Ÿ�ʽ���ԣ�����������", "����", JOptionPane.ERROR_MESSAGE);
						text2.setText("");
					} else if (!MagazineDao.hasMId(con, Integer.parseInt(text2.getText()))) {
						JOptionPane.showMessageDialog(null, "�����Ų����ڣ���������ȷ�ı�����", "����", JOptionPane.ERROR_MESSAGE);
						text2.setText("");
					} else if (!MagazineDao.hasMatches(con, Integer.parseInt(text2.getText()),
							box.getSelectedItem().toString())) {
						JOptionPane.showMessageDialog(null, "����������ѡ�������ֲ���ͬ����ȷ��ѡ��", "����", JOptionPane.ERROR_MESSAGE);
					} else if (!text3.getText().matches("\\d+")) {        // �ж������Ƿ�Ϊ����
						JOptionPane.showMessageDialog(null, "��������ȷ��ʽ�Ķ�������", "����", JOptionPane.ERROR_MESSAGE);
						text3.setText("");
					} else if (!text4.getText().matches("\\d+")) {        // �ж������Ƿ�Ϊ����
						JOptionPane.showMessageDialog(null, "��������ȷ��ʽ�Ķ�������", "����", JOptionPane.ERROR_MESSAGE);
						text4.setText("");
					} 
					else { // ���ݶ�����ʱ
						Subscribe sub = new Subscribe(Integer.parseInt(text1.getText()),
								Integer.parseInt(text2.getText()), Integer.parseInt(text3.getText()),
								Integer.parseInt(text4.getText())); // �������ı����
						if (SubscribeDao.exist(con, sub) && SubscribeDao.exist2(con, sub)) { // �����û������ڶ��ı�ʱ�Ҷ����Ŵ����ڶ�����ʱ
							SubscribeDao.update(con, sub, Integer.parseInt(text3.getText()),
									Integer.parseInt(text4.getText()));
							UserDao.update(con, sub);        //�����û��Ķ�������
							/*System.out.println(user.getuEmail());
							new SendMail(user.getuEmail(), "���Ѿ��ɹ�������"+sub.getsNumber()+"��"+MagazineDao.found(con, sub)+","+"������"+sub.getsDtate()+","+"��ӭ�´ι���").start();       //�����ʼ�
*/							/*
							 * op.showMessageDialog(null,"���ĳɹ�����Ҫ"+Integer.parseInt(text3.getText())*
							 * MagazineDao.getPrice(con, sub)+"��������Ļ��˳�.......");
							 */
							int i = JOptionPane
									.showConfirmDialog(null,
											"���ĳɹ�����Ҫ"
													+ Integer.parseInt(text3.getText()) * MagazineDao.getPrice(con, sub)
															* Integer.parseInt(text4.getText())
													+ "\r\n" + "��ȷ���Ƿ�Ҫ��������");
							if (!(JOptionPane.YES_OPTION == i)) { // ѡ����ǹرմ���
								dispose();
							} else { // ��������������Ϊ��
								text1.setText("");
								text2.setText("");
								text3.setText("");
								text4.setText("");
							}
						} else { // ���û��������ڶ��ı���ʱ
							SubscribeDao.insert(con, sub);
							UserDao.update(con, sub);        //�����û��Ķ�������
						/*	new SendMail(user.getuEmail(), "���Ѿ��ɹ�������"+sub.getsNumber()+"��"+MagazineDao.found(con, sub)+","+"������"+sub.getsDtate()+","+"��ӭ�´ι���").start();       //�����ʼ�
*/							// ����ѡ���
							int i = JOptionPane
									.showConfirmDialog(null,
											"���ĳɹ�����Ҫ"
													+ Integer.parseInt(text3.getText()) * MagazineDao.getPrice(con, sub)
															* Integer.parseInt(text4.getText())
													+ "\r\n" + "��ȷ���Ƿ�Ҫ��������");
							if (!(JOptionPane.YES_OPTION == i)) { // ѡ����ǹرմ���
								dispose();
							} else { // ��������������Ϊ��
								text1.setText("");
								text2.setText("");
								text3.setText("");
								text4.setText("");
							}
						}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					con.close();                   //�ر�����
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}                      
			}
		});
		button.setFont(new Font("����", Font.PLAIN, 23));
		
		JButton button_1 = new JButton("���");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {    //��յļ�����
				text1.setText("");
				text2.setText("");
				text3.setText("");
				text4.setText("");
			}
		});
		button_1.setFont(new Font("����", Font.PLAIN, 23));
		
		JButton button_2 = new JButton("ȡ��");
		button_2.addActionListener(new ActionListener() {           //ȡ���ļ�����
			public void actionPerformed(ActionEvent e) {
				dispose();                    //���ٴ��壬����������
			}
		});
		button_2.setFont(new Font("����", Font.PLAIN, 23));
		
		JLabel label_3 = new JLabel("��������");
		label_3.setFont(new Font("����", Font.PLAIN, 23));
		
		text4 = new JTextField();
		text4.setFont(new Font("����", Font.PLAIN, 23));
		text4.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(39, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
							.addGap(214))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(pane, GroupLayout.PREFERRED_SIZE, 528, GroupLayout.PREFERRED_SIZE)
							.addGap(24))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(41)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblNewLabel_1)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(text1, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(label_2)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(box, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_3)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(text4, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap(256, Short.MAX_VALUE)
							.addComponent(button)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(25)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label, Alignment.TRAILING)
								.addComponent(label_1, Alignment.TRAILING))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(text2, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(10)
									.addComponent(text3, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGap(65)
							.addComponent(button_1)
							.addGap(59)
							.addComponent(button_2)
							.addGap(27))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(pane, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addComponent(text1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(label)
						.addComponent(text2, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(32)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(label_1)
									.addComponent(label_2))
								.addComponent(text3, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(29)
							.addComponent(box, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(text4, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_2)
						.addComponent(button_1)
						.addComponent(button))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
		setVisible(true);

	}
}
