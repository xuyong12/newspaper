package test01;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import newspaper1.*;
import test01.userslist;

public class tongji1 extends JFrame {

	
	private JPanel contentPane;
	private JTextField textField;
	String name;
	private JTable table;
	
	private JTextField textField_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tongji1 frame = new tongji1();
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
	public tongji1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);
		setResizable(false);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("录入");
		menu.setFont(new Font("宋体", Font.PLAIN, 20));
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("用户录入");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Ab().setVisible(true);
			}
		});
		menuItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("报刊录入");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Aa().setVisible(true);
			}
		});
		menuItem_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menu.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("部门录入");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Ac().setVisible(true);
			}
		});
		menuItem_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menu.add(menuItem_2);
		
		JMenu menu_1 = new JMenu("查询");
		menu_1.setFont(new Font("宋体", Font.PLAIN, 20));
		menuBar.add(menu_1);
		
		JMenuItem menuItem_3 = new JMenuItem("用户查询");
		menuItem_3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				try {
					new control4().setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		menu_1.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("报刊查询");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new control3().setVisible(true);
			}
		});
		menuItem_4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		
		menu_1.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("部门查询");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new control5().setVisible(true);
			}
		});
		menuItem_5.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		
		menu_1.add(menuItem_5);
		
		JMenu menu_2 = new JMenu("统计");
		menu_2.setFont(new Font("宋体", Font.PLAIN, 20));
		menuBar.add(menu_2);
		
		JMenuItem menuItem_7 = new JMenuItem("部门统计");
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new tongji1().setVisible(true);
			}
		});
		menuItem_7.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menu_2.add(menuItem_7);
		
		JMenuItem menuItem_8 = new JMenuItem("报刊统计");
		menuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new tongji2().setVisible(true);
			}
		});
		menuItem_8.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menu_2.add(menuItem_8);
		
		JMenuItem menuItem_6 = new JMenuItem("用户统计");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new tongji3().setVisible(true);
        		setVisible(false);
			}
		});
		menuItem_6.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menu_2.add(menuItem_6);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("部门统计");
		label.setBounds(449, 65, 120, 35);
		label.setFont(new Font("黑体", Font.PLAIN, 30));
		
		JLabel label_1 = 
				new JLabel("部门号：");
		label_1.setBounds(186, 129, 108, 32);
		label_1.setFont(new Font("宋体", Font.PLAIN, 27));
		
		textField = new JTextField();
		textField.setBounds(308, 131, 193, 34);
		textField.setFont(new Font("宋体", Font.PLAIN, 20));
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField.setColumns(10);
		
		DefaultTableModel model = new DefaultTableModel() {public boolean isCellEditable(int row, int column){
			return false;
		}};
		
		//Object[][] obj=new Object[1][4];
		JScrollPane scroll;
		Vector header =new Vector();//{ "用户账号","用户密码","用户名","用户性别","用户地址","用户电话","用户邮箱","用户部门号","用户订阅数量" };
		header.add("部门号");
		header.add("部门名");
		header.add("用户账号");
		header.add("用户名");
		header.add("用户性别");
		header.add("用户订阅数量");
		model.setColumnIdentifiers(header);
		try {
			model.setDataVector(new view_1().all(), header);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//scroll=new JScrollPane(table);
		//N n=new N();
		textField_1 = new JTextField();
		textField_1.setFont(new Font("宋体", Font.PLAIN, 20));
		textField_1.setBounds(756, 570, 120, 27);
		
		table=new JTable(model);
		table.getTableHeader().setReorderingAllowed(false);
	
		table.setFont(new Font("宋体", Font.PLAIN, 18));
		table.setRowHeight(30);
		//String[] header ={ "用户账号","用户密码","用户名","用户性别","用户地址","用户电话","用户邮箱","用户部门号","用户订阅数量" };
		
		
		table.updateUI();
		//scroll=new JScrollPane(table);
		scroll= new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(54, 220, 895, 258);
		contentPane.setLayout(null);
		contentPane.add(label);
		contentPane.add(label_1);
		contentPane.add(textField);
		contentPane.add(scroll);
		
		JLabel lblNewLabel = new JLabel("订阅报刊总数：");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(613, 554, 140, 54);
		contentPane.add(lblNewLabel);
		
		
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton button = new JButton("检索");
		button.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent arg0) {
				

				view_1 view=null;
				try { 

					view=new view_1();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				name=textField.getText();System.out.println(name);
				if(name.equals("")) {
					JOptionPane.showMessageDialog(null, "请输入部门号");
				}else {
					//if(m.compareName(name)) {
					if(view.compare(name)) {
						model.setRowCount(0);

						model.setDataVector(view.select(name),header);

						int y=table.getRowCount();
						int number=0;
						int j;
						for( j=0;j<y;j++) {
							String str=(String)table.getValueAt(j, 5);
							int tv=Integer.parseInt(str);

							number+=tv;
						}
						String nn=String.valueOf(number);
						textField_1.setText(nn);
						
					}else {
						JOptionPane.showMessageDialog(null, "该部门不存在！");
					}
				}
				

			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 20));
		button.setBounds(566, 132, 83, 33);
		contentPane.add(button);
		
		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new A().setVisible(true);
				dispose();
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 20));
		button_1.setBounds(714, 132, 83, 33);
		contentPane.add(button_1);
	}
}
