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
	//发送邮件
      public SendMail2() {
        //String host = "localhost"; // 指定的smtp服务器，本机的局域网IP
       /* String host = "localhost"; // 本机smtp服务器
*/      String host = "smtp.163.com"; // 163的smtp服务器
        String from = "19874200236@163.com"; // 邮件发送人的邮件地址
        String to = "1771560366@qq.com"; // 邮件接收人的邮件地址
        final String username = "19874200236@163.com";  //发件人的邮件帐户
        final String password = "6198611nao";   //发件人的邮件密码
 
        // 创建Properties 对象
        Properties props = System.getProperties();
 
        // 添加smtp服务器属性
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.auth", "true");
 
        // 创建邮件会话
        Session session = Session.getDefaultInstance(props, new Authenticator(){
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
             
        });
 
        try {
            // 定义邮件信息
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from,"James"));
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress("**@gmail.com"));
            //message.setSubject(transferChinese("我有自己的邮件服务器了"));
            message.setSubject("22222");
            message.setText("大爷的的的的的的的!");
 
            // 发送消息
            session.getTransport("smtp").send(message);  
            //Transport.send(message); //也可以这样创建Transport对象发送
            System.out.println("发送成功!");
 
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
