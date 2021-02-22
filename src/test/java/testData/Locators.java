package testData;

import org.openqa.selenium.By;

public class Locators {

	final public static By storeName = By.id("at_myLocation_Secondary");
	final public static By searchStoreTextBox = By.xpath("//*[@aria-labelledby='TextInputLbl1']");
	final public static By pickUpButton_Manassas = By.xpath("//*[@anclick='header_store_pickup_209']");
	final public static By wineDepartment = By.id("AT_headerwine_desktop");

	final public static By winePLPHeader = By.xpath("//h1[text()='Wine']");
	final public static By addToCart_Buttons = By.xpath("//*[text()='Add to Cart']");
	final public static By plp_alert_close = By.id("agegate-closeX");

	final public static By cartIcon = By.id("at_cartIcon");
	final public static By header_searchBar = By.xpath("//input[@type='text']");
	final public static String plp_listOfProductNameByXpath="(//h2[contains(@class,'title')])";
	final public static By header_button_firstPickUpHere = By.xpath("(//*[text()='Pick Up Here'])[1]");
}
