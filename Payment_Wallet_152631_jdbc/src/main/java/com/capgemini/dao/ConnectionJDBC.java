package com.capgemini.dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class ConnectionJDBC {
	public static Connection jdbcConnection() {
		Connection con = null;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			String url1 = "jdbc:mysql://localhost:3306/payment_wallet_152631";
			String user = "root";
			String password = "Capgemini123";
			 con =  (Connection) DriverManager.getConnection(url1, user, password);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
