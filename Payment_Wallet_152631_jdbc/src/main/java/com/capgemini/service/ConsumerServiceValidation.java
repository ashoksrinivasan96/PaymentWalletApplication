package com.capgemini.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsumerServiceValidation {
	private Pattern pattern;
	private Matcher matcher;

	public enum Gender {
		Male, Female, Transgender, M, F, T

	}

	public boolean validateConsumerName(String consumerName) {
		String name_pattern = "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$";
		this.pattern = Pattern.compile(name_pattern);
		matcher = pattern.matcher(consumerName);
		return matcher.matches();

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