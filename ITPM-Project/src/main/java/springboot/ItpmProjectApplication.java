package springboot;

import javax.mail.MessagingException;
import javax.security.auth.Subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import springboot.controller.CartController;

@SpringBootApplication
public class ItpmProjectApplication {

//	@Autowired
//	private CartController service;
	
	public static void main(String[] args) {
		SpringApplication.run(ItpmProjectApplication.class, args);
		
	}
//	@EventListener(ApplicationReadyEvent.class)
//	public void triggerMail() throws MessagingException {
//		service.sendEmailWithAttachment("sachin.ranasinghe1998.13@gmail.com", 
//				"This is the email body with attachment", 
//				"This is the email body", 
//				"D:\\My Photos\\MY PHOTOS\\MY PHOTO\\71-black.png");
//	}
}
