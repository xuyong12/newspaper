package util;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail2 {
	//�����ʼ�
      public SendMail2() {
        //String host = "localhost"; // ָ����smtp�������������ľ�����IP
       /* String host = "localhost"; // ����smtp������
*/      String host = "smtp.163.com"; // 163��smtp������
        String from = "19874200236@163.com"; // �ʼ������˵��ʼ���ַ
        String to = "1771560366@qq.com"; // �ʼ������˵��ʼ���ַ
        final String username = "19874200236@163.com";  //�����˵��ʼ��ʻ�
        final String password = "6198611nao";   //�����˵��ʼ�����
 
        // ����Properties ����
        Properties props = System.getProperties();
 
        // ���smtp����������
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.auth", "true");
 
        // �����ʼ��Ự
        Session session = Session.getDefaultInstance(props, new Authenticator(){
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
             
        });
 
        try {
            // �����ʼ���Ϣ
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from,"James"));
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress("**@gmail.com"));
            //message.setSubject(transferChinese("�����Լ����ʼ���������"));
            message.setSubject("22222");
            message.setText("��ү�ĵĵĵĵĵĵ�!");
 
            // ������Ϣ
            session.getTransport("smtp").send(message);  
            //Transport.send(message); //Ҳ������������Transport������
            System.out.println("���ͳɹ�!");
 
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
      public static void main(String[] args) {
		SendMail2 mail=new SendMail2();
	}
}
