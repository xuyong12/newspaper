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
		setTitle("��������ϵͳ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(600, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		/*
		 * contentPane.setOpaque(false); //��JPanel����Ϊ͸�� �����Ͳ�����ס����ı��� �����������JPanel����������
		 */ contentPane.setLayout(null); // ���ò���Ϊ��
		/*ImageIcon icon = new ImageIcon("2.jpg"); // ����ͼƬ
		JLabel j = new JLabel(icon);
		// ��ͼƬ�����ǩ��
		
		 * j.setBounds(0, 0, 600,600); //���ô�СΪ�����С
		  contentPane.add(j, new Integer(Integer.MIN_VALUE)); // ����ǩ���������
		j.setBounds(0, 30, 690, 589);*/
		JLabel label = new JLabel("��ӭʹ�ñ�������ϵͳ");
		label.setIcon(new ImageIcon("timg.jpg"));         //����Сͼ��
		label.setFont(new Font("����", Font.PLAIN, 44));
		label.setBounds(74, 153, 643, 49);
		contentPane.add(label);
		JButton btnNewButton_1 = new JButton("�û����");
		btnNewButton_1.setBounds(335, 303, 187, 35);
		btnNewButton_1.setFont(new Font("����", Font.PLAIN, 23));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserLog user = new UserLog();
				user.setVisible(true);
				dispose(); // �ر��������
			}
		});
		contentPane.add(btnNewButton_1);
		JButton button = new JButton("�������");
		button.setBounds(97, 303, 179, 35);
		button.addActionListener(new ActionListener() { // ������ڵļ�����
			public void actionPerformed(ActionEvent e) {
				new control(); // �򿪹����ڵĽ���
				setVisible(false); // �رյ�ǰ��ͼ
			}
		});
		button.setFont(new Font("����", Font.PLAIN, 23));
		contentPane.add(button);
		/*btnNewButton_1.repaint();         //�ڻ滭һ��
*/	   
		}
}
