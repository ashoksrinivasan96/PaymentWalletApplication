package com.capgemini.bean;

public class ConsumerDetails {

	private String consumerName;
	private int age;
	private String emailId;
	private String phoneNo;
	private String gender;
	private TransactionDetails transaction;
	private String userName;
	private String password;

	public TransactionDetails getTransactionD() {
		return transaction;
	}

	public void setTransactionD(TransactionDetails transaction) {
		this.transaction = transaction;
	}

	public String getConsumerName() {
		return consumerName;
	}

	@Override
	public String toString() {
		return "ConsumerDetails [consumerName=" + consumerName + ", age=" + age + ", emailId=" + emailId + ", phoneNo="
				+ phoneNo + ", gender=" + gender + "]";
	}

	public void setConsumerName(String consumerName) {
		this.consumerName = consumerName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}