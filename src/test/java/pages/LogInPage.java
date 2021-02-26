package pages;

import testData.Locators;
import testData.TestingData;
import utilities.SetUpPage;

public class LogInPage extends SetUpPage {

	public void clickSginInButtonFromHeader() {
		lib.clickElement(Locators.Header_signInButton);
	}

	public void fillEmailAddress(String email) {
		lib.fillTextBox(Locators.LogIn_emailFeild, email);
	}

	public void fillPassdWord(String password) {
		lib.fillTextBox(Locators.LogIn_passwordFeild, password);
	}

	public void clickSginInButton() {
		lib.clickElement(Locators.SingInButton);

	}
	public String getErrorMessage_email() {
		String test = lib.getText(Locators.ErrorMessage_email);
		return test;
	}
	public String  getErrorMessage_password() {
		String test = lib.getText(Locators.ErroMessage_password);
		return test;
	}

}
