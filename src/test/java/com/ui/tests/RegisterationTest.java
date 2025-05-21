package com.ui.tests;

import static com.constants.Browser.CHROME;
import static com.constants.Env.QA;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.AccountCreated;
import com.ui.pages.HomePage;
import com.ui.pages.SignupAndLoginPage;
import com.ui.pojo.RegistrationPojo;
import com.utility.FakeAddressUtility;
import com.utility.LoggerUtlity;
import com.utility.PropertiesUtil;

public class RegisterationTest {

	private SignupAndLoginPage signupAndLoginPage;
	Logger logger = LoggerUtlity.getLogger(this.getClass());
//	private RegistrationPojo registrationPojo;
//	private AccountCreated accountCreated;

	@BeforeMethod(description = "Lunch browser and go to signinpage")
	public void setup() {

		signupAndLoginPage = new SignupAndLoginPage(CHROME);
	}

	@Test(description = "verfiy the registraion details for signin", groups = { "e2e", "sanity", "smoke" },
	retryAnalyzer = com.ui.listeners.MyRetryAnalyer.class)
	
	public void registrationTest() {
		
		logger.info("Started customer registration ");
		HomePage data = signupAndLoginPage
				.enterNameAndMailid(PropertiesUtil.getProperty(QA, "USERNAME"), PropertiesUtil.getProperty(QA, "EMAIL"))
				.enterRegistrationdetails(FakeAddressUtility.getFakeAddress()).goToAccountCreatedPage();
		logger.info("Registration has completed ");
	}

}
