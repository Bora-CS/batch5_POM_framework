
package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.AddProductPage;
import pages.HeaderComponet;
import pages.ProductListPage;
import pages.SignInPage;
import testData.TestingData;

public class SetupPage {
	public WebDriver driver;
	public UtilityLibrary lib;
	public ValidationClass validate;
	protected HeaderComponet header;
	public ProductListPage plp;
	public AddProductPage app;
	public SignInPage sip;
	
	@BeforeMethod
	public void startTest(){
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
		driver = new ChromeDriver ();

		lib = new UtilityLibrary(driver);
		validate = new ValidationClass(driver);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(TestingData.HomePageURL);
		
		header = new HeaderComponet();
		plp = new ProductListPage();
		//app = new AddProductPage(lib);
		sip = new SignInPage();
	}
	
	@AfterMethod
	public void endTest(){
		driver.quit();
	}
	
	

}
