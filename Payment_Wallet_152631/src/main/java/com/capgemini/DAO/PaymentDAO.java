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

	public boolean createAccount(AccountDetails accountDetailsObject) {

		return accountInfo.add(accountDetailsObject);

	}

	public void showBalance(AccountDetails accountDetailsObject) {

		System.out.println(accountDetailsObject);
	}

	public AccountDetails depositBalance(double depositAmount, AccountDetails accountDetailsObject) {

		accountDetailsObject.setBalance(accountDetailsObject.getBalance() + depositAmount);

		return accountDetailsObject;
	}

	public AccountDetails withdrawBalance(double withdrawAmount, AccountDetails accountDetailsObject) {

		double remainder = accountDetailsObject.getBalance() - withdrawAmount;
		if (remainder >= 0) {
			accountDetailsObject.setBalance(remainder);
			return accountDetailsObject;

		}
		return null;
	}

	public boolean transferFund(long userTwoBankAccount, double transferAmount, AccountDetails accountDetailsObject) {

		AccountDetails userAccount2 = new AccountDetails();
		boolean flag = false;
		if (accountDetailsObject.getBankAccount() == userTwoBankAccount) {
			System.err.println("Cannot transfer funds to yourself!");
			return flag;
		}

		for (AccountDetails userAccount : accountInfo) {
			if (userAccount.getBankAccount() == (userTwoBankAccount)) {
				userAccount2 = userAccount;
				flag = true;
				break;
			} else {

				flag = false;

			}
		}

		if (accountDetailsObject.getBalance() >= transferAmount && flag == true) {
			accountDetailsObject.setBalance(accountDetailsObject.getBalance() - transferAmount);
			userAccount2.setBalance(userAccount2.getBalance() + transferAmount);
			userAccount2.setAmount(transferAmount);
			userAccount2.getConsumer().getTransactionD()
					.setTransactionId(accountDetailsObject.getConsumer().getTransactionD().getTransactionId());
			userAccount2.getConsumer().getTransactionD().setTransactionDate(LocalDate.now());
			userAccount2.getConsumer().getTransactionD().getTransactionDetails().add(
					(String.valueOf(userAccount2.getConsumer().getTransactionD().getTransactionDate()) + "      \t"));
			userAccount2.getConsumer().getTransactionD().getTransactionDetails()
					.add(String.valueOf(userAccount2.getConsumer().getTransactionD().getTransactionId()) + "\t");
			userAccount2.getConsumer().getTransactionD().getTransactionDetails().add("Credited\t\t");
			userAccount2.getConsumer().getTransactionD().getTransactionDetails()
					.add(String.valueOf(userAccount2.getAmount()) + " \t");
			userAccount2.getConsumer().getTransactionD().getTransactionDetails()
					.add(String.valueOf(userAccount2.getBalance()) + "\n");

			return flag;

		}

		else if (transferAmount > accountDetailsObject.getBalance() && flag == true) {
			System.err.println("Insufficient funds!");
			return flag;
		}
		return flag;
	}

	public void printTransaction(TransactionDetails transactionDetailsObject) {
		System.out.println(" " + transactionDetailsObject.toString());
		System.out.println(" " + transactionDetailsObject.getTransactionDetails().toString().replace("[", "")
				.replace(",", "").replace("]", "").trim() + "\n");

	}

}
