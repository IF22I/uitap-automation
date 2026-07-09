package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.DriverFactory;

public class BaseTest {

    protected WebDriver driver;
    protected static final String BASE_URL = "http://uitestingplayground.com";

    @BeforeMethod
    @Parameters({"browser", "headless"})
    public void setUp(@Optional("chrome") String browser, @Optional("false") String headless) {
        driver = DriverFactory.createDriver(browser, Boolean.parseBoolean(headless));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}