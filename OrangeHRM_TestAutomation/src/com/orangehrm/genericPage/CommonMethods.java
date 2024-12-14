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
    	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
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

}
