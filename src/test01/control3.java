package test01;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import newspaper1.*;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class control3 extends JFrame {

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
					control3 frame = new control3();
					frame.setVisible(true);
					System.out.println();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the frame.
	 */
	public control3() {
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
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				try {
					new control4().setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
		
		JLabel label = new JLabel("报刊查询");
		label.setFont(new Font("黑体", Font.PLAIN, 30));
		
		JLabel label_1 = new JLabel("报刊号：");
		label_1.setFont(new Font("宋体", Font.PLAIN, 27));
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 23));
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField.setColumns(10);
		JButton button = new JButton("检索");
		button.setFont(new Font("宋体", Font.PLAIN, 20));
		
		DefaultTableModel model = new DefaultTableModel() {public boolean isCellEditable(int row, int column){
			return false;
		}};
		
		//Object[][] obj=new Object[1][4];
		JScrollPane scroll;
		Vector header =new Vector<>();
		header.add("报刊号");
		header.add("报刊名");
		header.add("出版日期");
		header.add("出版社");
		header.add("价格");
		
		model.setColumnIdentifiers(header);
		try {
			model.setDataVector(new magazinelist().all(),header);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//scroll=new JScrollPane(table);
		
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				magazinelist m=null;
				try { 
					m= new magazinelist();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				name=textField.getText();
				if(name.equals("")) {
					JOptionPane.showMessageDialog(null, "请输入报刊号");
				}else {
					if(m.compareName(name)) {
						model.setRowCount(0);
						//button.add(btnNihao);
						String[] s=m.TablePublish(name);
						Vector v=new Vector();
						v.add(s[0]);
						v.add(s[1]);
						v.add(s[2]);
						v.add(s[3]);
						v.add(s[4]);
						
						model.addRow(v);
					}else {
						JOptionPane.showMessageDialog(null, "该报刊不存在！");
					}
				}
				

			}
		});
		
		table=new JTable(model);
		table.getTableHeader().setReorderingAllowed(false);
		table.getColumn("报刊号").setPreferredWidth(150);
		table.getColumn("报刊名").setPreferredWidth(150);
		table.getColumn("出版日期").setPreferredWidth(300);
		table.getColumn("出版社").setPreferredWidth(200);
		table.getColumn("价格").setPreferredWidth(100);
		table.setFont(new Font("宋体", Font.PLAIN, 18));
		table.setRowHeight(30);
		table.updateUI();
		scroll= new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		JButton button_1 = new JButton("返回");
		button_1.setFont(new Font("宋体", Font.PLAIN, 20));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
        		setVisible(false);
        		new A().setVisible(true);
			}
		});
		
		
		
				GroupLayout gl_contentPane = new GroupLayout(contentPane);
				gl_contentPane.setHorizontalGroup(
					gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap(444, Short.MAX_VALUE)
							.addComponent(label)
							.addGap(420))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(181)
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
							.addGap(52)
							.addComponent(button)
							.addGap(29)
							.addComponent(button_1)
							.addContainerGap(281, Short.MAX_VALUE))
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
								.addComponent(button)
								.addComponent(button_1))
							.addGap(55)
							.addComponent(scroll, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(256, Short.MAX_VALUE))
				);
				
				
		contentPane.setLayout(gl_contentPane);
	}
	
}
