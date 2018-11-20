package com.capgemini.view;

import java.util.HashMap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.beans.Account;
import com.capgemini.repository.*;
import com.capgemini.service.*;

public class MainApp {

	public static void main(String[] args) throws Exception {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Account account1 = (Account)applicationContext.getBean("account1");
		Account account2 = (Account)applicationContext.getBean("account2");
		Repository repo = (Repository)applicationContext.getBean("repository");
		Service service = (Service)applicationContext.getBean("service");
		
		
		System.out.println(account1.getAccountNo());
		System.out.println(repo.save(account1));
		System.out.println(repo.save(account2));
		service.fundTransfer(101, 102, 200);
		System.out.println(account1.getAmount());
		System.out.println(account2.getAmount());
	
	}

}
