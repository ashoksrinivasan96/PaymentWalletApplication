package com.capgemini.service;

import com.capgemini.bean.AccountDetails;
import com.capgemini.bean.TransactionDetails;

public interface ITransactionService {
	
	public void addTransactionDetails(TransactionDetails transactionDetailsObject);
	public void printTransaction(AccountDetails accountDetailsObject);

}
