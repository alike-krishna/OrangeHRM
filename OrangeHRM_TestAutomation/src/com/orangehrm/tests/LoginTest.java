package com.orangehrm.tests;

import org.testng.annotations.Test;

import com.orangehrm.genericPage.MasterPage;
import com.orangehrm.pages.LoginPage;

public class LoginTest extends MasterPage {

    // No constructor needed unless you want additional custom initialization

    public LoginTest() throws Exception {
		//super();
	}

	@Test(groups = "loginRequired")
    public void validLoginTest() throws Exception {
        LoginPage lp = new LoginPage();  // Pass WebDriver instance
        lp.clickUsername();
        lp.enterUserName();
        lp.clickPassword();
        lp.enterPassword();
        lp.clickLoginButton();
    }

    @Test(priority = 2, description = "TC2: Verify user could not login with Invalid credentials", enabled = false)
    public void invalidLoginTest() throws Exception {
        LoginPage lp = new LoginPage();  // Pass WebDriver instance
        lp.clickUsername();
        lp.enterInvalidUserName();
        lp.clickPassword();
        lp.enterInvalidPassword();
        lp.clickLoginButton();
        lp.checkErrorMessage();  // Check for error message
    }
}
