package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ClientSideDelayTest extends BaseTest{

    @Test
    public void testClientSideDelay() {

        driver.get(BASE_URL + "/clientdelay");
        driver.findElement(By.id("ajaxButton")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#content p")));
        driver.findElement(By.cssSelector("#content p")).click();

    }

}
