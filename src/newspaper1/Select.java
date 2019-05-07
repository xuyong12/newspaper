package newspaper1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Font;

import javax.swing.JButton;

import JDBC.Connect_newspaper;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.util.Date;

public class Select extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

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

	public Select() {
		setTitle("添加");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 468);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 20));
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("宋体", Font.PLAIN, 20));
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("宋体", Font.PLAIN, 20));
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("宋体", Font.PLAIN, 20));
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setFont(new Font("宋体", Font.PLAIN, 20));
		textField_4.setColumns(10);

		JLabel label = new JLabel("报刊编号");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 20));

		JLabel label_1 = new JLabel("报刊名称");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));

		JLabel label_2 = new JLabel("出版日期");
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 20));

		JLabel label_3 = new JLabel("出版社名称");
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 20));

		JLabel label_4 = new JLabel("报刊价格");
		label_4.setFont(new Font("微软雅黑", Font.PLAIN, 20));

		JButton btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Aa_add a = new Aa_add();				
				String text = textField.getText();				
				String text_1 = textField_1.getText();				
				String text_2 = textField_2.getText();				
				String text_3 = textField_3.getText();				
				String text_4 = textField_4.getText();
				
				if (text.equals("") || text_1.equals("") || text_2.equals("")
						|| text_3.equals("") || text_4.equals("")) {
					JOptionPane.showMessageDialog(null, "不能输入为空");
				}else if(!text.matches("\\d+")) {
					JOptionPane.showMessageDialog(null, "报刊编号格式不对，请输入正确的把报刊编号");
					textField.setText("");
				}else if(text_1.matches("\\d+")) {
					JOptionPane.showMessageDialog(null, "报刊名称格式不正确，请重新输入");
					textField_1.setText("");
				}else if(!text_2.matches("\\d{4}-\\d{2}-\\d+")) {
					JOptionPane.showMessageDialog(null, "出版日期的格式不对，请重新输入");
					textField_2.setText("");
				}else if(text_3.matches("\\d+")) {
					JOptionPane.showMessageDialog(null, "出版社名称不能为数字");
					textField_3.setText("");
				}else if(!text_4.matches("\\d+")) {
					JOptionPane.showMessageDialog(null, "报刊价格格式不对，请重新输入");
					textField_4.setText("");
				}
				else{
					a.setmID(text);
					a.setmName(text_1);
					a.setmDate(text_2);
					a.setPublishName(text_3);
					a.setPrice(text_4);
					Connect_newspaper c=new Connect_newspaper();
					c.aaaa(a);
					JOptionPane.showMessageDialog(null, "录入成功");
					/*setVisible(false);*/
					dispose();
				}
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JButton button = new JButton("返回");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(51)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addComponent(label_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(label_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(label_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(label_3))
					.addGap(113)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(textField_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
						.addComponent(textField_1, Alignment.LEADING, 199, 199, 199)
						.addComponent(textField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
						.addComponent(textField_2, Alignment.LEADING, 199, 199, 199)
						.addComponent(textField_3, Alignment.LEADING, 199, 199, 199))
					.addGap(54)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(button, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
					.addGap(65))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addGap(41)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label_2)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3))
					.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4))
					.addGap(21))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(156)
					.addComponent(btnNewButton)
					.addGap(69)
					.addComponent(button)
					.addContainerGap(120, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
