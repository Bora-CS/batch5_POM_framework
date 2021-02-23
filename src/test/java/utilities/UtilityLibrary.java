package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilityLibrary {

	private WebDriver driver;

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

	public void fillTextBox(By locator, String testData) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		driver.findElement(locator).sendKeys(testData);
	}

	public void clickElement(By locator) {
		driver.findElement(locator).click();
	}

}
