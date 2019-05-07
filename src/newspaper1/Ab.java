package newspaper1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JScrollBar;

import JDBC.DB_Connect;
import test01.*;
public class Ab extends JFrame {

	private JPanel contentPane;
	private JTable table;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ab frame = new Ab();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Ab() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 1000, 800);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("用户录入");
		lblNewLabel.setBounds(400, 29, 120, 40);
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		  
		Vector columnNames = new Vector();
		columnNames.add("用户账号");
		columnNames.add("用户密码");
		columnNames.add("用户姓名");
		columnNames.add("性别");
		columnNames.add("地址");
		columnNames.add("电话号码");
		columnNames.add("用户邮箱");
		columnNames.add("用户部门号");
		columnNames.add("订阅数量");
        Vector rowData = new Vector();
        DB_Connect DB=new DB_Connect();
        try {
        	String sql = "SELECT * FROM user";
        	pstmt=DB.getCon().prepareStatement(sql);
        	rs=pstmt.executeQuery();
        	while (rs.next()) {
        		Vector hang=new Vector();
        		hang.add(rs.getString(1));
				hang.add(rs.getString(2));
				hang.add(rs.getString(3));
				hang.add(rs.getString(4));
				hang.add(rs.getString(5));
				hang.add(rs.getString(6));
				hang.add(rs.getString(7));
				hang.add(rs.getInt(8));
				hang.add(rs.getInt(9));
				rowData.add(hang);
        	}
		} catch (Exception e1) {
			e1.printStackTrace();
			}
		DefaultTableModel defaultTableModel = new DefaultTableModel(rowData,columnNames); // 用双数组创建DefaultTableModel对象
        table = new JTable(defaultTableModel);// 创建表格组件
        JTableHeader head = table.getTableHeader(); // 创建表格标题对象
        head.setPreferredSize(new Dimension(head.getWidth(), 35));// 设置表头大小
        head.setFont(new Font("微软雅黑", Font.PLAIN, 18));// 设置表格字体
        table.setRowHeight(30);// 设置表格行宽
		 DefaultTableCellRenderer ter = new DefaultTableCellRenderer()// 设置表格间隔色
	        {
	            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
	                    boolean hasFocus, int row, int column) {
	                if (row % 2 == 0)
	                    setBackground(Color.LIGHT_GRAY);
	                else if (row % 2 == 1)
	                    setBackground(Color.white);
	                return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	            }
	        };
	        for (int i = 0; i < 9; i++) {
				table.getColumn(columnNames.get(i)).setCellRenderer(ter);
	        }
	        table.setEnabled(false);
        JScrollPane scroll=new JScrollPane(table);
		scroll.setBounds(54, 89, 875, 493);
		getContentPane().add(scroll);
	        
	        
		JButton btnNewButton = new JButton("添加");
		btnNewButton.setBounds(480, 610, 120, 36);
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Select1().setVisible(true);
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("刷新");
		btnNewButton_1.setBounds(640, 610, 120, 36);
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Ab().setVisible(true);
			}
		});
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("返回");
		btnNewButton_2.setBounds(800, 610, 120, 36);
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new A().setVisible(true);
			}
		});
		contentPane.add(btnNewButton_2);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1000, 27);
		menuBar.setBackground(Color.WHITE);
		contentPane.add(menuBar);
		JMenu A1 = new JMenu("录入");
		A1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        JMenu A2 = new JMenu("查询");
        A2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        JMenu A3 = new JMenu("统计");
        A3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
  
        JMenuItem A11 = new JMenuItem("用户录入");
        A11.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		setVisible(false);
				new Ab().setVisible(true);
        	}
        });
        A11.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        
        JMenuItem A12 = new JMenuItem("报刊录入");
        A12.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		setVisible(false);
				new Aa().setVisible(true);
        	}
        });
        A12.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        
        
        JMenuItem A13 = new JMenuItem("部门录入");
        A13.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		setVisible(false);
				new Ac().setVisible(true);
        	}
        });
        A13.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        A1.add(A11);
        A1.add(A12);
        A1.add(A13);
        
        JMenuItem A21 = new JMenuItem("用户查询");
        A21.addActionListener(new ActionListener() {
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
        A21.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        JMenuItem A22 = new JMenuItem("报刊查询");
        A22.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		setVisible(false);
				new control3().setVisible(true);
        	}
        });
        A22.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        JMenuItem A23 = new JMenuItem("部门信息");
        A23.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		setVisible(false);
				new control5().setVisible(true);
        	}
        });
        A23.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        A2.add(A21);
        A2.add(A22);
        A2.add(A23);
        
        JMenuItem A31 = new JMenuItem("部门统计");
        A31.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        A31.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		setVisible(false);
				new tongji1().setVisible(true);
        	}
        });
        JMenuItem A32 = new JMenuItem("报刊统计");
        A32.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        A32.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		setVisible(false);
				new tongji2().setVisible(true);
        	}
        });
        /*JMenuItem A33 = new JMenuItem("部门信息");
        A33.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        A33.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		setVisible(false);
				new Tong_department().setVisible(true);
        	}
        });*/
        A3.add(A31);
        A3.add(A32);
       // A3.add(A33);
        
        menuBar.add(A1);
        menuBar.add(A2);
        menuBar.add(A3);        
        
        JMenuItem menuItem = new JMenuItem("用户统计");
        menuItem.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new tongji3().setVisible(true);
        		setVisible(false);
        	}
        });
        menuItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        A3.add(menuItem);
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}		

}
