package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ClassAttributeTest extends BaseTest{

    @Test
    public void testAttributeClass() {

        driver.get(BASE_URL + "/classattr");
        WebElement button = driver.findElement(By.cssSelector("button.btn-primary"));
        Assert.assertTrue(button.isDisplayed());
        button.click();

    }

}
