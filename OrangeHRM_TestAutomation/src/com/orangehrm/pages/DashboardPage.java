package com.orangehrm.pages;

import com.orangehrm.genericPage.CommonMethods;

public class DashboardPage extends CommonMethods {

	public DashboardPage() throws Exception {
		//super();
	}

	// Click menu list
	public void clickMenuList() {
		click("MenuList");
	}

	// Click Logout Text from menu list
	public void clickLogout() {
		click("LogoutButton");
	}
}
