package com.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.constants.Browser;

public abstract class ReusableUtility {

	private WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	public ReusableUtility(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public ReusableUtility(Browser browserName) {
		if(browserName == Browser.CHROME) {
			
			driver = new ChromeDriver();
		}else if(browserName == Browser.FIREFOX) {
			
			driver = new FirefoxDriver();
		}else if(browserName == Browser.EDGE) {
			
			driver = new EdgeDriver();
		}else {
			
			System.err.println("Invalid BrowserName");
		}
		
	}

	public void goToWebsite(String url) {

		driver.get(url);
	}

	public void enterText(By Locator, String text) {

		WebElement Element = driver.findElement(Locator);
		Element.sendKeys(text);
	}

	public void clickOn(By Locator) {

		WebElement Element = driver.findElement(Locator);
		Element.click();
		
	}
	


}
