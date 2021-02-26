package pages;

import org.openqa.selenium.By;

import testData.Locators;
import utilities.SetupPage;
import utilities.UtilityLibrary;

public class ProductListPage extends SetupPage {
	


	public String getProductName(int index){
		String locatorText =Locators.plp_listOfProductNameByXpath+"["+index+"]";
		return lib.getText(By.xpath(locatorText));
	}
	public void sortProduct(int index){
		lib.clickElement(Locators.sort_selectButton);
		lib.clickElementWithXpath(Locators.sortBy_index+"["+index+"]");
		//lib.clickElement(Locators.sortBy_customerRating);
	}
}
