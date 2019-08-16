package com.DBProjectCloset.controller;

import java.util.Properties;  
import javax.mail.*;  
import javax.mail.internet.*;  
  
public  class SendMail {  
 public SendMail() {
		super();
		// TODO Auto-generated constructor stub
	}

public  void signUpMail(String msg, String toAddress) {  
  
 String to="mamidisoni@gmail.com";//change accordingly
  
  //Get the session object  
 Properties props = new Properties();
	props.put("mail.smtp.host", "smtp.gmail.com");
	props.put("mail.smtp.socketFactory.port", "465");
	props.put("mail.smtp.socketFactory.class",
			"javax.net.ssl.SSLSocketFactory");
	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.port", "465");
   
  Session session = Session.getDefaultInstance(props,  
   new javax.mail.Authenticator() {  
   protected PasswordAuthentication getPasswordAuthentication() {  
   return new PasswordAuthentication("catawbamycloset@gmail.com","spartansdb");//change accordingly  
   }  
  });  
   
  //compose message  
  try {  
   MimeMessage message = new MimeMessage(session);  
   message.setFrom(new InternetAddress("catawbamycloset@gmail.com"));//change accordingly  
   message.addRecipient(Message.RecipientType.TO,new InternetAddress(toAddress));  
   message.setSubject("Mail From MyCloset.com");  
   message.setText(msg,"UTF-8","html");  
     
   //send message  
   Transport.send(message);  
  
   System.out.println("message sent successfully");  
   
  } catch (MessagingException e) {throw new RuntimeException(e);}  
   
 }  
}  