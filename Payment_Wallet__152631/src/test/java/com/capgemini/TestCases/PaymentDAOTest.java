package com.capgemini.TestCases;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capgemini.Bean.AccountDetails;
import com.capgemini.Bean.ConsumerDetails;
import com.capgemini.Bean.TransactionDetails;
import com.capgemini.DAO.PaymentDAO;

public class PaymentDAOTest {
	ConsumerDetails cd = new ConsumerDetails();
	PaymentDAO pd = new PaymentDAO();
	AccountDetails ad = new AccountDetails();
	TransactionDetails td = new TransactionDetails();
	
	@Test
	public void testCreateAccount() {
		assertEquals(true, pd.createAccount(ad));
	}
	
	

	@Test
	public void testDepositBalance() {
		assertNotNull(pd.depositBalance(5000, ad));
		
	}

	@Test
	public void testWithdrawBalance() {
		assertNull(pd.withdrawBalance(400, ad));
		
	}
	@Test
	public void testTransferFund() {
		assertNull(pd.transferFund(1122334, 5000, ad));
		
	}


}
