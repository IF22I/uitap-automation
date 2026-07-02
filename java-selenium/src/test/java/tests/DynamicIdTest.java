package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicIdTest extends BaseTest{

    @Test
    public void testDynamicId() {

        driver.get(BASE_URL + "/dynamicid");
        WebElement button = driver.findElement(By.xpath("//button[text()='Button with Dynamic ID"));
        Assert.assertTrue(button.isDisplayed());
        button.click();

    }

}
