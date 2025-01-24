package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import factory.PageInstance;
import pages.LoginPage;

@Test(testName = "Invalid Username", description = "Error message should be displayed when user tries to login with invalid username")
public class TC_INVALID_USERNAME extends BaseTest {
	
	@Test
	public void invalidLoginTest() {
		LoginPage loginPage = PageInstance.getInstance(LoginPage.class);
		loginPage.enterInvalidLoginId();
		loginPage.enterPassword();
		loginPage.enterCAPTCHA();
		loginPage.clickLoginButton();
		Assert.assertTrue(loginPage.getInvalidCredentialsErrorMessage().isDisplayed());
	}

}
