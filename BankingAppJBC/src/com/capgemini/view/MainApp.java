package com.capgemini.view;

import java.util.HashMap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.beans.Account;
import com.capgemini.beans.AccountConfiguration;
import com.capgemini.repository.*;
import com.capgemini.service.*;

public class MainApp {

	public static void main(String[] args) throws Exception {
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AccountConfiguration.class,ServiceImplConfiguration.class);
		
		Account account1 = (Account)applicationContext.getBean("account1");
		Account account2 = (Account)applicationContext.getBean("account2");
		
		Service service = (Service)applicationContext.getBean("service");
		

		System.out.println(account1.getAccountNo());
		service.fundTransfer(101, 102, 200);
		System.out.println(account1.getAmount());
		System.out.println(account2.getAmount());
		
	}

}
