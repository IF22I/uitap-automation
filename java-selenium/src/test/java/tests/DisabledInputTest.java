package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DisabledInputTest extends BaseTest{

    @Test(groups = {"regression"})
    public void testDisabledInputTest() {
        driver.get(BASE_URL + "/disabledinput");

        WebElement button = driver.findElement(By.id("enableButton"));
        button.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(By.id("inputField")));
        input.sendKeys("second_text_input");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].blur();", input);

        WebElement bottom_output = driver.findElement(By.id("opstatus"));
        String text = bottom_output.getText();
        Assert.assertEquals(text, "Value changed to: second_text_input");

    }
}
