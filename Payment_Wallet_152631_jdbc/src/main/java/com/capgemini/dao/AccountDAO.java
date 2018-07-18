package com.capgemini.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.capgemini.bean.AccountDetails;
import com.mysql.jdbc.Connection;


public class AccountDAO implements IAccountDAO {

	public void createAccount(AccountDetails accountDetailsObject) {

		try {

			Connection c = ConnectionJDBC.jdbcConnection();

			String addQuery = "insert into accountdetails values(?,?,?,?,?)";

			PreparedStatement preStatement = c.prepareStatement(addQuery);
			preStatement.setLong(1, accountDetailsObject.getBankAccount());
			preStatement.setDouble(2, accountDetailsObject.getBalance());
			preStatement.setString(3, accountDetailsObject.getUserName());
			preStatement.setString(4, accountDetailsObject.getPassword());
			
			preStatement.execute();
			c.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void showBalance(AccountDetails accountDetailsObject) {
		
		
		try {
			Connection c = ConnectionJDBC.jdbcConnection();
			String showQuery = "select balance from accountdetails where username=?";
			PreparedStatement preStatement = c.prepareStatement(showQuery);
			preStatement.setString(1, accountDetailsObject.getUserName());
			ResultSet r = preStatement.executeQuery();
			
			while(r.next()) {
			System.out.println("\t\t\t\t"+r.getDouble("balance"));}
			r.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean depositBalance(double depositAmount, AccountDetails accountDetailsObject) {
		
		try {
			Connection c = ConnectionJDBC.jdbcConnection();
			String depositQuery = "update accountdetails set balance=?";
			PreparedStatement preStatement =  c.prepareStatement(depositQuery);
			preStatement.setDouble(1, depositAmount);
			preStatement.execute();
			
			return true;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
