package com.capgemini.view;

import java.util.HashMap;
import com.capgemini.beans.Account;
import com.capgemini.repository.*;
import com.capgemini.service.*;

public class MainApp {
	static HashMap<Integer, Account> hm = new HashMap<Integer, Account>();
	static RepositoryImpl repo = new RepositoryImpl(hm);
	static ServiceImpl accounts = new ServiceImpl(repo);
	
	public static void main(String[] args) throws Exception {
		
		/*Account account1 = new Account(101, "Russell1", 10);
		repo.save(account1);
		System.out.println(account1);*/
		Account account2 = new Account(102, "Russell2", 1000);
		repo.save(account2);
		System.out.println(account2);
		Account account3 = new Account(103, "Russell3", 500);
		repo.save(account3);
		System.out.println(account3);
		accounts.withdrawAmount(102, 100);
		System.out.println(account2);
		accounts.fundTransfer(102, 103, 200);
		System.out.println(account2);
		System.out.println(account3);
		
	}

}
