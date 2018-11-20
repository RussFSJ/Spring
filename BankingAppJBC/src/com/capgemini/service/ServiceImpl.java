package com.capgemini.service;

import com.capgemini.beans.Account;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientOpeningBalanceException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.repository.Repository;

public class ServiceImpl implements Service {
	
	private Repository repo;
	
	public ServiceImpl(Repository repo) {
		this.repo = repo;
	}

	@Override
	public Account createAccount(int accountNo, String name, int amount) throws InsufficientOpeningBalanceException {
		if (amount < 50) {
			throw new InsufficientOpeningBalanceException();
		}
		Account account = new Account(accountNo, name, amount);
		return repo.save(account);
	}

	@Override
	public Account depositAmount(int accountNo, int amount) throws InvalidAccountNumberException {
		if (accountNo <= 0) {
			throw new InvalidAccountNumberException();
		}
		Account account = repo.find(accountNo);
		int currentBalance = account.getAmount();
		account.setAmount(currentBalance + amount);
		return account;
	}

	@Override
	public Account withdrawAmount(int accountNo, int amount)
			throws InvalidAccountNumberException, InsufficientBalanceException {
		if (accountNo <= 0) {
			throw new InvalidAccountNumberException();
		}
		Account account = repo.find(accountNo);
		int currentBalance = account.getAmount();
		if (amount > currentBalance) {
			throw new InsufficientBalanceException();
		}
		account.setAmount(currentBalance - amount);
		return account;
	}

	@Override
	public Account fundTransfer(int accountNo1, int accountNo2, int amount)
			throws InvalidAccountNumberException, InsufficientBalanceException {
		if ((accountNo1 <= 0) || (accountNo2 <= 0)) {
			throw new InvalidAccountNumberException();
		}
		Account account1 = repo.find(accountNo1);
		int currentBalance1 = account1.getAmount();
		if (amount > currentBalance1) {
			throw new InsufficientBalanceException();
		}
		Account account2 = repo.find(accountNo2);
		int currentBalance2 = account2.getAmount();
		account1.setAmount(currentBalance1 - amount);
		account2.setAmount(currentBalance2 + amount);
		
		return account1;
	}
	

}
