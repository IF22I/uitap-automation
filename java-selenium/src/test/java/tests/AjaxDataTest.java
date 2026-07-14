package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class AjaxDataTest extends BaseTest{

    @Test
    public void testAjaxData() {

        driver.get(BASE_URL + "/ajax");
        driver.findElement(By.id("ajaxButton")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#content p")));
        driver.findElement(By.cssSelector("#content p")).click();

    }

}
