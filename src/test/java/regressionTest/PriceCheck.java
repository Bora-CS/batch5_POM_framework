package regressionTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dataDirvenTest.GetDataFromFile;
import pages.HeaderComponent;
import pages.LoginPage;
import pages.ProductListPage;
import testData.Locators;
import testData.TestingData;
import utilities.SetUpPage;
import utilities.UtilityLibrary;
import utilities.ValidationClass;

public class PriceCheck extends SetUpPage {

	@Test(dataProvider = "dataSouce", dataProviderClass = GetDataFromFile.class)
	public void checkPriceForFairFaxStore(String productId, String price) {

		header.changeStore(TestingData.FairfaxStore);

		header.fillSeachBox(productId);

		lib.clickElement(By.xpath("//*[contains(@class, ‘twmIcon’)]"));
		
		String priceValue = lib.getText(By.xpath("//*[@class='pricing__1WsMi-bu ']")).replace("$", "");
		
		Assert.assertEquals(priceValue,price);
		//lib.clickElement(By.xpath("//*[contains(@class, ‘twmIcon’)]"));
		System.out.println("This  is data :"+productId+"  "+ price);


	}

	@BeforeClass
	public void startTest() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		lib = new UtilityLibrary(driver);
		validate = new ValidationClass(driver);
		header = new HeaderComponent();
		plp = new ProductListPage();
		login = new LoginPage();

		driver.get(TestingData.HomePageURL);
		System.out.println("This is before method from Setup page");
		lib.waitTime(3);

	}
    @AfterClass
	public void endTest(ITestResult testResult) {
		lib.waitTime(3);
		if (!testResult.isSuccess()) {
			String testName = testResult.getName()+testResult.getEndMillis();

			lib.takeScreenShot(testName);
		}

		System.out.println("This is After method from Setup page");
		driver.quit();
	}


}
