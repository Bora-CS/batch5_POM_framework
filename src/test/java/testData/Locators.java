package testData;

import org.openqa.selenium.By;

public class Locators {

	final public static By storeName = By.id("at_myLocation_Secondary");
	final public static By searchStoreTextBox = By.xpath("//*[@aria-labelledby='TextInputLbl1']");
	final public static By pickUpButton_Manassas = By.xpath("//*[@anclick='header_store_pickup_209']");
	final public static By wineDepartment = By.id("AT_headerwine_desktop");

	final public static By winePLPHeader = By.xpath("//h1[text()='Wine']");
	final public static String addToCart_Buttons ="(//*[text()='Add to Cart'])";
	final public static By plp_alert_close = By.id("agegate-closeX");

	final public static By cartIcon = By.id("at_cartIcon");
	final public static By header_searchBar = By.xpath("//input[@type='text']");
	final public static String plp_listOfProductNameByXpath="(//h2[contains(@class,'title')])";
	final public static By header_button_firstPickUpHere = By.xpath("(//*[text()='Pick Up Here'])[1]");
	final public static By sort_selectButton = By.xpath("//button[@aria-label='Sort: Relevance']");
	final public static By sortBy_customerRating = By.xpath("//div[text()='Customer Ratings']");
	final public static String sortBy_index = "(//div[@role='option'])";
	final public static By header_signInButton =By.xpath("//a[@anclick='header_Sign In']");
	final public static By signInPage_email=By.xpath("//input[@type='email']");
	final public static By errorMessage_email = By.id("TextInputErrMsg982047");
	final public static By signInButton = By.xpath("//button[@type='submit']");
	final public static By signInPage_password = By.xpath("//input[@type='password']");
	final public static By disabledSignIn = By.xpath("//div[@class='AlertBlockBox__ChildrenWrapper-j3ansj-2 kEREBd'");
}
