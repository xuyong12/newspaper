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
		// ������ǰ��׼������ Ҳ���ǲ�����ʼ��
		this.mail=mail;
		this.say=say;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Properties properties = new Properties();
		properties.setProperty("mail.smtp.host", "smtp.qq.com");        // �������������
		properties.setProperty("mail.smtp.port", "465");         // ���Ͷ˿�
		properties.setProperty("mail.smtp.auth", "true");     // �Ƿ���Ȩ�޿���
		/*properties.setProperty("mail.debug", "true");           // true ��ӡ��Ϣ������̨
*/		properties.setProperty("mail.transport", "smtp");      // ���͵�Э���Ǽ򵥵��ʼ�����Э��
		properties.setProperty("mail.smtp.ssl.enable", "true");
		// ��������֮�������
	/*	System.out.println("ִ����2");*/
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("1771560366@qq.com", "zabjgsngfvkajjgg");        //���÷����˵��˺�����
			}
		});
	/*	System.out.println("ִ����3");*/
		// �����ʼ�����
		Message message = new MimeMessage(session);
		// ���÷�����
		try {
			message.setFrom(new InternetAddress("1771560366@qq.com"));

			// �����ռ���
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(mail));// �ռ���
			// ��������
			message.setSubject("ע��ɹ�");
			// �����ʼ����� �ڶ����������ʼ����͵�����
			message.setContent(say, "text/html;charset=UTF-8");
			// ����һ���ʼ�
			Transport transport = session.getTransport();
			transport.connect(mail, "xxxxxda");
			Transport.send(message);
			/*System.out.println("ִ����");*/
		} catch (MessagingException e) {
			e.printStackTrace();
		} finally {
             
		}
	}

	/*public static void main(String[] args) {
		System.out.println("ִ����1");
		SendMail SendMail = new SendMail();
	}*/
}