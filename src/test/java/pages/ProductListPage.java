package pages;

import org.openqa.selenium.By;

import testData.Locators;
import utilities.UtilityLibrary;

public class ProductListPage {
	UtilityLibrary lib;

	public ProductListPage(UtilityLibrary passedLib) {
		this.lib = passedLib;
	}
	public String getProductName(int index){
		String locatorText =Locators.plp_listOfProductNameByXpath+"["+index+"]";
		return lib.getText(By.xpath(locatorText));
	}
}
