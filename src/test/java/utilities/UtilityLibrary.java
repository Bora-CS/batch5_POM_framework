package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testData.Locators;

public class UtilityLibrary {

	private WebDriver driver;
	private boolean  localRun=true;
	private int localRunningTime=2;
	
	
	public UtilityLibrary(WebDriver passedDriver){
		this.driver = passedDriver;
	}
	
	
	public String getText(By locator) {
		String text = driver.findElement(locator).getText();
		return text;
	}
	
	public void waitTime(int second){
		try {
			Thread.sleep(second*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void waitTime(double second) {
		int time = (int) (second*1000);
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void fillTextBox(By locator, String testData){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		localRun(locator);
		driver.findElement(locator).sendKeys(testData);
	}
	
	public void clickElement(By locator){
		localRun(locator);
		driver.findElement(locator).click();
	}
	
	public List<WebElement> getListOfElements(By locator){
		return driver.findElements(locator);
	}
	
	private void localRun(By locator) {
		if( localRun) {
			waitTime(localRunningTime);
			highLightElenment(locator);
		}
	}
	
	
	public String takeScreenShot(String testName) {
		
		String filePath = "test-output/screenshots/"+testName+getCurrentTime()+".png";
		try {
		//1. take a screenshot
		TakesScreenshot shot = (TakesScreenshot)driver;
		File screenShotFile = shot.getScreenshotAs(OutputType.FILE);
		//2. save this screenshot Object to the file
		
			
			System.out.println("filePath is: "+filePath);
			File targetFile=new File(filePath);
			FileUtils.copyFile(screenShotFile, targetFile);
		} catch (IOException e) {
			System.out.println("Uable to create the ScreenShot");
			e.printStackTrace();
		}
		
		return filePath;
	}
	
	public String getCurrentTime() {
		//2021  -  3   -  6    2: 15 
		SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		Date today =  new Date();
		
		String returnData = dataFormat.format(today);		
		
		return returnData;
	}
	
	
	
	
	
	private void highLightElenment(By locator ) {

		WebElement targetElement = driver.findElement(locator);
		//1. we need to call/create a javScript
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for(int i = 0 ;i <2 ; i++) {
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);",targetElement,
						"color: red; border: 5px solid red;");
			waitTime(0.5);
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);",targetElement,
						"");
			waitTime(0.5);
		}
		
	}
	
}
