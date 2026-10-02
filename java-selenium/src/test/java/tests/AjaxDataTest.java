package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AjaxDataTest extends BaseTest {

    @Test (groups = {"smoke"})
    public void testAjaxData() {

        driver.get(BASE_URL + "/ajax");
        driver.findElement(By.id("ajaxButton")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#content p")));

        Assert.assertEquals(message.getText(), "Data loaded with AJAX get request.");

    }

}
