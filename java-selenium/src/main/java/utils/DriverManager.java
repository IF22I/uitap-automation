package utils;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static WebDriver driver;

    private DriverManager(){
    }

    public static WebDriver getDriver(String browser, boolean headless){
        if (driver == null) {
            driver = DriverFactory.createDriver(browser, headless );
        }
        return driver;
    }

    public static WebDriver getDriver(){
        if (driver == null) {
            throw new IllegalStateException("Driver not initialized — call getDriver(browser, headless) first.");
        }
        return driver;
    }

    public static void quitDriver(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }
}
