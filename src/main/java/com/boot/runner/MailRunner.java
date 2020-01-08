package com.boot.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

import com.boot.services.MailService;

@Component
public class MailRunner implements CommandLineRunner{
	@Autowired
	private MailService service;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		FileSystemResource file=new FileSystemResource("C:\\Users\\surya\\Desktop\\springautfile");
		boolean sent=service.send("durgaprasadgandi72@gmail.com", "JavaMail", "Hi Surya", file);
		if(sent) {
			System.out.println("done");
		}else {
			System.out.println("not done");
		}
		
	}

}
