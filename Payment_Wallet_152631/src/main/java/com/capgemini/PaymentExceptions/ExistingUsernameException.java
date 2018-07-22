package com.capgemini.PaymentExceptions;

public class ExistingUsernameException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3722482672561045673L;
	public  ExistingUsernameException() {
	System.err.println("The Username you entered already exists.");
	
	}
	
}
