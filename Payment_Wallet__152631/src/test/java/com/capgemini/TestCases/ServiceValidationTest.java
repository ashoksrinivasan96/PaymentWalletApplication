package com.capgemini.TestCases;

import static org.junit.Assert.*;
import org.junit.Test;

import com.capgemini.Bean.PaymentWallet;
import com.capgemini.Service.ServiceValidation;

public class ServiceValidationTest {
	ServiceValidation sv = new ServiceValidation();
	PaymentWallet pw = new PaymentWallet();

	@Test
	public void testValidateLogIn() {
		assertNotNull(pw);
	}
	
	@Test
	public void testValidateConsumerName() {
		assertEquals(true, sv.validateConsumerName("Ashok Srinivasan"));
		assertEquals(true, sv.validateConsumerName("G. Ashok Srinivasan"));
		assertEquals(true, sv.validateConsumerName("Ashok"));
		assertEquals(false, sv.validateConsumerName("@#$%!("));
		assertEquals(false, sv.validateConsumerName("123456789"));
		assertEquals(false, sv.validateConsumerName(""));
	}

	@Test
	public void testValidateUserName() {
		assertEquals(true, sv.validateUserName("ashok_96"));
		assertEquals(true, sv.validateUserName("123"));
		assertEquals(true, sv.validateUserName("123_ashok-srinivasan96"));
		assertEquals(false, sv.validateUserName("x"));
		assertEquals(false, sv.validateUserName("@!@#$%^&*"));
		assertEquals(false, sv.validateUserName("12345678912345678912asasgfaghassga"));

	}

	@Test
	public void testValidatePassword() {
		assertEquals(true, sv.validatePassword("ashok967", "ashok967"));
		assertEquals(true, sv.validatePassword("abcd12345@!", "abcd12345@!"));
		assertEquals(true, sv.validatePassword("!@#$%^&*()", "!@#$%^&*()"));
		assertEquals(false, sv.validatePassword("abcdefgh", "efghijklm"));
		assertEquals(false, sv.validatePassword("123", "123"));
		assertEquals(false, sv.validatePassword("", ""));
	}

	@Test
	public void testValidateEmailID() {
		assertEquals(true, sv.validateEmailID("ashok@gmail.com"));
		assertEquals(true, sv.validateEmailID("ash@xyz.com"));
		assertEquals(true, sv.validateEmailID("capgemini_ashok@capgemini.com"));
		assertEquals(false, sv.validateEmailID(""));
		assertEquals(false, sv.validateEmailID("ashok@."));
		assertEquals(false, sv.validateEmailID("ashok@gmail"));

	}

	@Test
	public void testValidatePhoneNo() {
		assertEquals(false, sv.validatePhoneNo(""));
		assertEquals(false, sv.validatePhoneNo("1234567890"));
		assertEquals(false, sv.validatePhoneNo("123456789123"));
		assertEquals(true, sv.validatePhoneNo("8447878035"));
		assertEquals(true, sv.validatePhoneNo("9711451796"));
		assertEquals(true, sv.validatePhoneNo("9868864058"));

	}

	@Test
	public void testValidateAge() {
		assertEquals(true, sv.validateAge(21));
		assertEquals(true, sv.validateAge(12));
		assertEquals(true, sv.validateAge(63));
		assertEquals(false, sv.validateAge(0));
		assertEquals(false, sv.validateAge(-5));
		assertEquals(false, sv.validateAge(500));
	}

	@Test
	public void testValidateGender() {
		assertEquals(true, sv.validateGender("Male"));
		assertEquals(true, sv.validateGender("Female"));
		assertEquals(true, sv.validateGender("Transgender"));
		assertEquals(false, sv.validateGender("Xyz"));
		assertEquals(false, sv.validateGender("123"));
		assertEquals(false, sv.validateGender(""));

	}

}
