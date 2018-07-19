package com.capgemini.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.capgemini.bean.ConsumerDetails;
import com.mysql.jdbc.Connection;

public class ConsumerDAO implements IConsumerDAO {

	public ConsumerDetails createAccount(ConsumerDetails consumerDetailsObject) {
		
		try {
			
			Connection c = ConnectionJDBC.jdbcConnection();
			
			String addQuery = "insert into consumerdetails values(?,?,?,?,?,?,?)";
			
				PreparedStatement preStatement = c.prepareStatement(addQuery);
				preStatement.setString(1, consumerDetailsObject.getConsumerName());
				preStatement.setInt(2, consumerDetailsObject.getAge());
				preStatement.setString(3, consumerDetailsObject.getGender());
				preStatement.setString(4, consumerDetailsObject.getPhoneNo());
				preStatement.setString(5, consumerDetailsObject.getEmailId());
				preStatement.setString(6, consumerDetailsObject.getUserName());
				preStatement.setString(7, consumerDetailsObject.getPassword());
				preStatement.execute();
				c.close();
				return consumerDetailsObject;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	}


