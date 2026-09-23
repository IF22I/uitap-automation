package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertsTest extends BaseTest{

    @Test(groups = {"regression"})
    public void testAlerts() {

        driver.get(BASE_URL + "/alerts");

        driver.findElement(By.id("alertButton")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        driver.findElement(By.id("confirmButton")).click();
        Alert confirm = driver.switchTo().alert();
        confirm.accept();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert followUpAlertAfterConfirm = driver.switchTo().alert();
        followUpAlertAfterConfirm.accept();

        driver.findElement(By.id("promptButton")).click();
        Alert prompt = driver.switchTo().alert();
        prompt.sendKeys("my answer");
        prompt.accept();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert followUpAlertAfterPrompt = driver.switchTo().alert();
        String promptMessage = followUpAlertAfterPrompt.getText();
        followUpAlertAfterPrompt.accept();

        Assert.assertTrue(promptMessage.contains("my answer"),  "Expected the follow-up alert to contain the entered prompt value");

    }

}
