package com.capgemini.dao;

import com.capgemini.bean.AccountDetails;

public interface IAccountDAO {
	public void createAccount(AccountDetails accountDetailsObject);
	public void showBalance(AccountDetails accountDetailsObject);
	public boolean depositBalance(double depositAmount, AccountDetails accountDetailsObject);
}
