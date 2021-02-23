package utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ValidationClass {

	private WebDriver driver;

	public ValidationClass(WebDriver passedDriver) {
		this.driver = passedDriver;
	}

	public boolean verifyElementExist(By locator) {

		List<WebElement> lists = driver.findElements(locator);
		boolean exist = lists.size() > 0;
		return exist;
	}

	public boolean verifySortElementExist(By locator, String name) {
		String firstName = driver.findElement(locator).getText();
		if (firstName.equals(name)) {
			return true;
		}

		return false;
	}

}
