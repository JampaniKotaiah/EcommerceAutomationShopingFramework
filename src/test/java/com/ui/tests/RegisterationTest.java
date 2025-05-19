package com.ui.tests;

import static com.constants.Browser.CHROME;

import org.testng.annotations.Test;

import com.ui.pages.SignupAndLoginPage;

public class RegisterationTest { 

	@Test
	public void registrationTest() {
		SignupAndLoginPage signupAndLoginPage = new SignupAndLoginPage(CHROME);
		signupAndLoginPage.enterNameAndMailid("Jampani Kotaiah", "mymailid@mymail.com");

	}

}
