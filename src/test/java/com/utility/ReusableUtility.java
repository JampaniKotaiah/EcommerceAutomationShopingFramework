package com.utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browser;

public abstract class ReusableUtility {

	private WebDriver driver;
	private WebDriverWait wait;

	

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

		getDriver().get(url);
	}

	public void enterText(By Locator, String text) {
		
		WebElement Element = getDriver().findElement(Locator);
		Element.sendKeys(text);
	}

	public void clickOn(By Locator) {
		wait  = new WebDriverWait(getDriver(),Duration.ofSeconds(10));
		WebElement Element = driver.findElement(Locator);
		Element.click();
		
	}
	
	public void selectDropDownValue(By Locator,String value ) {
		
		WebElement Element = getDriver().findElement(Locator);
		Select dropdown = new Select(Element);
		dropdown.selectByVisibleText(value);
		
	}
	
	public void clickOnCheckboxByjs(By Locator) {
		wait  = new WebDriverWait(getDriver(),Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement Element = getDriver().findElement(Locator);
		js.executeScript("arguments[0].click();", Element);
	}
	
	public String getVisibleText(By locator) {
		
		WebElement element = getDriver().findElement(locator);
		return element.getText();
	}
	
	
	


}
