package batch5_Framework_quiz;

import org.openqa.selenium.Keys;

import testData.Locators;

public class Quiz_Header extends Quiz_SetUpPage{


	
	public void changeStore(String store) {
		lib.clickElement(Locators.storeName);
		
		lib.fillTextBox(Locators.searchStoreTextBox, store + Keys.ENTER);
		lib.waitTime(2);
		lib.clickElement(Locators.Header_button_pickUpHere_first);
	}

	public void fillSeachBox(String searchData) {
		lib.fillTextBox(Locators.Header_searchTextBox, searchData);
		lib.fillTextBox(Locators.Header_searchTextBox, "" + Keys.ENTER);
	}
	
	
}
