package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoadDelayTest extends BaseTest {

    @Test (groups = {"smoke", "regression"})
    public void testLoadDelay() {

        driver.get(BASE_URL + "/loaddelay");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement button = wait
                .withMessage("Load Delay button never became clickable")
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn-primary")));
        button.click();

    }

}
