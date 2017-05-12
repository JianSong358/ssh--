package main.java.com.hj.shop.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 发送邮件的工具类
 * @author hj
 *
 */
public class MailUtils {

	/**
	 * 发送邮件的方法
	 * @param to 收件人
	 * @param code 激活码
	 */
	public static void sendMail(String to,String code){
		//一、获取mail连接对象Session
		Properties props = new Properties();
		props.setProperty("mail.host", "localhost");//设置发送邮件的主机
		Session session = Session.getInstance(props, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				//发件 人的帐号密码
				return new PasswordAuthentication("admin@hujun.com", "admin");
			}
			
		});
		
		//二、创建邮件对象,并把邮件连接对象转入
		Message message = new MimeMessage(session);
		
		//设置邮件的发件人
		try {
			message.setFrom(new InternetAddress("admin@hujun.com"));
			
			//设置邮件的收件人
			message.addRecipient(RecipientType.TO, new InternetAddress(to));
			
			//设置邮件的标题
			message.setSubject("来自商城的官方激活邮件");
			
			//设置邮件的内容
			String con = "<h1>来自商城的官方激活邮件,请点击下面连接完成激活操作</h1><hr><h3><a href='http://localhost:8080/shop/user_active.action?code="+code+"'>点击激活</a></h3>";
			message.setContent(con, "text/html;charset=UTF-8");
			
			
			//三、发送邮件
			Transport.send(message);
		} catch (AddressException e) {
			System.out.println("addresssException");
			e.printStackTrace();
		} catch (MessagingException e) {
			System.out.println("MessagingException");
			e.printStackTrace();
		}
	}
	
}
