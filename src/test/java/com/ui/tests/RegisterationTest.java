package com.ui.tests;

import static com.constants.Browser.*;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.ui.pages.AccountCreated;
import com.ui.pages.HomePage;
import com.ui.pages.SignupAndLoginPage;
import com.ui.pojo.RegistrationPojo;
import com.utility.FakeAddressUtility;
import com.utility.PropertiesUtil;
import static com.constants.Env.*;

public class RegisterationTest {

	private SignupAndLoginPage signupAndLoginPage;
	private RegistrationPojo registrationPojo;
	private AccountCreated accountCreated;

	@BeforeMethod(description = "Lunch browser and go to signinpage")
	public void setup() {

		signupAndLoginPage = new SignupAndLoginPage(CHROME);
	}

	@Test(description = "verfiy the registraion details for signin", groups = { "e2e", "sanity", "smoke" })
	public void registrationTest() {

		HomePage data
		= signupAndLoginPage.enterNameAndMailid(PropertiesUtil.getProperty(QA,"USERNAME"),PropertiesUtil.getProperty(QA,"EMAIL"))
		.enterRegistrationdetails(FakeAddressUtility.getFakeAddress()).goToAccountCreatedPage();

		
	}

}
