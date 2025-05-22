package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import com.constants.Browser;
import com.ui.pojo.LoginPojo;

import static com.constants.Env.*;

import com.utility.LoggerUtlity;
import com.utility.PropertiesUtil;
import com.utility.ReusableUtility;

public final class SignupAndLoginPage extends ReusableUtility {
	
	Logger logger = LoggerUtlity.getLogger(this.getClass());
	
	private static final By NAME_LOCATOR = By.name("name");
	private static final By EMAIL_LOCATOR = By.xpath("//input[@data-qa=\"signup-email\"]");
	private static final By SIGNUP_LOCATOR = By.xpath("//button[text()=\"Signup\"]");


	public SignupAndLoginPage(Browser browserName) {
		super(browserName);
		goToWebsite(PropertiesUtil.getProperty(QA,"URL"));
	}
	
	public RegistrationPage enterNameAndMailid(LoginPojo loginPojo) {
		logger.info("Enter Name and maild on Sign in page for registriaon");
		
		enterText(NAME_LOCATOR, loginPojo.getUserName());
		enterText(EMAIL_LOCATOR, loginPojo.getEmailId());
		clickOn(SIGNUP_LOCATOR);
		
		RegistrationPage registrationPage = new RegistrationPage(getDriver());
		return registrationPage;
	}
	
	
	
}
