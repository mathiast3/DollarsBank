package com.cognixia.controller;

import java.util.ArrayList;
import java.util.List;

import com.cognixia.model.Account;
import com.cognixia.model.Customer;

public class DollarsController {
	List<Account> accounts = new ArrayList<>();

	public List<Account> getAccounts() {
		return accounts;
	}

	public void createAccount(String name, String address, String number, String id, String password, double balance) {
		Account newAccount = new Account(id, password, balance, new Customer(name, address, number));
		// add it to storage
		accounts.add(newAccount);
		System.out.println(accounts.get(0));
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
		return -1;
	}
}
