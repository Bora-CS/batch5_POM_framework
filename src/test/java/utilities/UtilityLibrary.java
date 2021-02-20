package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UtilityLibrary {

	private WebDriver driver;
	
	public UtilityLibrary(WebDriver passedDriver){
		this.driver = passedDriver;
	}
	
	
	
	
	public void waitTime(int second){
		try {
			Thread.sleep(second*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void fillTextBox(By locator, String testData){
		driver.findElement(locator).sendKeys(testData);
	}
	
	public void clickElement(By locator){
		driver.findElement(locator).click();
	}
}
