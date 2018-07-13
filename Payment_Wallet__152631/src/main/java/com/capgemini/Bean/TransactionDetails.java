package com.capgemini.Bean;

import java.time.LocalDate;
import java.util.ArrayList;

public class TransactionDetails {
	private long transactionId;
	private LocalDate transactionDate;
	private ArrayList<String> transactionDetails;

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public ArrayList<String> getTransactionDetails() {
		return transactionDetails;
	}

	public void setTransactionDetails(ArrayList<String> transactionDetails) {
		this.transactionDetails = transactionDetails;
	}
	@Override
	public String toString() {
		return " █▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█\nTransaction Date\tTransaction ID \tTransaction Type \t Amount \t Balance\n "; 
	}

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
}
