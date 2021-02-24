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
	public UtilityLibrary lib;
	public ValidationClass validate;
	public HeaderComponent header;
	public ProductListPage plp;
	
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
	
	@AfterMethod
	public void endTest() {
		driver.quit();
	}
	
	
	
	
}
