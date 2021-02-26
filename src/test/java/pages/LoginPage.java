package pages;

import testData.Locators;
import utilities.SetUpPage;

public class LoginPage extends SetUpPage{

	public void clickSignInButtonFromHeader() {
		lib.clickElement(Locators.Header_signInButton);
	}
	
	public void fillEmailAddress(String email) {
		lib.fillTextBox(Locators.Login_emailField, email);
	}
	
	public void fillPasswordField(String password) {
		lib.fillTextBox(Locators.Login_passwordField, password);
	}
	
	public String getErrorMessageForEmail() {
		return lib.getText(Locators.Login_emailErrorMessage);
	}

	public void clickSingInButton() {
		lib.clickElement(Locators.login_signInButton);
		
	}

	public String getErrorMessageForPassword() {
		return lib.getText(Locators.Login_passwordErrorMessage);
	}
	
}
