package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import test01.control;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window.Type;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Select extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Select frame = new Select();
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
	public Select() {
		setResizable(false);
		setTitle("报刊订阅系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(600, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		/*
		 * contentPane.setOpaque(false); //把JPanel设置为透明 这样就不会遮住后面的背景 这样你就能在JPanel随意加组件了
		 */ contentPane.setLayout(null); // 设置布局为空
		/*ImageIcon icon = new ImageIcon("2.jpg"); // 设置图片
		JLabel j = new JLabel(icon);
		// 将图片加入标签中
		
		 * j.setBounds(0, 0, 600,600); //设置大小为窗体大小
		  contentPane.add(j, new Integer(Integer.MIN_VALUE)); // 将标签加入面板中
		j.setBounds(0, 30, 690, 589);*/
		JLabel label = new JLabel("欢迎使用报刊订阅系统");
		label.setIcon(new ImageIcon("timg.jpg"));         //设置小图标
		label.setFont(new Font("宋体", Font.PLAIN, 44));
		label.setBounds(74, 153, 643, 49);
		contentPane.add(label);
		JButton btnNewButton_1 = new JButton("用户入口");
		btnNewButton_1.setBounds(335, 303, 187, 35);
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 23));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserLog user = new UserLog();
				user.setVisible(true);
				dispose(); // 关闭这个窗口
			}
		});
		contentPane.add(btnNewButton_1);
		JButton button = new JButton("管理入口");
		button.setBounds(97, 303, 179, 35);
		button.addActionListener(new ActionListener() { // 管理入口的监听器
			public void actionPerformed(ActionEvent e) {
				new control(); // 打开管理窗口的界面
				setVisible(false); // 关闭当前视图
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 23));
		contentPane.add(button);
		/*btnNewButton_1.repaint();         //在绘画一次
*/	   
		}
}
