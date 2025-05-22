package com.ui.tests;

import static com.constants.Browser.CHROME;
import static com.constants.Env.QA;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.ui.pages.HomePage;
import com.ui.pages.SignupAndLoginPage;
import com.utility.FakeAddressUtility;
import com.utility.PropertiesUtil;


@Listeners({com.ui.listeners.TestListners.class})
public class RegisterationTest {

	private SignupAndLoginPage signupAndLoginPage;

	@BeforeMethod(description = "Lunch browser and go to signinpage")
	public void setup() {

		signupAndLoginPage = new SignupAndLoginPage(CHROME);
	}

	@Test(description = "verfiy the registraion details for signin", groups = { "e2e", "sanity",
			"smoke" }, retryAnalyzer = com.ui.listeners.MyRetryAnalyer.class)

	public void registrationTest() {

		HomePage data = signupAndLoginPage
				.enterNameAndMailid(FakeAddressUtility.getFakeMailAndPassword())
				.enterRegistrationdetails(FakeAddressUtility.getFakeAddress()).goToAccountCreatedPage();

	}

}
