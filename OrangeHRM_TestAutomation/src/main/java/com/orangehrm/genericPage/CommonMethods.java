package com.orangehrm.genericPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CommonMethods extends MasterPage {

	public CommonMethods() throws Exception {
		super();
	}

	// Click method - Waits for element to be clickable and clicks
	public void click(String xpathKey) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath(loc.getProperty(xpathKey))).click();

	}

	// Enter data method - Waits for the element and enters data
	public void enterData(String xpathKey, String testData) {
		driver.findElement(By.xpath(loc.getProperty(xpathKey))).sendKeys(td.getProperty(testData));
	}

	// Error Message - Checks for visibility of an error message and prints it
	public void errorMessage(String xpathKey, String testData) {
		driver.findElement(By.xpath(loc.getProperty(xpathKey))).sendKeys(td.getProperty(testData));

	}

	// Dropdown value selection
	public void dropdownSelection(String xpathKey) {
		List<WebElement> elements = driver.findElements(By.xpath(loc.getProperty(xpathKey)));
		if (elements.size() > 0) {
			WebElement firstOption = elements.get(0);
			firstOption.click();
		} else {
			System.out.println("No dropdown options found!");
		}

	}
}
