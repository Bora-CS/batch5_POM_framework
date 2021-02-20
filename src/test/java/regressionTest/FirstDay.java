package regressionTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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

		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		lib = new UtilityLibrary(driver);
		validate = new ValidationClass(driver);
		header = new HeaderComponent(lib);
		plp = new ProductListPage(lib);

		driver.get(TestingData.HomePageURL);

	}

	@Test // Jira ID: Bora-327
	public void test_327() {

		header.changeStore(TestingData.Wilmington);

		header.fillSeachBox(TestingData.Bora_327_searchTerm);

		String name = plp.getProductNameByIndex(1);
		Assert.assertTrue(name.contains(TestingData.Bora_327_searchTerm));
	}

	// Jira id: Bora-324
	@Test(enabled = false)
	public void test_324() {

		// 2. Change store
		header.changeStore(TestingData.ManassasStore);

		// 3. Search for specific product
		header.fillSeachBox(TestingData.Bora_324_wineName);

		// 4. Verify product in PLP
		String name = plp.getProductNameByIndex(1);
		Assert.assertEquals(name, TestingData.Bora_324_wineName);
		// or
//		Assert.assertTrue(name.contains(TestingData.Bora_324_wineName));
	}

	@Test(enabled = false)
	public void firstTest() {

		// 2. Change store
		lib.clickElement(Locators.storeName);
		lib.fillTextBox(Locators.searchStoreTextBox, TestingData.ManassasStore + Keys.ENTER);
		lib.clickElement(Locators.pickUpButton_Manassas);

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

	@AfterMethod
	public void endTest() {
		driver.quit();
	}

}
