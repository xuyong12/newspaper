package test01;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import newspaper1.A;
import view.Select;

import javax.swing.JButton;

public class control extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		new control();
	}

	/**
	 * Create the frame.
	 */
	public control() {
		JFrame f = new JFrame("�������Ĺ���ϵͳ--����Ա��¼");
		f.getContentPane().setFont(new Font("΢���ź� Light", Font.PLAIN, 27));
		f.setSize(600, 600);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(3);
		f.setResizable(false);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);// ��ʾ��������
			}
		});

		JLabel label = new JLabel("��ӭ��¼�������");
		label.setFont(new Font("����", Font.PLAIN, 47));

		JLabel label_1 = new JLabel("�˺ţ�");
		label_1.setFont(new Font("΢���ź�", Font.PLAIN, 24));

		JLabel label_2 = new JLabel("����Ա����");
		label_2.setFont(new Font("΢���ź�", Font.PLAIN, 24));

		textField_1 = new JTextField();
		textField_1.setFont(new Font("����", Font.PLAIN, 23));
		textField_1.setColumns(10);

		JLabel label_3 = new JLabel("���룺");
		label_3.setFont(new Font("΢���ź�", Font.PLAIN, 24));

		textField_2 = new JPasswordField();
		textField_2.setFont(new Font("����", Font.PLAIN, 23));
		textField_2.setColumns(10);

		JButton button = new JButton("��¼");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 Adminuser d = null;
				try { 
					d = new Adminuser();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String id=textField.getText();
				String name=textField_1.getText();
				String password=textField_2.getText();
				if(id.equals("")) {
					JOptionPane.showMessageDialog(control.this, "���������Ա�˺�");
				}else {
					textField_1.grabFocus();
					if(name.equals("")) {
						JOptionPane.showMessageDialog(control.this, "���������Ա��");
					}else {
						textField_2.grabFocus();
						if(password.equalsIgnoreCase("")) {
							JOptionPane.showMessageDialog(control.this, "����������");
						}
					}
				}
				if(d.compare(id,name,password)) {
					f.setVisible(false);
					//new control2().setVisible(true);
					new A().setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "��������ȷ�Ĺ���Ա��¼��Ϣ��");
				}
				
				
				
				/*if(!id.equals("")&&!name.equals("")&&!password.equalsIgnoreCase("")) {
					
				
				}*/
			}
		});
		button.setFont(new Font("����", Font.PLAIN, 20));
		
		JButton button_1 = new JButton("����");
		button_1.setFont(new Font("����", Font.PLAIN, 20));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {   //����
				f.setVisible(false);
				new Select().setVisible(true);
			}
		});
		
		textField = new JTextField();
		textField.setFont(new Font("����", Font.PLAIN, 23));
		textField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(f.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(116, Short.MAX_VALUE)
					.addComponent(label)
					.addGap(102))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(98)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label_2)
						.addComponent(label_3)
						.addComponent(label_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addContainerGap(186, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(517, Short.MAX_VALUE)
					.addComponent(button_1)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(94)
					.addComponent(label)
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addComponent(button)
					.addPreferredGap(ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
					.addComponent(button_1)
					.addContainerGap())
		);
		f.getContentPane().setLayout(groupLayout);

		f.setVisible(true);
		
		
	}
}
