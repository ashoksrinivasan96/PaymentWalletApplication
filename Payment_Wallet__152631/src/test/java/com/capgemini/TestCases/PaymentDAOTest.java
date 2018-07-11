package com.capgemini.TestCases;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capgemini.Bean.PaymentWallet;
import com.capgemini.DAO.PaymentDAO;

public class PaymentDAOTest {
	PaymentWallet pw = new PaymentWallet();
	PaymentDAO pd = new PaymentDAO();
	
	@Test
	public void testCreateAccount() {
		assertEquals(true, pd.createAccount(pw));
	}

	@Test
	public void testShowBalance() {
		assertNotNull(pw);
		
	}

	@Test
	public void testDepositBalance() {
		assertNotNull(pw);
		
	}

	@Test
	public void testWithdrawBalance() {
		assertNotNull(pw);
		
	}
	@Test
	public void testTransferFund() {
		assertNotNull(pw);
		
	}
	@Test
	public void testPrintTransaction() {
		assertNotNull(pw);
		
	}

}
