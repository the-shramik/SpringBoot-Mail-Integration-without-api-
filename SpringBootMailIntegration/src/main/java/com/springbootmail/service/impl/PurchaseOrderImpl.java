package com.springbootmail.service.impl;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.springbootmail.service.IPurchaseOrder;

import jakarta.mail.internet.MimeMessage;


@Service
public class PurchaseOrderImpl implements IPurchaseOrder {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Value("{spring.mail.username}")
	private String fromEmailId;

	@Override
	public String purchase(String[] items, Double[] prices, String[] toEmails) throws Exception {

		double amount = 0.0;

		for (double price : prices) {
			amount = amount + price;
		}

		String message = "Hello ! " + Arrays.toString(items) + " with price " + Arrays.toString(prices)
				+ " which is costing total of " + amount;
		
		MimeMessage mimeMsg = javaMailSender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(mimeMsg);
		helper.setFrom(fromEmailId);
		helper.setCc(toEmails);
		helper.setSubject("From shramik testing purpose");
		helper.setSentDate(new Date());
		//helper.addAttachment("guru.jpg", new ClassPathResource("guru.jpg"));		
		helper.setText(message);
		
		javaMailSender.send(mimeMsg);
				
		return "Mail sent! Kindly pliz check...!";
	}

}
