package com.capgemini.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountConfiguration {
	@Bean
	public Account account1() {
		return new Account(101, "Russell1", 1000);
	}
	
	@Bean
	public Account account2() {
		return new Account(102, "Russell2", 500);
	}

}
