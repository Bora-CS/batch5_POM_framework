package batch5_Framework_quiz;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import testData.TestingData;

public class Quiz_SetUpPage {

	
	public WebDriver driver;
	public static Quiz_Library lib;
	public Quiz_Header header;
	public Quiz_ProductListPage plp;

	@BeforeMethod
	public void startTest() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();	
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		lib = new Quiz_Library(driver);

		driver.get(TestingData.HomePageURL);
		header=new Quiz_Header();
		plp = new Quiz_ProductListPage();
		
	}
	
	@AfterMethod
	public void endTest() {

		driver.quit();
	}
	
	
}
