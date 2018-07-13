package com.capgemini.DAO;

import java.time.LocalDate;
import java.util.ArrayList;

import com.capgemini.Bean.AccountDetails;

import com.capgemini.Bean.TransactionDetails;

public class PaymentDAO implements IPaymentDAO {

	public static ArrayList<AccountDetails> accountInfo = new ArrayList<AccountDetails>();

	public static ArrayList<AccountDetails> getList() {

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

	public boolean transferFund(long bankAccount, double amount, AccountDetails ad) {
		
		AccountDetails obj2 = new AccountDetails();
		boolean flag = false;
		if (ad.getBankAccount() == bankAccount) {
			System.err.println("Cannot transfer funds to yourself!");
			return flag;
		}

		for (AccountDetails obj : accountInfo) {
			 if (obj.getBankAccount() ==(bankAccount)) {
				obj2 = obj;
				flag = true;
				break;
			} else {

				flag = false;

			}
		}

			if (ad.getBalance() >= amount && flag == true) {
			ad.setBalance(ad.getBalance() - amount);
			obj2.setBalance(obj2.getBalance() + amount);
			obj2.setAmount(amount);
			obj2.getConsumer().getTransactionD()
					.setTransactionId(ad.getConsumer().getTransactionD().getTransactionId());
			obj2.getConsumer().getTransactionD().setTransactionDate(LocalDate.now());
			obj2.getConsumer().getTransactionD().getTransactionDetails()
					.add((String.valueOf(obj2.getConsumer().getTransactionD().getTransactionDate()) + "      \t"));
			obj2.getConsumer().getTransactionD().getTransactionDetails().add(String.valueOf(obj2.getConsumer().getTransactionD().getTransactionId()) + "\t");
			obj2.getConsumer().getTransactionD().getTransactionDetails().add("Credited\t\t");
			obj2.getConsumer().getTransactionD().getTransactionDetails().add(String.valueOf(obj2.getAmount()) + " \t");
			obj2.getConsumer().getTransactionD().getTransactionDetails().add(String.valueOf(obj2.getBalance()) + "\n");
			
			return flag;

		}

		else {
			System.err.println("Insufficient funds!");
			return flag;
		}
		
	}

	public void printTransaction(TransactionDetails td) {
		System.out.println(" " + td.toString());
		System.out.println(
				" " + td.getTransactionDetails().toString().replace("[", "").replace(",", "").replace("]", "").trim()
						+ "\n");

	}

}
