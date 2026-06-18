package com.beymen.automation.driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

    public static WebDriver createInstance(String browser){
        WebDriver driver;

        switch (browser.toLowerCase()){
            case "chrome":
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;

            case "firefox":
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;

            case "edge":
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                break;

            default:
                throw new IllegalArgumentException("Desteklenmeyen tarayıcı türü: " + browser);
        }
        return driver;
    }

}
