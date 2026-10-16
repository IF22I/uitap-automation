package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.DriverFactory;
import config.Config;
import utils.DriverManager;

public class BaseTest {

    protected WebDriver driver;
    protected boolean headlessBrowser;
    protected static final String BASE_URL = Config.BASE_URL;

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser", "headless"})
    public void setUp(@Optional("chrome") String browser, @Optional("false") String headless) {

        String browserValue = System.getProperty("browser", browser);
        headlessBrowser = Boolean.parseBoolean(System.getProperty("headless", headless));

        driver = DriverManager.getDriver(browserValue, headlessBrowser);
        if (!headlessBrowser) {
            driver.manage().window().maximize();
        }

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            DriverManager.quitDriver();
        }
    }
}