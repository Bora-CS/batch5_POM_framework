package pages;

import testData.Locators;
import utilities.SetupPage;


public class SignInPage extends SetupPage{
	
	
	public void signIn_fillEmail (String email){
		lib.fillTextBox(Locators.signInPage_email, email);
	}
	public String errorMessage_Email (){
		return lib.getText(Locators.errorMessage_email);
	}
	public void clickLoginButton (){
		lib.clickElement(Locators.signInButton);
		lib.waitTime(2);
	}
	public void signIn_fillPassword(String password) {
		lib.fillTextBox(Locators.signInPage_password, password);
		lib.waitTime(2);
	}
	public String errorMessage_signInFail() {
		return lib.getText(Locators.disabledSignIn);
	}
}
