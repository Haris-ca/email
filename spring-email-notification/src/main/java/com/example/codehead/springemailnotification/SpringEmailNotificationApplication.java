package com.example.codehead.springemailnotification;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

@SpringBootApplication
public class SpringEmailNotificationApplication {

	public static void main(String[] args) throws MessagingException, UnsupportedEncodingException  {
		Properties prop = new Properties();
		prop.put("Mail.smtp.host", "smtp.gmail.com");
		prop.put("Mail.smtp.port","587");
		prop.put("Mail.smtp.auth", true);
		prop.put("Mail.smtp.starttls.enable","true");
		
		
		
		Session session =  Session.getInstance(prop,new Authenticator()
				{
						@Override
						protected PasswordAuthentication getPasswordAuthentication()
						{
							return new PasswordAuthentication("harisca171@gmail.com","qhlayisqkbxqnqgb");
						}
				});
		
		Message message = new MimeMessage(session);
		try
		{
			message.setFrom(new InternetAddress("harisca171@gmail.com"));
		}
		catch(MessagingException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			message.setRecipients(
			Message.RecipientType.TO,InternetAddress.parse("thirtheshthirtheshkt@gmail.com"));
		}
		catch(MessagingException e)
		{
			e.printStackTrace();
		}
		
		message.setSubject("Notification Alert");
		
		String msg="This is my first email";
		
		MimeBodyPart mimeBodyPart= new MimeBodyPart();
		mimeBodyPart.setContent(msg,"text/html;charset=utf-8");
		
		Multipart multipart= new MimeMultipart();
		multipart.addBodyPart(mimeBodyPart);
		
		message.setContent(multipart);
		
		Transport.send(message);
		
		
		
	}

}
