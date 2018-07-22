package com.capgemini.service;

import com.capgemini.bean.AccountDetails;
import com.capgemini.bean.TransactionDetails;
import com.capgemini.dao.TransactionDAO;

public class TransactionService implements ITransactionService{
	
	TransactionDAO transactionDaoObject = new TransactionDAO();

	public void addTransactionDetails(TransactionDetails transactionDetailsObject) {
		transactionDaoObject.addTransactionDetails(transactionDetailsObject);
		
	}

	public void printTransaction(AccountDetails accountDetailsObject) {
	
		transactionDaoObject.printTransaction(accountDetailsObject);
	}

}
