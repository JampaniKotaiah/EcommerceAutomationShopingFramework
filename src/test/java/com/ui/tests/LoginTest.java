package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.ui.pages.HomePage;
import com.utility.FakeAddressUtility;
import com.utility.PropertiesUtil;
import static com.constants.Env.*;



@Listeners({com.ui.listeners.TestListners.class})
public class LoginTest extends TestBase{
	
	@Test(description = "verfiy the Login details for shopping", groups = { "e2e", "sanity",
	"smoke" }, retryAnalyzer = com.ui.listeners.MyRetryAnalyer.class)

public void registrationTest() {
		
		String customerName = signupAndLoginPage.goToHomePageForShopping().getUserName();
		Assert.assertEquals(customerName,PropertiesUtil.getProperty(QA,"USERNAME"));
}

}
