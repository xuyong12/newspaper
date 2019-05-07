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
    private DefaultTableModel model=new DefaultTableModel();      //新建一个默认数据模型
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
		setTitle("订阅信息查询");
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 766, 446);
		
		text1 = new JTextField();
		text1.setFont(new Font("宋体", Font.PLAIN, 23));
		text1.setColumns(10);
		text1.addFocusListener(new FocusListener() {         //设置输入框里面的内容
			
			@Override
			public void focusLost(FocusEvent e) {        //失去焦点时
				// TODO Auto-generated method stub
				if(text1.getText().equals("")) {
					text1.setForeground(Color.GRAY);          //设置颜色
					text1.setText("请输入你检索的账号");
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {        //获得焦点时
				// TODO Auto-generated method stub
				if(text1.getText().equals("请输入你检索的账号")) {
					text1.setText("");                   //获取焦点设置文本框为空
					text1.setForeground(Color.black);
				}
			}
		});
		JButton btnNewButton = new JButton("检索");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {                //检索的事件
				if (text1.getText().equals("")) {                      //当输入框为空时
					JOptionPane.showMessageDialog(null, "你还未输入你检索的账号");
				} else if (!text1.getText().equals(user.getuId())) {           //当输入的账号不是自己的时
					JOptionPane.showMessageDialog(null, "请输入你自己的账号");
				}else {
					con=Conn.getConnection();
                    try {
						if(!UserQueryDao.exist(con, text1.getText())) {             //不存在该用户的订阅信息的时候
							JOptionPane.showMessageDialog(null, "你还没有订阅信息哦");
						}else {                                //存在该用户的订阅信息时打印信息
							model.setRowCount(0);                    //设置行数为0,清空原有的数据
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
							 model.setDataVector(data, title);        //将订阅信息传入model中，显示出来
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 23));
		
		JButton button = new JButton("返回");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {           //返回的监听器
				dispose();
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 23));
		title.add("用户账号");
		title.add("用户名");
		title.add("订阅报刊");
		title.add("报刊出版社");
		title.add("报刊出版日期");
		title.add("报刊价格");
		title.add("订阅数量");
		title.add("订阅天数");
		table = new JTable(model);
		table .getTableHeader().setReorderingAllowed(false);            //设置列不可移动
		table.setEnabled(false);   //设置表格不可编辑
		pane=new JScrollPane(table);
	/*	model.setColumnCount(8);                          //添加列
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
