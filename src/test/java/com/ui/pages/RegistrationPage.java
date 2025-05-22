package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static com.constants.Env.QA;
import com.ui.pojo.RegistrationPojo;
import com.utility.LoggerUtlity;
import com.utility.PropertiesUtil;
import com.utility.ReusableUtility;

public final class RegistrationPage extends ReusableUtility{
	
	Logger logger = LoggerUtlity.getLogger(this.getClass());
	
	private static final By TITLE_LOCATOR = By.xpath("//input[@id=\"id_gender1\"]");
	private static final By PASSWORD_LOCATOR= By.xpath("//input[@id=\"password\"]");
	private static final By DAY_LOCATOR= By.id("days");
	private static final By MONTHS_LOCATOR = By.id("months");
	private static final By YREARS_LOCATOR = By.id("years");
	private static final By NEWSLETTER_LOCATOR = By.xpath("//div[@class=\"checkbox\"]");
	private static final By OFFERS_LOCATOR = By.xpath("//input[@id=\"optin\"]");
	private static final By FRIST_NAME_LOCATOR = By.id("first_name");
	private static final By LAST_NAME_LOCATOR = By.id("last_name");
	private static final By COMPANY_LOCATOR = By.xpath("//input[@id=\"company\"]");
	private static final By ADDRESS1_LOCATOR = By.xpath("//input[@id=\"address1\"]");
	private static final By ADDRESS2_LOCATOR = By.xpath("//input[@id=\"address2\"]");
	private static final By STATE_LOCATOR = By.xpath("//input[@id=\"state\"]");
	private static final By CITY_LOCATOR = By.xpath("//input[@id=\"city\"]");
	private static final By ZIPCODE_LOCATOR = By.xpath("//input[@id=\"zipcode\"]");
	private static final By MOBILE_NUMBER_LOCATOR = By.xpath("//input[@id=\"mobile_number\"]");
	private static final By CREATE_ACCOUNT_BUTTON_LOCATOR = By.xpath("//input[@value=\"create_account\"]/following-sibling::button");
	
	

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	public AccountCreated enterRegistrationdetails(RegistrationPojo registrationPojo) {
		logger.info("For Signing  creation fill the all the deatils");
		clickOn(TITLE_LOCATOR);
		enterText(PASSWORD_LOCATOR,PropertiesUtil.getProperty(QA,"PASSWORD"));
		selectDropDownValue(DAY_LOCATOR, PropertiesUtil.getProperty(QA,"DATE"));
		selectDropDownValue(MONTHS_LOCATOR, PropertiesUtil.getProperty(QA,"MONTH"));
		selectDropDownValue(YREARS_LOCATOR, PropertiesUtil.getProperty(QA,"YEAR"));
		clickOnCheckboxByjs(NEWSLETTER_LOCATOR);
		clickOnCheckboxByjs(OFFERS_LOCATOR);
		enterText(FRIST_NAME_LOCATOR,registrationPojo.getFirstName());
		enterText(LAST_NAME_LOCATOR, registrationPojo.getLastName());
		enterText(COMPANY_LOCATOR, registrationPojo.getCompany());
		enterText(ADDRESS1_LOCATOR,registrationPojo.getAddress1());
		enterText(ADDRESS2_LOCATOR,registrationPojo.getAddress2());
		enterText(STATE_LOCATOR, registrationPojo.getState());
		enterText(CITY_LOCATOR, registrationPojo.getCity());
		enterText(ZIPCODE_LOCATOR,registrationPojo.getPostal());
		enterText(MOBILE_NUMBER_LOCATOR,registrationPojo.getMobile());
		clickOn(CREATE_ACCOUNT_BUTTON_LOCATOR);
		logger.info("For login all the the detials has filled");
		AccountCreated accountCreated = new AccountCreated(getDriver());
		return accountCreated;

	}
		

}
