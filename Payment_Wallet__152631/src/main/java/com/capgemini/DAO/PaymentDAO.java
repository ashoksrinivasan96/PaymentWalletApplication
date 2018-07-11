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

		return pw;
	}

	public PaymentWallet withdrawBalance(double withdraw, PaymentWallet pw) {

		double remainder = pw.getBalance() - withdraw;
		if (remainder >= 0) {
			pw.setBalance(remainder);
			return pw;
		
		}
		return null;
	}

	public static List<PaymentWallet> getList() {

		return accountInfo;

	}

	public PaymentWallet transferFund(long bankAccount2, double amount, PaymentWallet pw) {

		double userOneBalance = pw.getBalance();
		for (PaymentWallet obj : accountInfo) {

			if (pw.getBankAccount() == bankAccount2) {
				System.err.println("Cannot transfer funds to yourself!");
				break;
			}

			if (obj.getBankAccount() == (bankAccount2)) {
				if (userOneBalance >= amount) {

					obj.setBalance(obj.getBalance() + amount);
					pw.setBalance(userOneBalance - amount);
					pw.setAmount(amount);
					return obj;
				}

				else {
					System.err.println("Insufficient funds!");
				}

			}

		}

		return null;

	}

	public PaymentWallet printTransaction(long transId, PaymentWallet pw) {

		for (PaymentWallet x : accountInfo) {
			if (x.getTransactionId() == transId) {
				return x;
			}

		}
		return null;

	}

}
