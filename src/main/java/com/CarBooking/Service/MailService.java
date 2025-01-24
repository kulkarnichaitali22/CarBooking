package com.CarBooking.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendMail(String to, String sub, String text)
	{
		SimpleMailMessage msg = new SimpleMailMessage();
		
		msg.setTo(to);
		msg.setSubject(sub);
		msg.setText(text);
		msg.setFrom("chaitali.kul2002@gmail.com");
		
		mailSender.send(msg);
	}

}
