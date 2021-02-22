package pages;

import org.openqa.selenium.Keys;

import testData.Locators;
import testData.TestingData;
import utilities.UtilityLibrary;

public class HeaderComponet {
	UtilityLibrary lib;

	public HeaderComponet(UtilityLibrary passedLib) {
		this.lib = passedLib;
	}

	public void changStore(String store) {

		lib.clickElement(Locators.storeName);
		lib.fillTextBox(Locators.searchStoreTextBox, store + Keys.ENTER);
		lib.clickElement(Locators.header_button_firstPickUpHere);
		lib.waitTime(2);
		

	}
	public void fillSearchBox(String searchData){
	lib.fillTextBox(Locators.header_searchBar, searchData);
	lib.fillTextBox(Locators.header_searchBar, ""+ Keys.ENTER);
	}
}
