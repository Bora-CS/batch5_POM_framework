package regressionTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import testData.Locators;
import utilities.SetUpPage;
import utilities.UtilityLibrary;

public class ProductListPage extends SetUpPage{
	
	
	
	
	public String getProductNameByIndex (int index) {
		String locatorText = Locators.PLP_listOfProductName +"["+index+"]";
		return lib.getText(By.xpath(locatorText));
	}
	public void addMultipleProduct (int total) {
		
		
	}
}
