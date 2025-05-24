package com.ui.tests;

import static com.constants.Browser.CHROME;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;

import com.ui.pages.SignupAndLoginPage;
import com.utility.LoggerUtlity;
import com.utility.ReusableUtility;

public class TestBase {
	Logger logger = LoggerUtlity.getLogger(this.getClass());
	protected SignupAndLoginPage signupAndLoginPage;
	
	@BeforeMethod(description = "Lunch browser and go to signinpage")
	public void setup() {
		logger.info("Load the Login page of website");
		signupAndLoginPage = new SignupAndLoginPage(CHROME);
	}
	
	
	public ReusableUtility getInstance() {
		return signupAndLoginPage;
	}

}
