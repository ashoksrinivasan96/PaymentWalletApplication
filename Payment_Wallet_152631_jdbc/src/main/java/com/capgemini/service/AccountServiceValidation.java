package com.capgemini.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.bean.AccountDetails;
import com.capgemini.dao.ConnectionJDBC;
import com.mysql.jdbc.Connection;

public class AccountServiceValidation {
	private Pattern pattern;
	private Matcher matcher;

	public AccountDetails validateLogIn(String username, String password) {
			AccountDetails accountDetailsObject = new AccountDetails();
		
		try {
			Connection con = ConnectionJDBC.jdbcConnection();
			String userPassQuery = "select * from accountdetails where username=? and password = ? ";
			PreparedStatement pstmt = con.prepareStatement(userPassQuery);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				accountDetailsObject.setUserName(username);
				accountDetailsObject.setPassword(password);
				
				return accountDetailsObject;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean validateUserName(String username) throws com.capgemini.exceptions.ExistingUsernameException {

		String username_pattern = "^[a-zA-Z0-9._-]{3,25}$";
		this.pattern = Pattern.compile(username_pattern);
		matcher = pattern.matcher(username);
		return matcher.matches();
	}

	public boolean validatePassword(String password, String repassword) {
		boolean c = false;
		if (!password.equals(repassword)) {
			System.err.println("Password Mismatch");

		} else if (password.equals(repassword) && password.length() >= 5 && password.length() < 20) {
			c = true;

		} else if (password.length() < 5) {
			System.err.println("The password should be of a minimum length of 5 and a maximum length of 20.");
		}
		return c;
	}

}