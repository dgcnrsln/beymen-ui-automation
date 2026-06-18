package com.beymen.automation.base;

import com.beymen.automation.driver.DriverFactory;
import com.beymen.automation.driver.DriverManager;
import com.beymen.automation.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        String browser = ConfigReader.getProperty("browser");
        WebDriver driver = DriverFactory.createInstance(browser);
        DriverManager.setDriver(driver);
        DriverManager.getDriver().get(ConfigReader.getProperty("baseUrl"));
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
