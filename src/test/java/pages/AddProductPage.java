package pages;




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

	public boolean verifyElement (String elementText){
		String actualText = lib.getText(Locators.winePLPHeader).toLowerCase();
		if (actualText.equals(elementText)){
		return true;
		} 
		return false;
	}
	
	public void addItemToCart(int itemNumber) {
		for (int i = 1; i <= itemNumber; i++) {
			lib.clickElementWithXpath(Locators.addToCart_Buttons+"["+i+"]");
			lib.clickElement(Locators.plp_alert_close);
			if (i== itemNumber) {
				break;
			}
		}
	}
	

}
