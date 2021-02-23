package testData;

import org.openqa.selenium.By;

public class Locators {

	final public static By storeName = By.id("globalStoreName_mobile");
	final public static By searchStoreTextBox = By.xpath("//input[@type='text']");
	final public static By pickUpButton_Manassas = By.xpath("//*[@anclick='header_store_pickup_209']");
	final public static By wineDepartment = By.id("AT_headerwine_desktop");
	final public static By Header_searchItemsTextBox = By.xpath("//*[@data-at='header-search-text']");
	final public static String PLP_listofProductName = "(//*[@class='title__2RoYeYuO titleDown__BwxDDzkX'])";
	final public static By Header_PickUpHereButtom_first = By.xpath("(//*[@anclick=\\\"header_store_pickup_214\\\"])");

	final public static By winePLPHeader = By.xpath("//h1[text()='Wine']");
	final public static By addToCart_Buttons = By.xpath("//*[text()='Add to Cart']");
	final public static By plp_alert_close = null;

	final public static By cartIcon = null;
	
	
	final public static By sort_Button=By.xpath("//*[@aria-label='Sort: Relevance']");
	final public static By plp_SortProductName=By.id("product-130007750-1-0_Title");
}
