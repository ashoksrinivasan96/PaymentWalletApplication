package com.capgemini.DAO;

import com.capgemini.Bean.AccountDetails;
import com.capgemini.Bean.TransactionDetails;

public interface IPaymentDAO {
	public boolean createAccount(AccountDetails accountDetailsObject);

	public void showBalance(AccountDetails accountDetailsObject);

	public AccountDetails depositBalance(double depositAmount, AccountDetails accountDetailsObject);

	public AccountDetails withdrawBalance(double withdrawAmount, AccountDetails accountDetailsObject);

	public boolean transferFund(long bankaccount2, double transferAmount, AccountDetails accountDetailsObject);

	public void printTransaction(TransactionDetails transactionDetailsObject);

}
