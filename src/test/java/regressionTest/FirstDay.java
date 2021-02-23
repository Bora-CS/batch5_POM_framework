package regressionTest;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;

import pages.HeaderComponent;
import pages.ProductListPage;
import testData.Locators;
import testData.TestingData;
import utilities.UtilityLibrary;
import utilities.ValidationClass;

public class FirstDay {

	static WebDriver driver;
	UtilityLibrary lib;
	ValidationClass validate;
	HeaderComponent header;
	ProductListPage plp;

	@BeforeMethod
	public void startTest() {

		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		lib = new UtilityLibrary(driver);
		validate = new ValidationClass(driver);
		header = new HeaderComponent(lib);
		plp = new ProductListPage(lib);

		driver.get(TestingData.HomePageURL);

	}

	@Test(enabled = true)
	public void firstTest() {

		header.changeStore(TestingData.ManassasStore);
		// wait 2 second
		lib.waitTime(2);

		// 3. Goto wine PLP - Product List page
		lib.clickElement(Locators.wineDepartment);
		// verify we are successfully land on the PLP
		validate.verifyElementExist(Locators.winePLPHeader);

		// 4. Add first 5 products into cart
		List<WebElement> elems = driver.findElements(Locators.addToCart_Buttons);
		for (int i = 0; i < 5; i++) {
			elems.get(i).click();
			lib.clickElement(Locators.plp_alert_close);
		}

		// 5. Goto cart page
		lib.clickElement(Locators.cartIcon);

	}

	@Test(enabled = false)
	public void sencondTest_2() {

		header.changeStore(TestingData.ManassasStore);
		header.fillSearchBox(TestingData.sencondTest_2_WineName);
		String name = plp.getProductName(1);
		Assert.assertTrue(name.contains(TestingData.sencondTest_2_WineName));

	}

	@Test(enabled = false)
	public void thirdTest_3() {
		header.changeStore(TestingData.WilmingtonStore);
		header.fillSearchBox(TestingData.thirdTest_3_WineName);
		String name = plp.getProductName(1);
		Assert.assertTrue(name.contains(TestingData.thirdTest_3_WineName));
	}

//	manul Test: Jira ID Bora-342
//	1.Goto Totalwine URL
//	2.Go to Wine PLP
//	3.Validate sort functionality

	@Test(enabled = false)
	public void testBora_342() {

	 header.fillSearchBox(TestingData.TestBora_342_SearchName);
	 lib.clickElement(Locators.sort_Button);
	
	 

	@AfterMethod
	public void endTest() {
		driver.quit();
	}

}
