package tests;

import org.testng.annotations.Test;

import components.Menu;
import factory.PageInstance;
import factory.WebDriverManager;
import pages.LoginPage;
import pages.ProfilePage;


@Test(testName = "Create User Profile", description="Fill User Details and save to create User Profile")
public class TC_CREATE_PROFILE extends BaseTest {
	
	
	
	@Test
	public void createProfileTest() {
		LoginPage loginPage = PageInstance.getInstance(LoginPage.class);
		loginPage.enterCaptchaAndLogin();
		Menu menu = new Menu(WebDriverManager.getDriver());
		menu.navigateToProfile();
		ProfilePage profilePage = PageInstance.getInstance(ProfilePage.class);
		profilePage.selectNominationType();
		profilePage.enterDepartment();
		profilePage.enterPermanentAddress();
		profilePage.enterPostalAddress();
		profilePage.enterDateOfBirth();
		profilePage.clickSubmitButton();
		
	}	

}
