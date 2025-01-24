package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import components.Menu;
import factory.PageInstance;
import factory.WebDriverManager;
import pages.LoginPage;
import pages.ProfilePage;


@Test(testName = "Clear All Fields", description = "To check that input entered in fields is cleared when user clicks on Clear Button")
public class TC_CLEAR_FIELDS extends BaseTest{
	
	@Test
	public void clearAllFields() {
		LoginPage loginPage = PageInstance.getInstance(LoginPage.class);
		loginPage.enterCaptchaAndLogin();
		Menu menu = new Menu(WebDriverManager.getDriver());
		menu.navigateToProfile();
		ProfilePage profilePage = PageInstance.getInstance(ProfilePage.class);
		profilePage.selectNominationType();
		profilePage.enterDepartment();
		profilePage.enterPostalAddress();
		profilePage.enterPermanentAddress();
		profilePage.enterDateOfBirth();
		profilePage.clickCancelButton();
		Assert.assertTrue(!profilePage.getNominationTypeDropDown().isSelected());
		Assert.assertTrue(profilePage.getDateOfBirth().getText().isEmpty());
		Assert.assertTrue(profilePage.getDepartment().getText().isEmpty());
		Assert.assertTrue(profilePage.getPostalAddress().getAttribute("value").isEmpty());
		Assert.assertTrue(profilePage.getPermanentAddress().getAttribute("value").isEmpty());
	}

}
