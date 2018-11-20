package com.capgemini.beans;

public class Account {
	private int accountNo;
	private String name;
	private int amount;
	
	public Account() {
	
	}
	
	public Account(int accountNo, String name, int amount) {
		this.accountNo = accountNo;
		this.name = name;
		this.amount = amount;
	}
	
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "Account [accountNo = " + accountNo + ", name = " + name + ", amount = " + amount + "]";
	}
	
	

}
