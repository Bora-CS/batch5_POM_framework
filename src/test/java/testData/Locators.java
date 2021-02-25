package testData;

import org.openqa.selenium.By;

public class Locators {

	
	final public static By storeName = By.id("globalStoreName_mobile");
	final public static By searchStoreTextBox=By.xpath("//*[@aria-labelledby='TextInputLbl1']");
	final public static By pickUpButton_Manassas = By.xpath("//*[@anclick='header_store_pickup_209']");
	final public static By wineDepartment = By.id("AT_headerwine_desktop");
	
	final public static By winePLPHeader = By.xpath("//h1[text()='Wine']");
	final public static By addToCart_Buttons = By.xpath("//*[text()='Add to Cart']");
	final public static By plp_alert_close = null;
	
	final public static By cartIcon = null;
	
	final public static By Header_searchTextBox = By.id("at_searchProducts");
	final public static By Header_button_pickUpHere_first 
		=By.xpath("(//*[text()='Pick Up Here'])[1]");
	
	final public static By Header_signInButton 
	= By.xpath("//*[contains(@class,'signInButton')]");
	
	
	final public static String PLP_listOfProductName = "(//h2[contains(@class,'title')])";
	public static final By Login_emailField = null;
	public static final By Login_passwordField = null;
	public static final By Login_emailErrorMessage = null;
}
