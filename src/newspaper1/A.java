package newspaper1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import test01.*;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.sql.SQLException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;

import java.awt.Component;

import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class A extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					A frame = new A();
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
	public A() {
		setTitle("报刊订阅系统--系统管理员");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 1000, 800);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("系统管理员界面");
		lblNewLabel.setBounds(289, 45, 350, 64);
		lblNewLabel.setForeground(new Color(32, 178, 170));
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 35));
		contentPane.add(lblNewLabel);
		
		
		ImageIcon icon=new ImageIcon("1.jpg");
		JLabel lblNewLabel_1 = new JLabel(icon);
		lblNewLabel_1.setBounds(97, 158, 796, 496);
		contentPane.add(lblNewLabel_1);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		menuBar.setBounds(0, 0, 994, 29);
		contentPane.add(menuBar);
		JMenu A1 = new JMenu("录入");
		A1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        JMenu A2 = new JMenu("查询");
        A2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        JMenu A3 = new JMenu("统计");
        A3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
       
        JMenuItem A11 = new JMenuItem("用户录入");
        A11.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
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
        JMenuItem A23 = new JMenuItem("部门查询");
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
        
        JButton jb=new JButton("返回");
        jb.setFont(new Font("宋体", Font.PLAIN, 20));
        jb.setBounds(800, 50, 80,30);
        contentPane.add(jb);
        jb.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		setVisible(false);
        		new control().setVisible(true);
        	}
        });
        /*JMenuItem A33 = new JMenuItem("����ͳ��");
        A33.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        A33.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		setVisible(false);
				new Tong_department().setVisible(true);
        	}
        });*/
        A3.add(A31);
        A3.add(A32);
        //A3.add(A33);
        
        menuBar.add(A1);
        menuBar.add(A2);
        menuBar.add(A3);
        
        JMenuItem menuItem = new JMenuItem("用户统计");
        menuItem.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {            //用户统计的事件监听器
        		new tongji3().setVisible(true);
        		setVisible(false);
        	}
        });
        menuItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        A3.add(menuItem);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
