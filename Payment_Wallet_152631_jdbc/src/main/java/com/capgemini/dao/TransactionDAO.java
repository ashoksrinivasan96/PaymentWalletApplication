package com.capgemini.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.capgemini.bean.AccountDetails;
import com.capgemini.bean.TransactionDetails;
import com.mysql.jdbc.Connection;

public class TransactionDAO {

	public void addTransactionDetails(TransactionDetails transactionDetailsObject) {
		
		
		try {
			Date d = Date.valueOf(transactionDetailsObject.getTransactionDate());
			Connection con = ConnectionJDBC.jdbcConnection();
			String addTransactionQuery = "insert into transactiondetails values(?,?,?,?,?,?)";
			PreparedStatement preStatement = con.prepareStatement(addTransactionQuery);
			preStatement.setLong(1, transactionDetailsObject.getBankAccount());
			preStatement.setLong(2, transactionDetailsObject.getTransactionId());
			preStatement.setDate(3, d);
			preStatement.setString(4, transactionDetailsObject.getTransactionType());
			preStatement.setDouble(5, transactionDetailsObject.getAmount());
			preStatement.setDouble(6, transactionDetailsObject.getBalance());
			
			preStatement.execute();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void printTransaction(AccountDetails accountDetailsObject) {
		try {
			Connection c = ConnectionJDBC.jdbcConnection();
			String printQuery = "Select * from transactiondetails where bankaccount = ?";
			PreparedStatement preStatement = c.prepareStatement(printQuery);
			preStatement.setLong(1, accountDetailsObject.getBankAccount());
			ResultSet rs = preStatement.executeQuery();
			System.out.println(" Transaction ID   Transaction Date   Transaction Type \t Amount      Balance\n ");
			while(rs.next()) {
				
				
				System.out.println("   "+rs.getLong("transactionid") +"        "+rs.getDate("transactiondate")+"            " +rs.getString("transactiontype") +"        " +rs.getDouble("amount")+"       " +rs.getDouble("balance"));
				
			}
			System.out.println(
					"  ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
