package com.capgemini.Service;

import com.capgemini.Bean.AccountDetails;
import com.capgemini.Bean.ConsumerDetails;
import com.capgemini.Bean.TransactionDetails;
import com.capgemini.DAO.PaymentDAO;

public class PaymentService implements IPaymentService {

	PaymentDAO pd = new PaymentDAO();

	public boolean createAccount(AccountDetails ad) {

		return pd.createAccount(ad);
	}

	public void showBalance(AccountDetails ad) {

		pd.showBalance(ad);
	}

	public AccountDetails depositBalance(double deposit, AccountDetails ad) {

		return pd.depositBalance(deposit, ad);

	}

	public AccountDetails withdrawBalance(double withdraw, AccountDetails ad) {

		return pd.withdrawBalance(withdraw, ad);
	}

	public boolean transferFund(long bankaccount2, double amount, AccountDetails ad) {

		return pd.transferFund(bankaccount2, amount, ad);

	}

	public void printTransaction(TransactionDetails td) {

		pd.printTransaction(td);

	}

}
