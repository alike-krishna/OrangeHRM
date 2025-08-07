package com.orangehrm.tests;

import org.testng.annotations.Test;

import com.orangehrm.genericPage.MasterPage;
import com.orangehrm.pages.AdminPage;

public class AdminTest extends MasterPage{
	
	public AdminTest() throws Exception {
		//super();
	}
	@Test(dependsOnGroups = "loginRequired")
	public void dropdownSelection() throws Exception {
		AdminPage ap = new AdminPage();
		ap.AdminPageClick();
		ap.dropdownClick();
		ap.dropdownValueSelection();
		
	}
}
