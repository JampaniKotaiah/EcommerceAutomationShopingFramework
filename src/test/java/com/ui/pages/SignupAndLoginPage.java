package com.ui.pages;

import org.openqa.selenium.By;
import com.constants.Browser;
import static com.constants.Env.*;
import com.utility.PropertiesUtil;
import com.utility.ReusableUtility;

public final class SignupAndLoginPage extends ReusableUtility {
	
	private static final By NAME_LOCATOR = By.name("name");
	private static final By EMAIL_LOCATOR = By.xpath("//input[@data-qa=\"signup-email\"]");
	private static final By SIGNUP_LOCATOR = By.xpath("//button[text()=\"Signup\"]");


	public SignupAndLoginPage(Browser browserName) {
		super(browserName);
		goToWebsite(PropertiesUtil.getProperty(QA,"URL"));
	}
	
	public RegistrationPage enterNameAndMailid(String name,String mailid) {
		enterText(NAME_LOCATOR, name);
		enterText(EMAIL_LOCATOR, mailid);
		clickOn(SIGNUP_LOCATOR);
		
		RegistrationPage registrationPage = new RegistrationPage(getDriver());
		return registrationPage;
	}
	
	
	
}
