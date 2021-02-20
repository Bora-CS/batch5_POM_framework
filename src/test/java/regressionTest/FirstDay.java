package regressionTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import testData.Locators;
import testData.TestingData;
import utilities.UtilityLibrary;
import utilities.ValidationClass;

public class FirstDay {
	static WebDriver driver;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "src/main/java/resource/chromedriver");
		driver = new ChromeDriver();

		UtilityLibrary lib = new UtilityLibrary(driver);
		ValidationClass validate = new ValidationClass(driver);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		try {
		// 1. Goto URL
		driver.get(TestingData.HomePageURL);
		// 2. Change store
		lib.clickElement(Locators.storeName);
		lib.fillTextBox(Locators.searchStoreTextBox, TestingData.ManassasStore + Keys.ENTER);
		lib.clickElement(Locators.pickUpButton_Manassas);
		lib.waitTime(2);
		// 3. Goto wine PLP - Product List page
		lib.clickElement(Locators.wineDepartment);
		// verify we are successfully land on the PLP
		//validate.verifyElementExist(Locators.winePLPHeader);
		boolean exist = validate.verifyElement(Locators.winePLPHeader, TestingData.winePageH1Text);
		if(!exist){
			System.out.println("The actual text should be [" +TestingData.winePageH1Text+"]");
		}
		// 4. Add first 5 products into cart
		List<WebElement> elems = driver.findElements(Locators.addToCart_Buttons);
		for (int i = 0; i < elems.size(); i++) {
			elems.get(i).click();
			lib.clickElement(Locators.plp_alert_close);
			if (i==4){
				break;
			}
		}
		// 5. Goto cart page
		lib.clickElement(Locators.cartIcon);
		
		validate.testPassed();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		lib.closeDriver(driver);
		}

	}

}
