package com.orangehrm.genericPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
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
        WebElement errorElement = findElement(xpathKey);
        if (errorElement != null && errorElement.isDisplayed()) {
            System.out.println("Error Message: " + errorElement.getText());
        } else {
            System.out.println("No error message found.");
        }
    }

    // Helper method to find an element and wait until it is visible
    private WebElement findElement(String xpathKey) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10); // Wait up to 10 seconds for visibility
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty(xpathKey))));
            return element;
        } catch (NoSuchElementException e) {
            System.out.println("Element not found with xpath: " + xpathKey);
            return null;
        }
    }
}
