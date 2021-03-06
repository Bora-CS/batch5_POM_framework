package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import testData.Locators;
import utilities.SetUpPage;

public class ProductListPage extends SetUpPage{


	
	public String getProductNameByIndex(int index) {
		String locatorText = Locators.PLP_listOfProductName      + "["  +index+"]";
		                     //(//h2[contains(@class,'title')])  +  [   +3    + ]
		//(//h2[contains(@class,'title')])[3]
		// passed index as 3
		return lib.getText(By.xpath(locatorText));
	}
	
	public void addMultipleProduct(int total) {
		List<WebElement> elems = lib.getListOfElements(Locators.addToCart_Buttons);
		
		for (int i = 0; i < total; i++) {
			elems.get(i).click();
			lib.clickElement(Locators.plp_alert_close);
		}
		
	}
	
	
}
