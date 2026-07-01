package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyTextTest extends BaseTest {

    @Test
    public void testVerifyText() {
        driver.get(BASE_URL + "/verifytext");

        WebElement element = driver.findElement(By.cssSelector(".bg-primary .badge-secondary"));

        String actualText = element.getText();
        Assert.assertEquals(actualText, "Welcome UserName!");

    }

}
