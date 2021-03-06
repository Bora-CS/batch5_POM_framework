package utilities;

import java.io.File;
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

public class UtilityLibrary {

	private WebDriver driver;
	private boolean localRun = false;
	private int localRunningTime = 2;

	public UtilityLibrary(WebDriver passedDriver) {
		this.driver = passedDriver;
	}

	public String getText(By locator) {
		String text = driver.findElement(locator).getText();
		return text;
	}

	public void waitTime(int second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void waitTime(double second) {
		int time = (int) (second * 1000);
		
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void fillTextBox(By locator, String testData) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		localRun(locator);
		driver.findElement(locator).sendKeys(testData);
	}

	public void clickElement(By locator) {
		localRun(locator);
		driver.findElement(locator).click();
	}

	public List<WebElement> getListOfElements(By locator) {
		return driver.findElements(locator);
	}

	
	private void localRun(By locator) {
		if (localRun) { // when needed, I want to wait for a second
//			waitTime(localRunningTime);
			highLightElement(locator);
		}
	}
	
	
	
	public String takeScreenShot(String testName) {
		
		//1.take a screenshot --> Object
		TakesScreenshot shot = (TakesScreenshot) driver;
		File screenshotFile = shot.getScreenshotAs(OutputType.FILE);
		
		//2.save this screenshot object into file
		String screenshotPath = "test-output/screenshots/"+testName+getCurrentTime()+".png";
		try {
		File targetFile = new File(screenshotPath);
		FileUtils.copyFile(screenshotFile, targetFile);
		}catch(Exception e) {
			System.out.println("Unable to create screenshot");
			e.printStackTrace();
		}
		return screenshotPath;
	}
	
	
	public String getCurrentTime() {
		//   2021   -   3/Mar   -  6    2 :  15 :  32 .  1556546
		//   yyyy   -  MM/MMM   -  dd   HH:  mm :  ss .  SSS
		
		SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date today = new Date();
		String returnDate = dataFormat.format(today);
		
		return returnDate;
	}

	
	
	private void highLightElement(By locator) {	
		//0. we need to have a an element to change
		WebElement targetElement = driver.findElement(locator);
		//1. we need to call/create a javaScript executer
		JavascriptExecutor js =  (JavascriptExecutor) driver;
		
		//2. we can change the background color of an element
		for(int i=0;i<3;i++) {

			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", targetElement,
					"border: 5px solid red;");
			waitTime(0.5);
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", targetElement,
					"");
			waitTime(0.5);
		}
	}
	
	
}
