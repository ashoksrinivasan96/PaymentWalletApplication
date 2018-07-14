package com.capgemini.Service;

import com.capgemini.Bean.AccountDetails;
import com.capgemini.Bean.ConsumerDetails;
import com.capgemini.Bean.TransactionDetails;
import com.capgemini.DAO.PaymentDAO;

public class PaymentService implements IPaymentService {

	PaymentDAO paymentDaoObject = new PaymentDAO();

	public boolean createAccount(AccountDetails accountDetailsObject) {

		return paymentDaoObject.createAccount(accountDetailsObject);
	}

	public void showBalance(AccountDetails accountDetailsObject) {

		paymentDaoObject.showBalance(accountDetailsObject);
	}

	public AccountDetails depositBalance(double depositAmount, AccountDetails accountDetailsObject) {

		return paymentDaoObject.depositBalance(depositAmount, accountDetailsObject);

	}

	public AccountDetails withdrawBalance(double withdrawAmount, AccountDetails accountDetailsObject) {

		return paymentDaoObject.withdrawBalance(withdrawAmount, accountDetailsObject);
	}

	public boolean transferFund(long bankaccount2, double transferAmount, AccountDetails accountDetailsObject) {

		return paymentDaoObject.transferFund(bankaccount2, transferAmount, accountDetailsObject);

	}

	public void printTransaction(TransactionDetails transactionDetailsObject) {

		paymentDaoObject.printTransaction(transactionDetailsObject);

	}

}
