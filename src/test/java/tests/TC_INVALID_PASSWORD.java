package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import factory.PageInstance;
import pages.LoginPage;

@Test(testName = "Invalid password", description = "Error message should be displayed when user enters invalid password")
public class TC_INVALID_PASSWORD extends BaseTest{
	
	@Test
	public void invalidCredentialsTest() {
		LoginPage loginPage = PageInstance.getInstance(LoginPage.class);
		loginPage.enterLoginId();
		loginPage.enterInvalidPassword();
		loginPage.enterCAPTCHA();
		loginPage.clickLoginButton();
		Assert.assertTrue(loginPage.getInvalidCredentialsErrorMessage().isDisplayed());
	}

}
