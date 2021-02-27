package regressionTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
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

	@Test(priority = 1)
	public void wrongUserNameFormat() {

		login.clickSignInButtonFromHeader();
		login.fillEmailAddress(TestingData.Bora_351_wrongEmailAddress);
		login.fillPasswordField("");
		String message = login.getErrorMessageForEmail();
		AssertJUnit.assertEquals(message, TestingData.ExpectingErrorMessageForEmail);
	}

	@Test(priority = 2)
	public void emptyPassword() {

		login.clickSingInButton();

		String message = login.getErrorMessageForPassword();
		AssertJUnit.assertEquals(message, TestingData.ExpectingErrorMessageForPassword);
	}

	@Test(priority = 3)
	public void loginTest() {
		
		login.fillEmailAddress(TestingData.userName_1);
		login.fillPasswordField(TestingData.password_1);
		login.clickSingInButton();
		//verify
	}
	
	
	@BeforeClass
	public void startTest() {
		
		//setup webDriver
		//open browser - goto URL
		//Initialize all of -Needed- pages object
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
		driver = new ChromeDriver();	
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(TestingData.HomePageURL);
		login= new LoginPage();
		lib = new UtilityLibrary(driver);
	}
	
	
	@AfterClass
	public void endTest() {
		//end test
		driver.quit();
	}
	
}
