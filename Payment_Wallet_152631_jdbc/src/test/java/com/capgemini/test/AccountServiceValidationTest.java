package com.capgemini.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capgemini.bean.AccountDetails;
import com.capgemini.service.AccountServiceValidation;

public class AccountServiceValidationTest {
	
	AccountServiceValidation asv = new AccountServiceValidation();
	AccountDetails accountDetailsObject = new AccountDetails();

	@Test
	public void testValidateLogIn() {
		
		assertNull(asv.validateLogIn("ashoks", "ashok987", accountDetailsObject ));
	}

	@Test
	public void testValidateUserName() {
		fail("Not yet implemented");
	}

	@Test
	public void testValidatePassword() {
		fail("Not yet implemented");
	}

}
