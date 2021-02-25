package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.HeaderComponent;
import pages.ProductListPage;
import testData.TestingData;

public class SetUpPage {

	
	public WebDriver driver;
	
	public static UtilityLibrary lib;
	public ValidationClass validate;
	public HeaderComponent header;
	public ProductListPage plp;
	

	 @BeforeMethod
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
	 @AfterMethod
	 public void endTest() {
		 driver.quit();
	 }
}
