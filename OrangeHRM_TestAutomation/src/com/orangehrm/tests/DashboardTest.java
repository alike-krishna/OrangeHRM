package com.orangehrm.tests;

import org.testng.annotations.Test;

import com.orangehrm.genericPage.MasterPage;
import com.orangehrm.pages.DashboardPage;

public class DashboardTest extends MasterPage {

	public DashboardTest() throws Exception {
		super();
	}

	@Test(dependsOnGroups = "loginRequired")
    public void logoutTest() throws Exception {
        DashboardPage dp = new DashboardPage();  // DashboardPage should inherit WebDriver from MasterPage
        dp.clickMenuList();   // Assuming this method clicks the correct menu in the dashboard
        dp.clickLogout();     // Assuming this method handles the logout process
    }
}