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
		assertNotNull(pd.showBalance(pw));
		
	}

	@Test
	public void testDepositBalance() {
		assertNotNull(pd.depositBalance(5000, pw));
		
	}

	@Test
	public void testWithdrawBalance() {
		assertNull(pd.withdrawBalance(400, pw));
		
	}
	@Test
	public void testTransferFund() {
		assertNull(pd.transferFund(1122334, 5000, pw));
		
	}
	@Test
	public void testPrintTransaction() {
		assertNull(pd.printTransaction(12345678, pw));
		
	}

}
