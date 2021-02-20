package regressionTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import testData.Locators;
import testData.TestingData;
import utilities.UtilityLibrary;
import utilities.ValidationClass;

public class FirstDay {

	static WebDriver driver;
	private static TimeUnit TimeOut;

	@Test
	public void firstTest() {

		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeOut);

		UtilityLibrary lib = new UtilityLibrary(driver);
		ValidationClass validate = new ValidationClass(driver);

		// 1. Goto URL
		driver.get(TestingData.HomePageURL);

		// 2. Change store
		lib.clickElement(Locators.storeName);
		lib.fillTextBox(Locators.searchStoreTextBox, TestingData.ManassasStore + Keys.ENTER);
		lib.clickElement(Locators.pickUpButton_Manassas);
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

	@AfterMethod

	public void endTest() {
		driver.quit();
	}

}
