package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.utility.ReusableUtility;

public final class HomePage extends ReusableUtility{
	
	private static final By MENS_CLOTHING_LOCATOR = By.xpath("//a[@href=\"#Men\"]");
	private static final By JEANS_LOCATOR = By.xpath("//a[text()=\"Jeans \"]");
	private static final By NAME_LOCATOR = By.xpath("//ul[contains(@class,\"navbar-nav\")]/descendant::b");

	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	public String getUserName() {
		return getVisibleText(NAME_LOCATOR);
		
	}
	
	
	
	

}
