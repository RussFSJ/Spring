package com.capgemini.service;

import com.capgemini.beans.Account;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientOpeningBalanceException;
import com.capgemini.exceptions.InvalidAccountNumberException;

public interface Service {
	
	public Account createAccount(int accountNo, String name, int amount) throws InsufficientOpeningBalanceException;
	
	public Account depositAmount(int accountNo, int amount) throws InvalidAccountNumberException; 
	
	public Account withdrawAmount(int accountNo, int amount) throws InvalidAccountNumberException, InsufficientBalanceException;
	
	public Account fundTransfer(int accountNo1, int accountNo2, int amount) throws InvalidAccountNumberException, InsufficientBalanceException;
	

}
