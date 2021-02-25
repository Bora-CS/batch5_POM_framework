package regressionTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HeaderComponent;
import pages.LoginPage;
import pages.ProductListPage;
import testData.TestingData;
import utilities.SetUpPage;
import utilities.UtilityLibrary;
import utilities.ValidationClass;

public class Smoke_NegativeTesting extends SetUpPage {

	@Test
	public void wrongUserNameFormat() {
		
		login.clickSignInButtonFromHeader();
		login.fillEmailAddress(TestingData.Bora_351_wrongEmailAddress);
		login.fillPasswordField("");
		String message = login.getErrorMessageForEmail();
		Assert.assertEquals(message, TestingData.ExpectingErrorMessageForEmail);
	}

	@Test
	public void emptyPassword() {
		
		login.clickSignInButtonFromHeader();
		login.clickSingInButton();
		
		String message = login.getErrorMessageForPassword();
		Assert.assertEquals(message, TestingData.ExpectingErrorMessageForPassword);
	}
	
	@Test
	public void loginTest() {
		//login successfully 
	}
	

	
}
