package com.capgemini.DAO;

import com.capgemini.Bean.PaymentWallet;

public interface IPaymentDAO {
	public boolean createAccount(PaymentWallet pw);

	public PaymentWallet showBalance(PaymentWallet pw);

	public PaymentWallet depositBalance(double deposit, PaymentWallet pw);

	public PaymentWallet withdrawBalance(double withdraw, PaymentWallet pw);
	
	public PaymentWallet transferFund(long bankaccount2, double amount, PaymentWallet pw);

}
