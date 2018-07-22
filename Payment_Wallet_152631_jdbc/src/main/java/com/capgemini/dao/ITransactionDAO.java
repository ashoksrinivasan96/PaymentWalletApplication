package com.capgemini.dao;

import com.capgemini.bean.AccountDetails;
import com.capgemini.bean.TransactionDetails;

public interface ITransactionDAO {
	public void addTransactionDetails(TransactionDetails transactionDetailsObject);
	public void printTransaction(AccountDetails accountDetailsObject);
}
