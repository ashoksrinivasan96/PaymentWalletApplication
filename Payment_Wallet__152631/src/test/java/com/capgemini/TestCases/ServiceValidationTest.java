package com.capgemini.TestCases;

import static org.junit.Assert.*;
import org.junit.Test;

import com.capgemini.Bean.ConsumerDetails;
import com.capgemini.Service.ServiceValidation;

public class ServiceValidationTest {
	ServiceValidation sv = new ServiceValidation();
	ConsumerDetails pw = new ConsumerDetails();

	@Test
	public void testValidateLogIn() {
		assertNull(sv.validateLogIn("ashoks", "ashok987"));
	}
	
	@Test
	public void testValidateConsumerName() {
		assertEquals(true, sv.validateConsumerName("Ashok Srinivasan"));
		assertEquals(true, sv.validateConsumerName("G. Ashok Srinivasan"));
		assertEquals(true, sv.validateConsumerName("Ashok"));
		assertEquals(true, sv.validateConsumerName("Gurumurthy Ashok Srinivasan"));
		assertEquals(true, sv.validateConsumerName("Ashok Srinivasan G."));
		assertEquals(false, sv.validateConsumerName("@#$%!("));
		assertEquals(false, sv.validateConsumerName("123456789"));
		assertEquals(false, sv.validateConsumerName(""));
		assertEquals(false, sv.validateConsumerName("1234 ashok"));
		assertEquals(false, sv.validateConsumerName("@shok!"));
	}

	@Test
	public void testValidateUserName() {
		assertEquals(true, sv.validateUserName("ashok_96"));
		assertEquals(true, sv.validateUserName("123"));
		assertEquals(true, sv.validateUserName("123_ashok-srinivasan96"));
		assertEquals(true, sv.validateUserName("123456789123456789"));
		assertEquals(true, sv.validateUserName("123456789_g-h.p"));
		assertEquals(false, sv.validateUserName("x"));
		assertEquals(false, sv.validateUserName("@!@#$%^&*"));
		assertEquals(false, sv.validateUserName("12345678912345678912asasgfaghassga"));
		assertEquals(false, sv.validateUserName(""));
		assertEquals(false, sv.validateUserName("@ashok!234bcd_g."));

	}

	@Test
	public void testValidatePassword() {
		assertEquals(true, sv.validatePassword("ashok967", "ashok967"));
		assertEquals(true, sv.validatePassword("abcd12345@!", "abcd12345@!"));
		assertEquals(true, sv.validatePassword("!@#$%^&*()", "!@#$%^&*()"));
		assertEquals(true, sv.validatePassword("1ab2c3!@#", "1ab2c3!@#"));
		assertEquals(true, sv.validatePassword("123abc!@#", "123abc!@#"));
		assertEquals(false, sv.validatePassword("abcdefgh", "efghijklm"));
		assertEquals(false, sv.validatePassword("123", "123"));
		assertEquals(false, sv.validatePassword("", ""));
		assertEquals(false, sv.validatePassword("password", "repassword"));
		assertEquals(false, sv.validatePassword("Ashok123", "ashok123"));
	}

	@Test
	public void testValidateEmailID() {
		assertEquals(true, sv.validateEmailID("ashok@gmail.com"));
		assertEquals(true, sv.validateEmailID("ash@xyz.org"));
		assertEquals(true, sv.validateEmailID("capgemini_ashok@capgemini.com"));
		assertEquals(true, sv.validateEmailID("ashoksrinivasan96@gmail.com"));
		assertEquals(true, sv.validateEmailID("ashok_96@gmail.edu"));
		assertEquals(false, sv.validateEmailID(""));
		assertEquals(false, sv.validateEmailID("ashok@."));
		assertEquals(false, sv.validateEmailID("ashok@gmail"));
		assertEquals(false, sv.validateEmailID("ashok@gmail."));
		assertEquals(false, sv.validateEmailID("@gmail.com"));

	}

	@Test
	public void testValidatePhoneNo() {
		assertEquals(false, sv.validatePhoneNo(""));
		assertEquals(false, sv.validatePhoneNo("1234567890"));
		assertEquals(false, sv.validatePhoneNo("123456789123"));
		assertEquals(false, sv.validatePhoneNo("abcdefghijk"));
		assertEquals(false, sv.validatePhoneNo("!@#$%^&*()"));
		assertEquals(true, sv.validatePhoneNo("8447878035"));
		assertEquals(true, sv.validatePhoneNo("9711451796"));
		assertEquals(true, sv.validatePhoneNo("9868864058"));
		assertEquals(true, sv.validatePhoneNo("8010220127"));
		assertEquals(true, sv.validatePhoneNo("7042231568"));

	}

	@Test
	public void testValidateAge() {
		assertEquals(true, sv.validateAge(21));
		assertEquals(true, sv.validateAge(12));
		assertEquals(true, sv.validateAge(63));
		assertEquals(true, sv.validateAge(105));
		assertEquals(true, sv.validateAge(6));
		assertEquals(false, sv.validateAge(0));
		assertEquals(false, sv.validateAge(-5));
		assertEquals(false, sv.validateAge(500));
		assertEquals(false, sv.validateAge(-80));
		assertEquals(false, sv.validateAge(999999));
	}

	@Test
	public void testValidateGender() {
		assertEquals(true, sv.validateGender("Male"));
		assertEquals(true, sv.validateGender("Female"));
		assertEquals(true, sv.validateGender("Transgender"));
		assertEquals(true, sv.validateGender("M"));
		assertEquals(true, sv.validateGender("F"));
		assertEquals(false, sv.validateGender("Xyz"));
		assertEquals(false, sv.validateGender("123"));
		assertEquals(false, sv.validateGender("k"));
		assertEquals(false, sv.validateGender("1"));
		assertEquals(false, sv.validateGender("@"));

	}

}
