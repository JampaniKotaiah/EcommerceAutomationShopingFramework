package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.utility.ReusableUtility;

public final class AccountCreated extends ReusableUtility {
	
	private static final By MESSAGE_LOCATOR = By.xpath("//b[text()=\"Account Created!\"]");
	private static final By CONTINU_BUTTON_LOCATOR = By.xpath("//a[text()=\"Continue\"]");

	public AccountCreated(WebDriver driver) {
		super(driver);
	
	}
	
	public HomePage goToAccountCreatedPage() {
//		
		getVisibleText(MESSAGE_LOCATOR);
		clickOn(CONTINU_BUTTON_LOCATOR);
		HomePage homePage = new HomePage(getDriver());
		return homePage;
			
	}
	

	
	

}
