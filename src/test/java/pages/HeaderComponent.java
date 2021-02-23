package pages;

import org.openqa.selenium.Keys;

import testData.Locators;
import testData.TestingData;
import utilities.UtilityLibrary;

public class HeaderComponent {

	UtilityLibrary lib;

	public HeaderComponent(UtilityLibrary passedLib) {
		this.lib = passedLib;
	}

	public void changeStore(String store) {
		lib.clickElement(Locators.storeName);
		lib.fillTextBox(Locators.searchStoreTextBox, store + Keys.ENTER);
		lib.clickElement(Locators.Header_PickUpHereButtom_first);
	}

	public void fillSearchBox(String searchData) {
		lib.fillTextBox(Locators.Header_searchItemsTextBox, searchData + Keys.ENTER);
	}

}
