package com.capgemini.dao;

import com.capgemini.bean.AccountDetails;

public interface IAccountDAO {
	public AccountDetails createAccount(AccountDetails accountDetailsObject);

	public void showBalance(AccountDetails accountDetailsObject);

	public AccountDetails depositBalance(double depositAmount, AccountDetails accountDetailsObject);

	public AccountDetails withdrawBalance(double withdrawAmount, AccountDetails accountDetailsObject);

	public AccountDetails transferFund(long userTwoBankAccount, double transferAmount,
			AccountDetails accountDetailsObject);
}
