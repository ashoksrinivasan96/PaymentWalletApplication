package com.capgemini.service;

import com.capgemini.bean.AccountDetails;
import com.capgemini.dao.AccountDAO;

public class AccountService {

	AccountDAO accountDaoObject = new AccountDAO();

	public void createAccount(AccountDetails accountDetailsObject) {

		accountDaoObject.createAccount(accountDetailsObject);

	}

	public void showBalance(AccountDetails accountDetailsObject) {
		accountDaoObject.showBalance(accountDetailsObject);

	}

	public boolean depositBalance(double depositAmount, AccountDetails accountDetailsObject) {

		return accountDaoObject.depositBalance(depositAmount, accountDetailsObject);
	}

	public Object withdrawBalance(double withdrawAmount, AccountDetails accountDetailsObject) {

		return null;
	}

	public boolean transferFund(long userTwoBankAccount, double transferAmount, AccountDetails accountDetailsObject) {

		return false;
	}

}
