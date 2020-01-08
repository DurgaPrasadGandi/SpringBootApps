package com.boot.services;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.AbstractResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class MailService {
	@Autowired
	private JavaMailSender sender;

	public boolean send(String to, String subject, String text, AbstractResource file) {
		boolean sent = false;
		// create Message
		MimeMessage message = sender.createMimeMessage();

		// add sending details and file is exist to allocate memory
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, file != null);
			helper.setTo(to);
			helper.setSubject(subject);
			if (text != null)
				helper.setText(text);
			if (file != null)
				helper.addAttachment(file.getFilename(), file);

			// sending message
			sender.send(message);
			sent = true;
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			sent = false;
			e.printStackTrace();
		}

		return sent;
	}
	public boolean send(String to, String subject) {
		return  send(to,subject,null,null);
	}
	}


