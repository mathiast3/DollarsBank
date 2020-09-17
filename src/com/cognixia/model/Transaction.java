package com.cognixia.model;

public class Transaction {
	int transactionId;
	String type;
	Double amount;

	public Transaction(int transactionId, String type, Double amount) {
		super();
		this.transactionId = transactionId;
		this.type = type;
		this.amount = amount;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

}
