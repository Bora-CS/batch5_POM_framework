package batch5_Framework_quiz;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import testData.TestingData;

public class Quiz_SetUpPage {

	
	public WebDriver driver;
	public Quiz_Library lib;

	
	public void startTest() {
		driver = new ChromeDriver();	
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		lib = new Quiz_Library(driver);

		driver.get(TestingData.HomePageURL);
		
	}
	
	
	public void endTest() {

		driver.quit();
	}
	
	
}
