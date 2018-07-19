package com.capgemini.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.capgemini.bean.AccountDetails;
import com.capgemini.bean.TransactionDetails;
import com.capgemini.service.TransactionService;
import com.mysql.jdbc.Connection;

public class AccountDAO implements IAccountDAO {
	TransactionDetails transactionDetailsObject = new TransactionDetails();
	TransactionDetails transactionDetailsObject2 = new TransactionDetails();
	TransactionService transactionServiceObject = new TransactionService();

	public AccountDetails createAccount(AccountDetails accountDetailsObject) {

		try {

			Connection c = ConnectionJDBC.jdbcConnection();

			String addQuery = "insert into accountdetails values(?,?,?,?)";

			PreparedStatement preStatement = c.prepareStatement(addQuery);
			preStatement.setLong(1, accountDetailsObject.getBankAccount());
			preStatement.setDouble(2, accountDetailsObject.getBalance());
			preStatement.setString(3, accountDetailsObject.getUserName());
			preStatement.setString(4, accountDetailsObject.getPassword());

			preStatement.execute();
			c.close();
			return accountDetailsObject;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public void showBalance(AccountDetails accountDetailsObject) {

		try {
			Connection c = ConnectionJDBC.jdbcConnection();
			String showQuery = "select balance from accountdetails where username=?";
			PreparedStatement preStatement = c.prepareStatement(showQuery);
			preStatement.setString(1, accountDetailsObject.getUserName());
			ResultSet r = preStatement.executeQuery();

			while (r.next()) {
				System.out.println("\t\t" + r.getDouble("balance"));
			}
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public AccountDetails depositBalance(double depositAmount, AccountDetails accountDetailsObject) {

		try {
			Connection c = ConnectionJDBC.jdbcConnection();
			String depositQuery = "update accountdetails set balance = ? where accountnumber =? ";
			PreparedStatement preStatement = c.prepareStatement(depositQuery);
			preStatement.setDouble(1, accountDetailsObject.getBalance() + depositAmount);
			preStatement.setLong(2, accountDetailsObject.getBankAccount());
			preStatement.execute();
			c.close();

			accountDetailsObject.setBalance(accountDetailsObject.getBalance() + depositAmount);
			accountDetailsObject.setAmount(depositAmount);
			transactionDetailsObject.setTransactionDate(LocalDate.now());
			transactionDetailsObject.setTransactionId((long) (Math.random() * 10000000 + 99999999));
			transactionDetailsObject.setTransactionType("Credited");
			transactionDetailsObject.setAmount(depositAmount);
			transactionDetailsObject.setBankAccount(accountDetailsObject.getBankAccount());
			transactionDetailsObject.setBalance(accountDetailsObject.getBalance());
			transactionServiceObject.addTransactionDetails(transactionDetailsObject);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountDetailsObject;
	}

	public AccountDetails withdrawBalance(double withdrawAmount, AccountDetails accountDetailsObject) {
		if (accountDetailsObject.getBalance() > withdrawAmount) {
			try {
				Connection c = ConnectionJDBC.jdbcConnection();
				String withdrawQuery = "update accountDetails set balance= ? where accountnumber =?";
				PreparedStatement preStatement = c.prepareStatement(withdrawQuery);
				preStatement.setDouble(1, accountDetailsObject.getBalance() - withdrawAmount);
				preStatement.setLong(2, accountDetailsObject.getBankAccount());
				preStatement.execute();
				c.close();
				accountDetailsObject.setBalance(accountDetailsObject.getBalance() - withdrawAmount);
				accountDetailsObject.setAmount(withdrawAmount);
				transactionDetailsObject.setTransactionDate(LocalDate.now());
				transactionDetailsObject.setTransactionId((long) (Math.random() * 10000000 + 99999999));
				transactionDetailsObject.setTransactionType("Debited");
				transactionDetailsObject.setAmount(withdrawAmount);
				transactionDetailsObject.setBankAccount(accountDetailsObject.getBankAccount());
				transactionDetailsObject.setBalance(accountDetailsObject.getBalance());
				transactionServiceObject.addTransactionDetails(transactionDetailsObject);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return accountDetailsObject;
		} else
			return null;
	}

	public AccountDetails transferFund(long userTwoBankAccount, double transferAmount,
			AccountDetails accountDetailsObject) {
		long userTwoBalance = 0;
		long userTwoAccount = 0;
		
		try {
			if (userTwoBankAccount == accountDetailsObject.getBankAccount()) {
				System.out.println("Cannot transfer funds to your own account!");
				return null;
			} else if (accountDetailsObject.getBalance() > transferAmount) {
				AccountDetails accountDetailsObjectUser2 = new AccountDetails();
				

				Connection c = ConnectionJDBC.jdbcConnection();
				String transferQuery = "update accountdetails set balance =? where accountnumber=?";

				String transferQueryBalance = "select balance, accountnumber from accountdetails where accountnumber=?";

				PreparedStatement preStatement1 = c.prepareStatement(transferQuery);
				PreparedStatement preStatement2 = c.prepareStatement(transferQuery);

				PreparedStatement preStatement3 = c.prepareStatement(transferQueryBalance);
				preStatement3.setLong(1, userTwoBankAccount);
				ResultSet rs = preStatement3.executeQuery();
				while (rs.next()) {
					userTwoBalance = rs.getLong("balance");
					userTwoAccount = rs.getLong("accountnumber");
				}

				preStatement1.setDouble(1, accountDetailsObject.getBalance() - transferAmount);
				preStatement1.setDouble(2, accountDetailsObject.getBankAccount());
				preStatement2.setDouble(1, userTwoBalance + transferAmount);
				preStatement2.setLong(2, userTwoBankAccount);

				preStatement1.executeUpdate();
				preStatement2.executeUpdate();

				accountDetailsObject.setAmount(transferAmount);
				transactionDetailsObject.setTransactionDate(LocalDate.now());
				transactionDetailsObject.setTransactionId((long) (Math.random() * 10000000 + 99999999));
				transactionDetailsObject.setTransactionType("Debited");
				transactionDetailsObject.setAmount(transferAmount);
				transactionDetailsObject.setBankAccount(accountDetailsObject.getBankAccount());
				transactionDetailsObject.setBalance(accountDetailsObject.getBalance() - transferAmount);
				transactionServiceObject.addTransactionDetails(transactionDetailsObject);

				accountDetailsObjectUser2.setAmount(transferAmount);
				transactionDetailsObject2.setTransactionDate(LocalDate.now());
				transactionDetailsObject2.setTransactionId((long) (Math.random() * 10000000 + 99999999));
				transactionDetailsObject2.setTransactionType("Credited");
				transactionDetailsObject2.setAmount(transferAmount);
				transactionDetailsObject2.setBankAccount(userTwoAccount);
				transactionDetailsObject2.setBalance(userTwoBalance + transferAmount);
				transactionServiceObject.addTransactionDetails(transactionDetailsObject2);
				
				accountDetailsObject.setBalance(accountDetailsObject.getBalance() - transferAmount);
				return accountDetailsObject;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
