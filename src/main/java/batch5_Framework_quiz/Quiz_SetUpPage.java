package batch5_Framework_quiz;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import pages.ProductListPage;
import testData.TestingData;

public class Quiz_SetUpPage {

	
	public WebDriver driver;
	public static Quiz_Library lib;
	public Quiz_Header header;
	public Quiz_ProductListPage plp;

	@BeforeTest
	public void startTest() {
		
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
		driver = new ChromeDriver();	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
		lib = new Quiz_Library(driver);

		driver.get(TestingData.HomePageURL);
		
		
		header = new Quiz_Header();
		plp = new Quiz_ProductListPage();

	}
	
	@AfterTest
	public void endTest() throws InterruptedException {
		
		Thread.sleep(5000);
		driver.quit();
	}
	
	
}
