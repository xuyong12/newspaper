package test01;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import newspaper1.*;

public class control4 extends JFrame {


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
					control4 frame = new control4();
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
	 * @throws SQLException 
	 */
	public control4() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);
		setResizable(false);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("¼��");
		menu.setFont(new Font("����", Font.PLAIN, 20));
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("�û�¼��");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Ab().setVisible(true);
			}
		});
		menuItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("����¼��");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Aa().setVisible(true);
			}
		});
		menuItem_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menu.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("����¼��");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Ac().setVisible(true);
			}
		});
		menuItem_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menu.add(menuItem_2);
		
		JMenu menu_1 = new JMenu("��ѯ");
		menu_1.setFont(new Font("����", Font.PLAIN, 20));
		menuBar.add(menu_1);
		
		JMenuItem menuItem_3 = new JMenuItem("�û���ѯ");
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
		
		JMenuItem menuItem_4 = new JMenuItem("������ѯ");
		menuItem_4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				new control3().setVisible(true);
			}
		});
		
		menu_1.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("���Ų�ѯ");
		menuItem_5.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new control5().setVisible(true);
			}
		});
		
		menu_1.add(menuItem_5);
		
		JMenu menu_2 = new JMenu("ͳ��");
		menu_2.setFont(new Font("����", Font.PLAIN, 20));
		menuBar.add(menu_2);
		
		JMenuItem menuItem_7 = new JMenuItem("����ͳ��");
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new tongji1().setVisible(true);
			}
		});
		menuItem_7.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menu_2.add(menuItem_7);
		
		JMenuItem menuItem_8 = new JMenuItem("����ͳ��");
		menuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new tongji2().setVisible(true);
			}
		});
		menuItem_8.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menu_2.add(menuItem_8);
		
		JMenuItem menuItem_6 = new JMenuItem("�û�ͳ��");
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
		
		JLabel label = new JLabel("�û���ѯ");
		label.setFont(new Font("����", Font.PLAIN, 30));
		
		JLabel label_1 = new JLabel("�û��˺ţ�");
		label_1.setFont(new Font("����", Font.PLAIN, 27));
		
		textField = new JTextField();
		textField.setFont(new Font("����", Font.PLAIN, 23));
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField.setColumns(10);
		JButton button = new JButton("����");
		button.setFont(new Font("����", Font.PLAIN, 20));
		
		DefaultTableModel model = new DefaultTableModel() {public boolean isCellEditable(int row, int column){
			return false;
		}};
		
		//Object[][] obj=new Object[1][4];
		JScrollPane scroll;
		Vector header =new Vector();//{ "�û��˺�","�û�����","�û���","�û��Ա�","�û���ַ","�û��绰","�û�����","�û����ź�","�û���������" };
		header.add("�û��˺�");
		header.add("�û�����");
		header.add("�û���");
		header.add("�û��Ա�");
		header.add("�û���ַ");
		header.add("�û��绰");
		header.add("�û�����");
		header.add("�û����ź�");
		header.add("�û���������");
		model.setColumnIdentifiers(header);
		model.setDataVector(new userslist().all(), header);
		
		Vector v=new Vector();
		//scroll=new JScrollPane(table);
		/*try {
			v.add(new userslist().all());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		button.addActionListener(new ActionListener() {
			
public void actionPerformed(ActionEvent arg0) {
				
				userslist m=null;
				try { 
					m= new userslist();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				name=textField.getText();
				if(name.equals("")) {
					JOptionPane.showMessageDialog(null, "�������û��˺�");
				}else {
					if(m.compareName(name)) {
						model.setRowCount(0);
						//button.add(btnNihao);
						String[] s=m.U(name);
						Vector v=new Vector();
						v.add(s[0]);
						v.add(s[1]);
						v.add(s[2]);
						v.add(s[3]);
						v.add(s[4]);
						v.add(s[5]);
						v.add(s[6]);
						v.add(s[7]);
						v.add(s[8]);
						
						model.addRow(v);
					}else {
						JOptionPane.showMessageDialog(null, "���û������ڣ�");
					}
				}
				

			}
		});
		
		table=new JTable(model);
		table.getTableHeader().setReorderingAllowed(false);
		//JTableHeader h=table.getTableHeader();
		//h.setPreferredSize(new Dimension(h.getWidth(), 35));
		//h.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		table.getColumn("�û��˺�").setPreferredWidth(100);
		table.getColumn("�û�����").setPreferredWidth(200);
		table.getColumn("�û���").setPreferredWidth(100);
		table.getColumn("�û��Ա�").setPreferredWidth(100);
		table.getColumn("�û���ַ").setPreferredWidth(200);
		table.getColumn("�û��绰").setPreferredWidth(200);
		table.getColumn("�û�����").setPreferredWidth(200);
		table.getColumn("�û����ź�").setPreferredWidth(150);
		table.getColumn("�û���������").setPreferredWidth(150);
		   table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setFont(new Font("����", Font.PLAIN, 18));
		table.setRowHeight(30);
		//String[] header ={ "�û��˺�","�û�����","�û���","�û��Ա�","�û���ַ","�û��绰","�û�����","�û����ź�","�û���������" };
		
		
		table.updateUI();
		//scroll=new JScrollPane(table);
		scroll= new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		JButton button_1 = new JButton("ɾ��");
		button_1.setFont(new Font("����", Font.PLAIN, 20));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (-1 == table.getSelectedRow()) {
					JOptionPane.showMessageDialog(null, "��ѡ����Ҫɾ���Ķ���");
				} else {
					userslist u = null;
					try {
						// m= new magazinelist();
						u = new userslist();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					int index = table.getSelectedRow();
					String uID = (String) table.getValueAt(index, 0);
					try {
						u.delete(uID);
						u.delete2(uID);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					model.removeRow(index);
				}
				setVisible(false);
				try {
					new control4().setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
				
				JButton button_2 = new JButton("����");
				button_2.setFont(new Font("����", Font.PLAIN, 20));
				button_2.addActionListener(new ActionListener() {
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
							.addGap(18)
							.addComponent(button_2)
							.addContainerGap(150, Short.MAX_VALUE))
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
								.addComponent(button_1)
								.addComponent(button_2))
							.addGap(55)
							.addComponent(scroll, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(256, Short.MAX_VALUE))
				);
		contentPane.setLayout(gl_contentPane);
	}
}
