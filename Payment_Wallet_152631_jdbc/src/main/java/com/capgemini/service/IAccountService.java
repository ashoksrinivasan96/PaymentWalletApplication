package com.capgemini.service;

import com.capgemini.bean.AccountDetails;
import com.capgemini.bean.ConsumerDetails;

public interface IAccountService {
	
	public AccountDetails createAccount(ConsumerDetails consumerDetailsObject);
	public void showBalance(AccountDetails accountDetailsObject);
	public AccountDetails depositBalance(double depositAmount, AccountDetails accountDetailsObject);
	public AccountDetails withdrawBalance(double withdrawAmount, AccountDetails accountDetailsObject);
	public AccountDetails transferFund(long userTwoBankAccount, double transferAmount,
			AccountDetails accountDetailsObject);
}
