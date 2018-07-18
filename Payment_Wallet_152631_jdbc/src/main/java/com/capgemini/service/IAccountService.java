package com.capgemini.service;

import com.capgemini.bean.AccountDetails;
import com.capgemini.bean.ConsumerDetails;

public interface IAccountService {
	
	public void createAccount(ConsumerDetails consumerDetailsObject);
	public void showBalance(AccountDetails accountDetailsObject);
	public boolean depositBalance(double depositAmount, AccountDetails accountDetailsObject);
}
