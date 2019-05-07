package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.UserQueryDao;
import model.User;
import util.Conn;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserQuery extends JInternalFrame {
	private JTextField text1;
	private JTable table;
	private JScrollPane pane;
    private Vector<String> title=new Vector<>();
    private Vector<Vector<String>> data=new Vector<>();
    private ResultSet set;
    private Connection con;
    private DefaultTableModel model=new DefaultTableModel();      //�½�һ��Ĭ������ģ��
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserQuery frame = new UserQuery();
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
	public UserQuery(User user) {
		setTitle("������Ϣ��ѯ");
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 766, 446);
		
		text1 = new JTextField();
		text1.setFont(new Font("����", Font.PLAIN, 23));
		text1.setColumns(10);
		text1.addFocusListener(new FocusListener() {         //������������������
			
			@Override
			public void focusLost(FocusEvent e) {        //ʧȥ����ʱ
				// TODO Auto-generated method stub
				if(text1.getText().equals("")) {
					text1.setForeground(Color.GRAY);          //������ɫ
					text1.setText("��������������˺�");
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {        //��ý���ʱ
				// TODO Auto-generated method stub
				if(text1.getText().equals("��������������˺�")) {
					text1.setText("");                   //��ȡ���������ı���Ϊ��
					text1.setForeground(Color.black);
				}
			}
		});
		JButton btnNewButton = new JButton("����");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {                //�������¼�
				if (text1.getText().equals("")) {                      //�������Ϊ��ʱ
					JOptionPane.showMessageDialog(null, "�㻹δ������������˺�");
				} else if (!text1.getText().equals(user.getuId())) {           //��������˺Ų����Լ���ʱ
					JOptionPane.showMessageDialog(null, "���������Լ����˺�");
				}else {
					con=Conn.getConnection();
                    try {
						if(!UserQueryDao.exist(con, text1.getText())) {             //�����ڸ��û��Ķ�����Ϣ��ʱ��
							JOptionPane.showMessageDialog(null, "�㻹û�ж�����ϢŶ");
						}else {                                //���ڸ��û��Ķ�����Ϣʱ��ӡ��Ϣ
							model.setRowCount(0);                    //��������Ϊ0,���ԭ�е�����
							set=UserQueryDao.get(con, text1.getText());
							while(set.next()) {
								Vector<String> vector=new Vector<>();
								vector.add(set.getString(1));
								vector.add(set.getString(2));
								vector.add(set.getString(3));
								vector.add(set.getString(4));
								vector.add(set.getString(5));
								vector.add(""+set.getInt(6));
								vector.add(""+set.getInt(7));
								vector.add(""+set.getInt(8));
								data.add(vector);
							}
							 model.setDataVector(data, title);        //��������Ϣ����model�У���ʾ����
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setFont(new Font("����", Font.PLAIN, 23));
		
		JButton button = new JButton("����");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {           //���صļ�����
				dispose();
			}
		});
		button.setFont(new Font("����", Font.PLAIN, 23));
		title.add("�û��˺�");
		title.add("�û���");
		title.add("���ı���");
		title.add("����������");
		title.add("������������");
		title.add("�����۸�");
		title.add("��������");
		title.add("��������");
		table = new JTable(model);
		table .getTableHeader().setReorderingAllowed(false);            //�����в����ƶ�
		table.setEnabled(false);   //���ñ�񲻿ɱ༭
		pane=new JScrollPane(table);
	/*	model.setColumnCount(8);                          //�����
		model.addColumn(model);*/
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(240)
					.addComponent(text1, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
					.addGap(63)
					.addComponent(btnNewButton)
					.addGap(18)
					.addComponent(button)
					.addContainerGap(87, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(30, Short.MAX_VALUE)
					.addComponent(pane, GroupLayout.PREFERRED_SIZE, 677, GroupLayout.PREFERRED_SIZE)
					.addGap(43))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(49)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(text1, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(button, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(18)
					.addComponent(pane, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
					.addGap(123))
		);
		getContentPane().setLayout(groupLayout);

	}
}
