package com.cognixia.model;

public class Account {
	String id;
	String password;
	double balance;
	Customer customer;

	public Account(String id, String password, double balance, Customer customer) {
		super();
		this.id = id;
		this.password = password;
		this.balance = balance;
		this.customer = customer;
	}

	public Account() {

	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
