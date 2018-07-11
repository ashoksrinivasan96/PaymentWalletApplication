package com.capgemini.DAO;

import java.util.ArrayList;

import java.util.List;

import com.capgemini.Bean.PaymentWallet;

public class PaymentDAO implements IPaymentDAO {

	public static List<PaymentWallet> accountInfo = new ArrayList<PaymentWallet>();

	public boolean createAccount(PaymentWallet pw) {

		return accountInfo.add(pw);

	}

	public PaymentWallet showBalance(PaymentWallet pw) {

		return pw;
	}

	public PaymentWallet depositBalance(double deposit, PaymentWallet pw) {

		pw.setBalance(pw.getBalance() + deposit);

		System.out.println(pw);

		return pw;
	}

	public PaymentWallet withdrawBalance(double withdraw, PaymentWallet pw) {

		double remainder = pw.getBalance() - withdraw;
		if (remainder >= 0) {
			pw.setBalance(remainder);
			System.out.println(pw);
			return pw;
		} else {
			System.err.println("Insufficient Balance!");
			return null;
		}
	}

	public static List getList() {

		return accountInfo;

	}

	public PaymentWallet transferFund(long bankaccount2, double amount, PaymentWallet pw) {

		double userOneBalance = pw.getBalance();
		for (PaymentWallet obj : accountInfo) {

			if (pw.getBankAccount() == bankaccount2) {
				System.err.println("Cannot transfer funds to yourself!");
			}

			if (obj.getBankAccount() == (bankaccount2)) {
				if (userOneBalance >= amount) {

					obj.setBalance(obj.getBalance() + amount);
					pw.setBalance(userOneBalance - amount);
					pw.setAmount(amount);
				}

				else
					System.err.println("Insufficient funds!");
				return obj;
			}

		}

		return null;

	}

	public void printTransaction(long transId, PaymentWallet pw) {

		for (PaymentWallet x : accountInfo) {
			if (x.getTransactionId() == transId) {
				System.out.println("♠• Transaction details for transaction ID: " + x.getTransactionId());
				System.out.println("♠• Account Holder Name:" + x.getConsumerName());
				System.out.println("♠• Bank Account Number:" + x.getBankAccount());
				System.out.println("♠• Amount transferred to Bank Account" + pw.getBankAccount());
				System.out.println("♠• Amount :" + x.getAmount());
			} else
				System.err.println("The transaction ID you entered is either wrong,");
		}

	}

}
