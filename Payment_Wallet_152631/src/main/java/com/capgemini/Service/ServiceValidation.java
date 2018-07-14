package com.capgemini.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.plaf.synth.SynthSeparatorUI;

import com.capgemini.Bean.AccountDetails;
import com.capgemini.Bean.ConsumerDetails;
import com.capgemini.DAO.PaymentDAO;
import com.capgemini.PaymentExceptions.ExistingUsernameException;

public class ServiceValidation {
	private Pattern pattern;
	private Matcher matcher;

	public enum Gender {
		Male, Female, Transgender, M, F, T

	}

	public AccountDetails validateLogIn(String username, String password) {

		ArrayList<AccountDetails> list = PaymentDAO.getList();

		for (AccountDetails accountDetailsObject : list) {
			if (accountDetailsObject.getUserName().equalsIgnoreCase(username)
					&& accountDetailsObject.getPassword().equals(password)) {

				return accountDetailsObject;
			}

		}
		return null;
	}

	public boolean validateConsumerName(String consumerName) {
		String name_pattern = "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$";
		this.pattern = Pattern.compile(name_pattern);
		matcher = pattern.matcher(consumerName);
		return matcher.matches();

	}

	public boolean validateUserName(String username) throws ExistingUsernameException {
		ArrayList<AccountDetails> list = PaymentDAO.getList();
		for (AccountDetails accountDetailsObject : list) {
			try {
				if (accountDetailsObject.getUserName().equalsIgnoreCase(username)) {

					throw new ExistingUsernameException();

				}
			} catch (ExistingUsernameException e) {
				//System.err.println("Exception Caught!");
				return false;
			}
		}

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

	public boolean validateEmailID(String email) {

		String email_pattern = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+(?:[A-Z]{2}|com|org|net|gov|mil|biz|info|mobi|name|aero|jobs|museum|edu)\\b";
		this.pattern = Pattern.compile(email_pattern);
		matcher = pattern.matcher(email);
		return matcher.matches();
	}

	public boolean validatePhoneNo(String phoneNo) {

		String phone_pattern = "^[6-9]\\d{9}$";
		this.pattern = Pattern.compile(phone_pattern);
		matcher = pattern.matcher(phoneNo);
		return matcher.matches();

	}

	public boolean validateAge(int age) {
		if (age > 0 && age < 120) {
			return true;
		} else
			return false;

	}

	public boolean validateGender(String gender) {
		for (Gender g : Gender.values()) {
			if (g.name().equalsIgnoreCase(gender)) {
				return true;
			}

		}
		return false;
	}

}