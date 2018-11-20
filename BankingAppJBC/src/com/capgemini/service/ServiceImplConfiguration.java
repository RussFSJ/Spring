package com.capgemini.service;

import java.util.HashMap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.capgemini.beans.Account;
import com.capgemini.exceptions.InsufficientOpeningBalanceException;
import com.capgemini.repository.RepositoryImpl;

@Configuration
public class ServiceImplConfiguration {
	@Bean
	public ServiceImpl service() throws InsufficientOpeningBalanceException {
		RepositoryImpl repo = new RepositoryImpl(new HashMap<Integer, Account>());
		repo.save(new Account(101, "Russell1", 1000));
		repo.save(new Account(102, "Russell2", 500));
		return new ServiceImpl(repo);
	}

}
