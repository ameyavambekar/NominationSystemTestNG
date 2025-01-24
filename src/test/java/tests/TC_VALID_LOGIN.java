package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import factory.PageInstance;
import pages.DashboardPage;
import pages.LoginPage;

@Test(testName = "Login with valid credentials", description = "Testing the login Functionality", priority = 1)
public class TC_VALID_LOGIN extends BaseTest {
	
	@Test
	public void loginTest() {
		LoginPage loginPage = PageInstance.getInstance(LoginPage.class);
		DashboardPage dashboardPage = PageInstance.getInstance(DashboardPage.class);
		loginPage.enterCaptchaAndLogin();
		Assert.assertTrue(dashboardPage.getHeader().isDisplayed());
	}
	
}
