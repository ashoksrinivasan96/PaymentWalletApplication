package com.capgemini.Service;

import com.capgemini.Bean.PaymentWallet;
import com.capgemini.DAO.PaymentDAO;

public class PaymentService implements IPaymentService {

	PaymentDAO pd = new PaymentDAO();

	public boolean createAccount(PaymentWallet pw) {

		return pd.createAccount(pw);
	}

	public PaymentWallet showBalance(PaymentWallet pw) {

		return pd.showBalance(pw);
	}

	public PaymentWallet depositBalance(double deposit, PaymentWallet pw) {

		return pd.depositBalance(deposit, pw);

	}

	public PaymentWallet withdrawBalance(double withdraw, PaymentWallet pw) {

		return pd.withdrawBalance(withdraw, pw);
	}

	public PaymentWallet transferFund(long bankaccount2, double amount, PaymentWallet pw) {
		
		return pd.transferFund(bankaccount2, amount, pw);
		
	}

	public PaymentWallet printTransaction(long transId, PaymentWallet pw) {

		
			return pd.printTransaction(transId, pw);
		
		
	}

	

}
