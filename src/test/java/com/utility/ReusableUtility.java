package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Random;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.constants.Browser;
import org.apache.commons.io.FileUtils;


public abstract class ReusableUtility {

	Logger logger = LoggerUtlity.getLogger(this.getClass());
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private WebDriverWait wait;

	

	public WebDriver getDriver() {
		return driver.get();
	}

	public ReusableUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
	}
	
	public ReusableUtility(Browser browserName) {
		logger.info("Lunching browser  "+browserName);
		
		if(browserName == Browser.CHROME) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--disable-save-password-bubble");
		options.addArguments("--disable-autofill-keyboard-accessory-view[8]");
		options.addArguments("--disable-autofill");
		driver.set(new ChromeDriver());
			
		}else if(browserName == Browser.FIREFOX) {
			
			driver.set(new FirefoxDriver());
			
		}else if(browserName == Browser.EDGE) {
			
			driver.set(new EdgeDriver());
			
		}else {
			
			System.err.println("Invalid BrowserName");
			logger.error("Invalid browsere Name");;
		}
		
	}

	public void goToWebsite(String url) {
		logger.info("Visiting the website "+url);
		getDriver().get(url);
//		getDriver().manage().window().maximize();
	}

	public void enterText(By Locator, String text) {
		logger.info("Finding Element with the locator "+Locator);
		WebElement Element = getDriver().findElement(Locator);
		Element.sendKeys(text);
		logger.info("Found the element and enter "+text);
	}

	public void clickOn(By Locator) {
		logger.info("Finding Element with the locator "+Locator);
		wait  = new WebDriverWait(getDriver(),Duration.ofSeconds(10));
		WebElement Element = driver.get().findElement(Locator);
		Element.click();
		logger.info("Element found and now performing click "+Locator);
		
	}
	
	public void selectDropDownValue(By Locator,String value ) {
		logger.info("Finding Element with the locator "+Locator);
		WebElement Element = driver.get().findElement(Locator);
		Select dropdown = new Select(Element);
		dropdown.selectByVisibleText(value);
		logger.info("Found the  "+value);
	}
	
	public void clickOnCheckboxByjs(By Locator) {
		logger.info("Finding Element with the locator "+Locator);
		wait = new WebDriverWait(getDriver(),Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor)driver.get();
		WebElement Element = getDriver().findElement(Locator);
		js.executeScript("arguments[0].click();", Element);
		logger.info("Javascript has performed for find element "+Element);
	}
	
	public String getVisibleText(By locator) {
		logger.info("Finding Element with the locator "+ locator);
		WebElement element = driver.get().findElement(locator);
		return element.getText();
		
	}
	
	
	
	public String generateEmailId() {
		int length = 8; 
		StringBuilder sb = new StringBuilder();
		Random random =  new Random();
		String characters = "abcdefghijklmnopqrstuvwxyz";
		
		for(int i =0;i<length;i++) {
			int index = random.nextInt(characters.length());
			sb.append(characters.charAt(index));	
		}
		
		return sb.toString()+"@gmail.com";
	
	}
	

	
	public String takeScreenshot(String name) {
		
		TakesScreenshot screenshot =  (TakesScreenshot)driver.get();
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timestamp = format.format(date);
		String path = System.getProperty("user.dir")+"//screenshots//"+" - "+name+"-"+timestamp+".png";
		File screenshotFile = new File(path);
		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return path;
		
	}
	
	


}
