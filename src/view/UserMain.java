package view;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollBar;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.event.MenuListener;

import dao.UserDao;
import model.User;
import util.Conn;

import javax.swing.event.MenuEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;

public class UserMain extends JFrame {
	private JDesktopPane desktop;
	/*Image image = null;          //设置图片
*/	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserMain frame = new UserMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public UserMain(User user) {
		setResizable(false);
		UserMain main=this;                      //获取当前对象
		setTitle("用户主界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 800);
    	//setExtendedState(JFrame.MAXIMIZED_BOTH);         //设置窗体最大化
		/*setAlwaysOnTop(true);         //总在前面
*/		/*this.setSize(Toolkit.getDefaultToolkit().getScreenSize()); */         //根据当前屏幕的分辨率设置为最大化
		setLocationRelativeTo(null);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu mnNewMenu = new JMenu("信息修改");
		mnNewMenu.addMouseListener(new MouseAdapter() {                       //信息修改的监听器
			@Override
			public void mouseClicked(MouseEvent e) {  
				Connection con=Conn.getConnection();
				Chance chance=new Chance(user,main);         //传入个user和登陆时创建的主界面
				ResultSet set=null;
				try {
					 set=UserDao.sp(con, user.getuId());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}try {                     //一点入就传入信息         
					while(set.next()) {
						chance.getText1().setText(set.getString(1));
						chance.getText2().setText(set.getString(2));
						chance.getText3().setText(set.getString(8));
						chance.getText4().setText(set.getString(5));
						chance.getText5().setText(set.getString(3));
						chance.getText6().setText(set.getString(6));
						chance.getText7().setText(set.getString(7));
						if(set.getString(4).equals("男")) {
							chance.getRadio1().setSelected(true);
						}else {
							chance.getRadio2().setSelected(true);
						}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				chance.setVisible(true);
				chance.getText1().setEditable(false);                   //设置用户账号为不可改动
				desktop.add(chance);
				try {
					set.close();        //关闭资源
					con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnNewMenu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("订阅报刊");
		mnNewMenu_1.addMouseListener(new MouseAdapter() {          //订阅报刊的监听器
			@Override
			public void mouseClicked(MouseEvent e) {
				Buy buy=new Buy(user);
				desktop.add(buy);
				buy.setVisible(true);
			}
		});
		
		mnNewMenu_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_2 = new JMenu("查询订阅信息");
		mnNewMenu_2.addMouseListener(new MouseAdapter() {         //查询订单的监听器
			@Override
			public void mouseClicked(MouseEvent e) {
				UserQuery query=new UserQuery(user);
				desktop.add(query);
				query.setVisible(true);
			}
		});
		mnNewMenu_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menuBar.add(mnNewMenu_2);
		
		JMenu mnNewMenu_4 = new JMenu("更改登陆");
		mnNewMenu_4.addMouseListener(new MouseAdapter() {    //跟改登陆的事件管理器
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new UserLog().setVisible(true);
			}
		});
		
		mnNewMenu_4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menuBar.add(mnNewMenu_4);
	/*	try {
			 image=ImageIO.read(new File("6.jpg"));
			 
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}                //加载图片
*/		desktop = new JDesktopPane();/*{
			@Override
			protected void paintChildren(Graphics g) {
				// TODO Auto-generated method stub
				super.paintChildren(g);
				g.drawImage(image,   0,   0,   getWidth(),   getHeight(),   this);
			}
		};*/
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(menuBar, GroupLayout.PREFERRED_SIZE, 1920, GroupLayout.PREFERRED_SIZE)
				.addComponent(desktop, GroupLayout.PREFERRED_SIZE, 972, GroupLayout.PREFERRED_SIZE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(menuBar, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(desktop, GroupLayout.PREFERRED_SIZE, 713, GroupLayout.PREFERRED_SIZE)
					.addGap(137))
		);
		desktop.setLayout(null);
		contentPane.setLayout(gl_contentPane);
	}
}
