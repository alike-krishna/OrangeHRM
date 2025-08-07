package com.orangehrm.pages;

import java.util.Arrays;
import java.util.List;

import com.orangehrm.genericPage.CommonMethods;

public class AdminPage extends CommonMethods {

	public AdminPage() throws Exception {
		// super();
	}

	public void AdminPageClick() {
		click("AdminMenu");
	}

	public void dropdownClick() {
		click("UserRole");
	}

	public void dropdownValueSelection() {
		dropdownSelection("UserRole");
	}
}
