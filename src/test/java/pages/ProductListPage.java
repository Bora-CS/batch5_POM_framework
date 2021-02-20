package pages;

import org.openqa.selenium.By;

import testData.Locators;
import utilities.UtilityLibrary;

public class ProductListPage {

	UtilityLibrary lib;
	
	public ProductListPage(UtilityLibrary passedLib) {
		this.lib = passedLib;
	}
	
	public String getProductNameByIndex(int index) {
		String locatorText = Locators.PLP_listOfProductName      + "["  +index+"]";
		                     //(//h2[contains(@class,'title')])  +  [   +3    + ]
		//(//h2[contains(@class,'title')])[3]
		// passed index as 3

		return lib.getText(By.xpath(locatorText));
	}
	
	
}
