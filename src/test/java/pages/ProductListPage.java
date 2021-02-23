package pages;

import org.openqa.selenium.By;

import testData.Locators;
import utilities.UtilityLibrary;

public class ProductListPage {
	UtilityLibrary lib;

	public  ProductListPage(UtilityLibrary passedLib) {
		this.lib = passedLib;
	}
	public String getProductNameIndex(int index) {
	String locatorText =	Locators.PLP_listOfProductName + "[" +index+ "]";
		return lib.getText(By.xpath(locatorText));
	}
}
