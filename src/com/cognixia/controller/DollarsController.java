package com.cognixia.controller;

import java.util.ArrayList;
import java.util.List;

import com.cognixia.model.Account;
import com.cognixia.model.Customer;

public class DollarsController {
	List<Account> accounts = new ArrayList<>();

	public DollarsController() {
		accounts.add(
				new Account("M001", "password", 2000, new Customer("Mathias Taylor", "22 maple st", "3067011111")));
		accounts.add(new Account("J001", "password", 400, new Customer("Johnny", "21 maple st", "3067011911")));
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void createAccount(String name, String address, String number, String id, String password, double balance) {
		Account newAccount = new Account(id, password, balance, new Customer(name, address, number));
		// add it to storage
		accounts.add(newAccount);
	}

	public int isRegistered(String ID, String password) {
		int index = 0;
		for (Account account : accounts) {
			if (account.getId().equals(ID)) {
				if (account.getPassword().equals(password)) {

					return index;
				}
				System.out.println("Wrong Password!");
			}
			index++;
		}
		System.out.println("Not registered");
		return -1;
	}
}
