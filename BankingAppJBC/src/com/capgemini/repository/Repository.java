package com.capgemini.repository;

import com.capgemini.beans.*;
import com.capgemini.exceptions.InsufficientOpeningBalanceException;
import com.capgemini.exceptions.InvalidAccountNumberException;

public interface Repository {
	
	public Account save(Account account) throws InsufficientOpeningBalanceException;
	
	public Account find(int accountNo) throws InvalidAccountNumberException;
	

}
