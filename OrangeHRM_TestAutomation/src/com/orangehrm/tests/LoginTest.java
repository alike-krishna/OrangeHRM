package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.genericPage.MasterPage;
import com.orangehrm.pages.LoginPage;

public class LoginTest extends MasterPage {

    // No constructor needed unless you want additional custom initialization

    public LoginTest() throws Exception {
		//super();
	}

	@Test(priority = 1, groups = "loginRequired")
    public void validLoginTest() throws Exception {
        LoginPage lp = new LoginPage();  // Pass WebDriver instance
        lp.clickUsername();
        lp.enterUserName();
        lp.clickPassword();
        lp.enterPassword();
        lp.clickLoginButton();
        String pageTitle = driver.getTitle();
        Assert.assertEquals("OrangeHRM", pageTitle);      
    }

  
    public void invalidLoginTest() throws Exception {
        LoginPage lp = new LoginPage();  
        lp.clickUsername();
        lp.enterInvalidUserName();
        lp.clickPassword();
        lp.enterInvalidPassword();
        lp.clickLoginButton();
        //lp.checkErrorMessage();  
    }
}
