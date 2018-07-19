package com.capgemini.service;

import com.capgemini.bean.AccountDetails;
import com.capgemini.dao.AccountDAO;

public class AccountService {

	AccountDAO accountDaoObject = new AccountDAO();

	public AccountDetails createAccount(AccountDetails accountDetailsObject) {

		return accountDaoObject.createAccount(accountDetailsObject);

	}

	public void showBalance(AccountDetails accountDetailsObject) {
		accountDaoObject.showBalance(accountDetailsObject);

	}

	public AccountDetails depositBalance(double depositAmount, AccountDetails accountDetailsObject) {

		 return accountDaoObject.depositBalance(depositAmount, accountDetailsObject);
	}

	public AccountDetails withdrawBalance(double withdrawAmount, AccountDetails accountDetailsObject) {

		return accountDaoObject.withdrawBalance(withdrawAmount, accountDetailsObject);
	}

	public AccountDetails transferFund(long userTwoBankAccount, double transferAmount, AccountDetails accountDetailsObject) {

		return accountDaoObject.transferFund(userTwoBankAccount, transferAmount, accountDetailsObject);
	}

}
