package com.orangehrm.genericPage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;

public class MasterPage {

	public static WebDriver driver;
    public Properties config;
    public Properties loc;
    public Properties td;
    
    public MasterPage() throws Exception {
        // Initialize properties
    	loadProperties();
    }
    @BeforeClass
    public void loadProperties() throws Exception {
        // Load configuration properties
        FileInputStream propfip = new FileInputStream(
                System.getProperty("user.dir") + "\\src\\com\\orangehrm\\repository\\configuration.properties");
        config = new Properties();
        config.load(propfip);

        try {
            FileInputStream locfip = new FileInputStream(
                    System.getProperty("user.dir") + "\\src\\com\\orangehrm\\repository\\locators.properties");
            loc = new Properties();
            loc.load(locfip);
        } catch (FileNotFoundException e) {
            System.out.println("Locator properties file not found.");
            throw e;
        } catch (IOException e) {
            System.out.println("Error loading locator properties.");
            throw e;
        }

        // Load test data properties
        FileInputStream tdfip = new FileInputStream(
                System.getProperty("user.dir") + "\\src\\com\\orangehrm\\repository\\testdata.properties");
        td = new Properties();
        td.load(tdfip);
    }

    @BeforeMethod
    public void initializeWebDriver() {
        if (driver == null) { // Only initialize if not already initialized
            if (config.getProperty("browser").equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver",
                        System.getProperty("user.dir") + "\\src\\com\\orangehrm\\drivers\\chromedriver.exe");
                driver = new ChromeDriver();
            } else if (config.getProperty("browser").equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver",
                        System.getProperty("user.dir") + "\\src\\com\\orangehrm\\drivers\\geckodriver.exe");
                driver = new FirefoxDriver();
            } else {
                throw new IllegalStateException("No driver found for specified browser in configuration.");
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
        driver.get(config.getProperty("url"));
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
