package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.DriverFactory;
import config.Config;

public class BaseTest {

    protected WebDriver driver;
    protected static final String BASE_URL = Config.BASE_URL;

    @BeforeMethod
    @Parameters({"browser", "headless"})
    public void setUp(@Optional("chrome") String browser, @Optional("false") String headless) {

        String headlessValue = System.getProperty("headless", headless);
        String browserValue = System.getProperty("browser", browser);

        driver = DriverFactory.createDriver(browserValue, Boolean.parseBoolean(headlessValue));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}