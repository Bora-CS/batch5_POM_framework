package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.HeaderComponent;
import pages.LoginPage;
import pages.ProductListPage;
import testData.TestingData;

public class SetUpPage {

	public WebDriver driver;
	public static UtilityLibrary lib;
	public ValidationClass validate;
	public HeaderComponent header;
	public ProductListPage plp;
	public LoginPage login;
	
	@BeforeMethod
	public void startTest() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
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
	
	@AfterMethod
	public void endTest() {
		lib.waitTime(3);
		System.out.println("This is After method from Setup page");

		driver.quit();
	}
	
	
	
	
}
