package regressionTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HeaderComponent;
import pages.LogInPage;
import pages.ProductListPage;
import testData.TestingData;
import utilities.SetUpPage;
import utilities.UtilityLibrary;
import utilities.ValidationClass;

public class Smoke_NegativeTesting extends SetUpPage {

	LogInPage login = new LogInPage();

	@Test(priority = 1)
	public void signIn_negativeTesting() {
		login.clickSginInButtonFromHeader();
		login.fillEmailAddress(TestingData.invalidEmail);
		login.fillPassdWord(TestingData.password);
		login.clickSginInButton();
		String emailErrorMessage = login.getErrorMessage_email();
		Assert.assertEquals(emailErrorMessage, TestingData.expectErrorMessage_email);

	}

	@Test(priority = 2)
	public void emptyPassword() {
		login.clickSginInButtonFromHeader();
		login.fillEmailAddress(TestingData.emailAddress);
		login.fillPassdWord(TestingData.emptyPassword);
		login.clickSginInButton();
		String passwordErrorMessage = login.getErrorMessage_password();
		Assert.assertEquals(passwordErrorMessage, TestingData.expectErrorMessage_password);
	}

	@Test(priority = -1)
	public void loginTest() {
		login.clickSginInButtonFromHeader();
		login.fillEmailAddress(TestingData.emailAddress);
		login.fillPassdWord(TestingData.password);
		login.clickSginInButton();

	}
	 @BeforeClass
		public void satrtTest() {
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(TestingData.HomePageURL);
			
			lib = new UtilityLibrary(driver);
			validate = new ValidationClass(driver);
			header = new HeaderComponent();
			plp = new ProductListPage(lib);
			
			
			driver.get(TestingData.HomePageURL);
		}
	 @AfterClass
	 public void endTest() {
		 driver.quit();
	 }

}
