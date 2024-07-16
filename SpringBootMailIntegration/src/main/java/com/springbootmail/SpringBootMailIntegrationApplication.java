package com.springbootmail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.springbootmail.service.impl.PurchaseOrderImpl;

@SpringBootApplication
public class SpringBootMailIntegrationApplication {
	
	public static void main(String[] args) throws Exception {
		ApplicationContext context=SpringApplication.run(SpringBootMailIntegrationApplication.class, args);
	  
		PurchaseOrderImpl service = context.getBean(PurchaseOrderImpl.class);
		
		String msg=service.purchase(new String[] {"Java","Spring","Design patterns","Microservices"},
				new Double[] {9999.86,3444.443,4312.33,1599.00}, new String[] {"alvirasayyad27@gmail.com"});
		
		System.out.println(msg);
		   		
	}

}
