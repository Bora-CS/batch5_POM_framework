package testData;

import org.openqa.selenium.By;

public class Locators {
	
	
//	final public static By storeName = By.id(“globalStoreName_mobile”);
//	final public static By searchStoreTextBox=By.xpath(“//*[@aria-labelledby=‘TextInputLbl1’]“);
//	final public static By pickUpButton_Manassas = By.xpath(“//*[@anclick=‘header_store_pickup_209’]“);
//	final public static By wineDepartment = By.id(“AT_headerwine_desktop”);
//	
//	final public static By winePLPHeader = By.xpath(“//h1[text()=‘Wine’]“);
//	final public static By addToCart_Buttons = By.xpath(“//*[text()=‘Add to Cart’]“);
//	final public static By plp_alert_close = null;
//	
//	final public static By cartIcon = null;
//	
//	final public static By Header_searchTextBox = By.id(“at_searchProducts”);
//	final public static By Header_button_pickUpHere_first 
//		=By.xpath(“(//*[text()=‘Pick Up Here’])[1]“);
	
	

	

	final public static By storeName = By.xpath("//*[contains(@id,'globalStoreName')]");
	final public static By searchStoreTextBox = By.xpath("//*[@aria-labelledby='TextInputLbl1']");
	final public static By pickUpButton_Manassas = By.xpath("//*[@anclick='header_store_pickup_209']");
	final public static By wineDepartment = By.id("AT_headerwine_desktop");
	final public static By Header_searchItemsTextBox = By.id("at_searchProducts");
	final public static String PLP_listofProductName = "(//*[@class='title__2RoYeYuO titleDown__BwxDDzkX'])";
	final public static By Header_PickUpHereButtom_first = By.xpath("(//button[contains(@anclick,'header_store_pickup')])[1]");

	final public static By winePLPHeader = By.xpath("//h1[text()='Wine']");
	final public static By addToCart_Buttons = By.xpath("//*[text()='Add to Cart']");
	final public static By plp_alert_close =By.id("agegate-closeX");
	final public static By cartIcon = By.id("at_cartIcon");
	
	final public static By Header_signInButton=By.xpath("//*[contains(@class,'signInButton')]");
	final public static By ErrorMessage_email=By.xpath("(//*[@class='ErrorMsgstyled__ErrorMsg-sh40ie-0 cSBuZQ'])[1]");
	final public static By ErroMessage_password=By.xpath("(//*[@class='ErrorMsgstyled__ErrorMsg-sh40ie-0 cSBuZQ'])[2]");
	final public static By LogIn_emailFeild=By.name("emailAddress");
	final public static By LogIn_passwordFeild=By.name("password");
	final public static By SingInButton=By.xpath("//*[@type='submit']");
	
	
	final public static By sort_Button=By.xpath("//*[@aria-label='Sort: Relevance']");
	final public static By plp_SortProductName=By.id("product-130007750-1-0_Title");
}
