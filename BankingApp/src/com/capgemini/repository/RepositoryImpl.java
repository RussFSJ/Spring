package com.capgemini.repository;

import java.util.Map;

import com.capgemini.beans.*;
import com.capgemini.exceptions.InsufficientOpeningBalanceException;
import com.capgemini.exceptions.InvalidAccountNumberException;

public class RepositoryImpl implements Repository{
	private Map<Integer, Account> accounts;
	
	public RepositoryImpl(Map<Integer, Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public Account save(Account account) throws InsufficientOpeningBalanceException {
		if (account.getAmount() < 50) {
			throw new InsufficientOpeningBalanceException();
		}
		accounts.put(account.getAccountNo(),account);
		return account;
		
	}

	@Override
	public Account find(int accountNo) throws InvalidAccountNumberException {
		if (accounts.containsKey(accountNo) != true){
			throw new InvalidAccountNumberException();
		}
		return accounts.get(accountNo);
	}

}
