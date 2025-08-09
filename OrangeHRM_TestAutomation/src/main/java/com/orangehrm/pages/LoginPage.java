package com.orangehrm.pages;

import com.orangehrm.genericPage.CommonMethods;

public class LoginPage extends CommonMethods {

    public LoginPage() throws Exception {
		super();
	}

	// Click UserName Textbox
    public void clickUsername() {
        click("UserName");  // Locator for UserName should be defined in CommonMethods
    }

    // Enter valid UserName
    public void enterUserName() {
        enterData("UserName", "ValidUserName");  // Passing the valid username
    }

    // Enter Invalid UserName
    public void enterInvalidUserName() {
        enterData("UserName", "InvalidUserName");  // Enter invalid username
    }

    // Click Password Textbox
    public void clickPassword() {
        click("Password");  // Locator for Password should be defined in CommonMethods
    }

    // Enter valid Password
    public void enterPassword() {
        enterData("Password", "ValidPassword");  // Passing the valid password
    }
    
    // Enter Invalid Password
    public void enterInvalidPassword() {
        enterData("Password", "InvalidPassword");  // Enter invalid password
    }

    // Click Login Button
    public void clickLoginButton() {
        click("LoginButton");  // Locator for LoginButton should be defined in CommonMethods
    }

    // Check for error message after invalid login attempt
    public void checkErrorMessage() {
        errorMessage("InvalidUser", "ErrorMessage");  //locators.proprties,testdata.proprties
    }
}
