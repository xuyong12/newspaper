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

public class control5 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	String name;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					control5 frame = new control5();
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
	public control5() {
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
		menuItem_4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				new control3().setVisible(true);
			}
		});
		menu_1.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("部门查询");
		menuItem_5.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new control5().setVisible(true);
			}
		});
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
		
		JLabel label = new JLabel("部门查询");
		label.setFont(new Font("黑体", Font.PLAIN, 30));
		
		JLabel label_1 = new JLabel("部门号：");
		label_1.setFont(new Font("宋体", Font.PLAIN, 27));
		
		textField = new JTextField();
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
		//String[] header ={ "部门号","部门名"};
		Vector header=new Vector<>();
		header.add("部门号");
		header.add("部门名");
		
		model.setColumnIdentifiers(header);
		try {
			model.setDataVector(new departmentlist().all(), header);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		table=new JTable(model);
		table.getTableHeader().setReorderingAllowed(false);
		
		table.setFont(new Font("宋体", Font.PLAIN, 18));
		table.setRowHeight(30);
		table.updateUI();
		scroll= new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
				
				JButton button = new JButton("检索");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						departmentlist d=null;
						try { 
							d= new departmentlist();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						name=textField.getText();
						if(name.equals("")) {
							JOptionPane.showMessageDialog(null, "请输入部门号");
						}else {
							if(d.compareName(name)) {
								model.setRowCount(0);
								//button.add(btnNihao);
								String[] s=d.Depart(name);
								Vector v=new Vector();
								v.add(s[0]);
								v.add(s[1]);
								
								
								model.addRow(v);
							}else {
								JOptionPane.showMessageDialog(null, "该部门不存在！");
							}
						}
						

					}
				});
				button.setFont(new Font("宋体", Font.PLAIN, 20));
				
				JButton button_1 = new JButton("返回");
				button_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new A().setVisible(true);
						dispose();
					}
				});
				button_1.setFont(new Font("宋体", Font.PLAIN, 20));
		
		
		
				GroupLayout gl_contentPane = new GroupLayout(contentPane);
				gl_contentPane.setHorizontalGroup(
					gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap(444, Short.MAX_VALUE)
							.addComponent(label)
							.addGap(420))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(181)
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
							.addGap(46)
							.addComponent(button)
							.addGap(61)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(226, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap(49, Short.MAX_VALUE)
							.addComponent(scroll, GroupLayout.PREFERRED_SIZE, 895, GroupLayout.PREFERRED_SIZE)
							.addGap(40))
				);
				gl_contentPane.setVerticalGroup(
					gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(60)
							.addComponent(label)
							.addGap(29)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_1)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addComponent(button, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
								.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
							.addGap(55)
							.addComponent(scroll, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(256, Short.MAX_VALUE))
				);
				
				
		contentPane.setLayout(gl_contentPane);
	}

}
