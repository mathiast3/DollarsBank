package com.cognixia.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cognixia.controller.DollarsController;
import com.cognixia.model.Account;
import com.cognixia.model.Customer;
import com.cognixia.model.Transaction;

public class DollarsBankApp {
	static DollarsController controller = new DollarsController();
	static Scanner input = new Scanner(System.in);
	static List<Transaction> transactions = new ArrayList<>();

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		boolean exit = false;
		while (!exit) {
			System.out.println("Welcome to Dollars Bank!");
			System.out.println("1. Create Account");
			System.out.println("2. Login");
			System.out.println("3. Exit");
			int selection = 0;

			selection = input.nextInt();
			input.nextLine();

			if (selection == 1) {
				createAccount();

			} else if (selection == 2) {
				login();
			} else if (selection == 3) {
				System.out.println("Thank you for using Dollars Bank,");
				System.out.println("Goodbye!");

				exit = true;
			}
		}
		input.close();

	}

	private static void login() {
		// TODO Auto-generated method stub
		System.out.println("Enter Login Credentials:\n");
		System.out.println("User ID:");
		String id = input.nextLine();
		System.out.println("Password:");
		String password = input.nextLine();
		int index = controller.isRegistered(id, password);
		while (index != -1) {

			index = displayOptions(index);
		}
	}

	private static int displayOptions(int index) {
		// TODO Auto-generated method stub
		System.out.println("Welcome!\n");
		System.out.println("1. Deposit");
		System.out.println("2. Withdrawl");
		System.out.println("3. Funds Transfer");
		System.out.println("4. View 5 Recent Transactions");
		System.out.println("5. Display Account Info");
		System.out.println("6. Sign Out");
		int choice = input.nextInt();
		input.nextLine();

		switch (choice) {
		case 1:
			deposit(index);
			break;
		case 2:
			withdrawl(index);
			break;
		case 3:
			transfer(index);
			break;
		case 4:
			transactions();
			break;
		case 5:
			account(index);
			break;
		case 6:
			// sets index to -1 and signs the user out
			return -1;
		default:
			throw new IllegalArgumentException("Unexpected value: " + choice);
		}
		return index;
	}

	private static void account(int index) {
		// TODO Auto-generated method stub
		System.out.println("Account Info:");
		Account account = controller.getAccounts().get(index);
		Customer customer = account.getCustomer();
		System.out.println("Name on Account: " + customer.getName());
		System.out.println("Address: " + customer.getAddress());
		System.out.println("Phone Number: " + customer.getPhone());
		System.out.println("User ID: " + account.getId());
		System.out.println("Balance: " + account.getBalance());

	}

	private static void transactions() {
		// TODO Auto-generated method stub
		System.out.println("Last 5 Transactions:");
		int size = transactions.size();
		for (int i = size - 1; i >= (size - 5) && i >= 0; i--) {
			Transaction transaction = transactions.get(i);
			System.out.println(
					transaction.getTransactionId() + " " + transaction.getType() + " " + transaction.getAmount());
		}
	}

	private static void transfer(int index) {
		// TODO Auto-generated method stub
		List<Account> accounts = controller.getAccounts();
		Account account = accounts.get(index);
		System.out.println("Your balance is " + account.getBalance());
		System.out.println("How much would you like to transfer?");

		double amount = input.nextInt();
		input.nextLine();
		if (amount > account.getBalance()) {
			System.out.println("Insufficient Funds");
			return;
		}

		System.out.println("Which user?");

		String other = input.nextLine();
		for (Account current : accounts) {
			if (current.getId().equals(other)) {
				current.setBalance(current.getBalance() + amount);
				System.out.println(current.getId() + "'s Account Balance is " + current.getBalance());
				account.setBalance(account.getBalance() - amount);
				transactions.add(new Transaction(transactions.size(), "Transfer", amount));
				System.out.println("Your Account Balance is " + account.getBalance());
			}
		}

	}

	private static void withdrawl(int index) {
		// TODO Auto-generated method stub
		Account account = controller.getAccounts().get(index);
		System.out.println("Your balance is " + account.getBalance());
		System.out.println("How much would you like to withdrawl?");

		double amount = input.nextInt();
		input.nextLine();
		if (amount > account.getBalance()) {
			System.out.println("Insufficient Funds");
			return;
		}

		account.setBalance(account.getBalance() - amount);
		transactions.add(new Transaction(transactions.size(), "Withdrawl", amount));
		System.out.println("Current Balance is " + account.getBalance());
	}

	private static void deposit(int index) {
		// TODO Auto-generated method stub
		System.out.println("How much would you like to deposit?");
		double amount = input.nextInt();
		input.nextLine();
		Account account = controller.getAccounts().get(index);
		account.setBalance(account.getBalance() + amount);
		transactions.add(new Transaction(transactions.size(), "Deposit", amount));
		System.out.println("Current Balance is " + account.getBalance());

	}

	private static void createAccount() {
		// TODO Auto-generated method stub
		System.out.println("Create Account\n");
		System.out.println("Customer Name:");
		String name = input.nextLine();
		System.out.println("Customer Address:");
		String address = input.nextLine();
		System.out.println("Customer Number:");
		String number = input.nextLine();
		System.out.println("User ID:");
		String id = input.nextLine();
		System.out.println("Password:");
		String password = input.nextLine();
		System.out.println("Initial Amount:");
		Double balance = input.nextDouble();
		controller.createAccount(name, address, number, id, password, balance);
		transactions.add(new Transaction(transactions.size(), "Initial Deposit", balance));
	}

}
