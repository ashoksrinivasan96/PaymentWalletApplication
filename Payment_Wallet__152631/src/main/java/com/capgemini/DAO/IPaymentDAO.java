package com.capgemini.DAO;

import com.capgemini.Bean.AccountDetails;
import com.capgemini.Bean.TransactionDetails;

public interface IPaymentDAO {
	public boolean createAccount(AccountDetails ad);

	public void showBalance(AccountDetails ad);

	public AccountDetails depositBalance(double deposit, AccountDetails ad);

	public AccountDetails withdrawBalance(double withdraw, AccountDetails ad);

	public AccountDetails transferFund(long bankaccount2, double amount, AccountDetails ad);

	public void printTransaction(TransactionDetails td);

}
