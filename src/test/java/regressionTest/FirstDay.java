package regressionTest;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.AddProductPage;
import pages.HeaderComponet;
import pages.ProductListPage;
import testData.Locators;
import testData.TestingData;
import utilities.UtilityLibrary;
import utilities.ValidationClass;

public class FirstDay {
	static WebDriver driver;

	UtilityLibrary lib;
	ValidationClass validate;
	HeaderComponet header;
	ProductListPage plp;
	AddProductPage app;

	@BeforeMethod
	public void startTest() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
		driver = new ChromeDriver();
		lib = new UtilityLibrary(driver);
		validate = new ValidationClass(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(TestingData.HomePageURL);
		header = new HeaderComponet(lib);
		plp = new ProductListPage(lib);
		app = new AddProductPage(lib);
	}
	@AfterMethod
	public void endTest() {
		driver.close();
		driver.quit();
	}
	
	@Test
	public void firstTest() {
		header.changStore(TestingData.ManassasStore);
		lib.waitTime(2);
		lib.clickElement(Locators.wineDepartment);
		lib.waitTime(2);
		app.rightPage( TestingData.winePageH1Text);
		app.addItemToCart(5);
		lib.clickElement(Locators.cartIcon);
	}
	
	@Test
	public void test_324() {
		header.changStore(TestingData.ManassasStore); //change store
		lib.waitTime(2);
		header.fillSearchBox(TestingData.bora_324wineName); // search for specific product
		String productName = plp.getProductName(1).toLowerCase(); // verify product in plp
		Assert.assertTrue(productName.contains(TestingData.bora_324wineName.toLowerCase()));
	}
	
	@Test
	public void test_327(){
		header.changStore(TestingData.WilmingtonStore);
		lib.waitTime(2);
		header.fillSearchBox(TestingData.bora_327productName);
		String productName =plp.getProductName(1);
		Assert.assertTrue(productName.contains(TestingData.bora_327productName));
	}
}
