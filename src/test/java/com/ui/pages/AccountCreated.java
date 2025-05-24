package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.utility.LoggerUtlity;
import com.utility.ReusableUtility;

public final class AccountCreated extends ReusableUtility {
	Logger logger = LoggerUtlity.getLogger(this.getClass());
//	private static final By MESSAGE_LOCATOR = By.xpath("//b[text()=\"Account Created!\"]");
	private static final By CONTINU_BUTTON_LOCATOR = By.xpath("//a[text()=\"Continuse\"]");

	public AccountCreated(WebDriver driver) {
		super(driver);
	
	}
	
	public HomePage goToAccountCreatedPage() {
		
		logger.info("Account details has filled");
//		getVisibleText(MESSAGE_LOCATOR);
		clickOn(CONTINU_BUTTON_LOCATOR);
		logger.info("Account has created Successfully");	
		HomePage homePage = new HomePage(getDriver());
		return homePage;
		
	}
	

	
	

}
