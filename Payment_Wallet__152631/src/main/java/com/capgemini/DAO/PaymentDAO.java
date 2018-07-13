package com.capgemini.DAO;

import java.util.ArrayList;


import com.capgemini.Bean.AccountDetails;

import com.capgemini.Bean.TransactionDetails;

public class PaymentDAO implements IPaymentDAO {

	
	public static ArrayList<AccountDetails> accountInfo = new ArrayList<AccountDetails>();
	
	
	public  static ArrayList<AccountDetails> getList() {
		
		return accountInfo;
		
	}
	public boolean createAccount(AccountDetails ad) {
		
		 
		
		 return accountInfo.add(ad);
		
	}

	public void showBalance(AccountDetails ad) {

		System.out.println(ad);
	}

	public AccountDetails depositBalance(double deposit, AccountDetails ad) {

		ad.setBalance(ad.getBalance() + deposit);

		return ad;
	}

	public AccountDetails withdrawBalance(double withdraw, AccountDetails ad) {

		double remainder = ad.getBalance() - withdraw;
		if (remainder >= 0) {
			ad.setBalance(remainder);
			return ad;

		}
		return null;
	}

	public AccountDetails transferFund(long bankAccount2, double amount, AccountDetails ad) {

		double userOneBalance = ad.getBalance();
		for (AccountDetails obj : accountInfo) {

			if (ad.getBankAccount() == bankAccount2) {
				System.err.println("Cannot transfer funds to yourself!");
				break;
			}

			if (obj.getBankAccount() == (bankAccount2)) {
				if (userOneBalance >= amount) {

					obj.setBalance(obj.getBalance() + amount);
					ad.setBalance(userOneBalance - amount);
					return obj;
				}

				else {
					System.err.println("Insufficient funds!");
				}

			}

		}

		return null;

	}

	public void printTransaction(TransactionDetails td) {
		System.out.println("Transaction Date\tTransaction ID\tTransaction Amount \tBalance");
		System.out.println(td.getTransactionDetails());

	}

}
