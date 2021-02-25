package pages;

import org.openqa.selenium.Keys;

import testData.Locators;
import utilities.SetUpPage;

public class HeaderComponent extends SetUpPage{



	public void changeStore(String store) {
		lib.clickElement(Locators.storeName);
		
		lib.fillTextBox(Locators.searchStoreTextBox, store + Keys.ENTER);
		lib.clickElement(Locators.Header_button_pickUpHere_first);
	}

	public void fillSeachBox(String searchData) {
		lib.fillTextBox(Locators.Header_searchTextBox, searchData);
		lib.fillTextBox(Locators.Header_searchTextBox, "" + Keys.ENTER);
	}

	public void gotoWineDepartment() {
		lib.clickElement(Locators.wineDepartment);
	}

	public void gotoCartpage() {
		lib.clickElement(Locators.cartIcon);
	}

}
