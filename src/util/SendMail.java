package util;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class SendMail extends Thread{
	String mail;
	String say;
	public SendMail(String mail,String say) {
		// 做链接前的准备工作 也就是参数初始化
		this.mail=mail;
		this.say=say;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Properties properties = new Properties();
		properties.setProperty("mail.smtp.host", "smtp.qq.com");        // 发送邮箱服务器
		properties.setProperty("mail.smtp.port", "465");         // 发送端口
		properties.setProperty("mail.smtp.auth", "true");     // 是否开启权限控制
		/*properties.setProperty("mail.debug", "true");           // true 打印信息到控制台
*/		properties.setProperty("mail.transport", "smtp");      // 发送的协议是简单的邮件传输协议
		properties.setProperty("mail.smtp.ssl.enable", "true");
		// 建立两点之间的链接
	/*	System.out.println("执行了2");*/
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("1771560366@qq.com", "zabjgsngfvkajjgg");        //设置发件人的账号密码
			}
		});
	/*	System.out.println("执行了3");*/
		// 创建邮件对象
		Message message = new MimeMessage(session);
		// 设置发件人
		try {
			message.setFrom(new InternetAddress("1771560366@qq.com"));

			// 设置收件人
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(mail));// 收件人
			// 设置主题
			message.setSubject("注册成功");
			// 设置邮件正文 第二个参数是邮件发送的类型
			message.setContent(say, "text/html;charset=UTF-8");
			// 发送一封邮件
			Transport transport = session.getTransport();
			transport.connect(mail, "xxxxxda");
			Transport.send(message);
			/*System.out.println("执行了");*/
		} catch (MessagingException e) {
			e.printStackTrace();
		} finally {
             
		}
	}

	/*public static void main(String[] args) {
		System.out.println("执行了1");
		SendMail SendMail = new SendMail();
	}*/
}