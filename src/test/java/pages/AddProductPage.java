package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import testData.Locators;
import testData.TestingData;
import utilities.UtilityLibrary;
import utilities.ValidationClass;

public class AddProductPage {
	UtilityLibrary lib;
	ValidationClass val;

	public AddProductPage(UtilityLibrary passedLib) {
		this.lib = passedLib;
	}
	public AddProductPage(ValidationClass passedVal){
		this.val = passedVal;
	}

	public void addItemToCart(int itemNumber) {
		for (int i = 0; i <= itemNumber-1; i++) {
			List<WebElement> elems = lib.addToCartButtonElement(Locators.addToCart_Buttons);
			elems.get(i).click();
			lib.clickElement(Locators.plp_alert_close);
			if (i== itemNumber-1) {
				break;
			}
		}
	}
	public void rightPage(String expectedData){
		boolean exist = val.verifyElement(Locators.winePLPHeader, expectedData);
		if (!exist) {
			System.out.println("The text should be [" + expectedData + "]");
		}
	}
	

}
