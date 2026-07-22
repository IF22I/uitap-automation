package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OverlappedTest extends BaseTest{

    @Test
    public void testOverlapped() {

        driver.get(BASE_URL + "/overlapped");

        WebElement field1 = driver.findElement(By.id("id"));
        field1.sendKeys("test_id");


        WebElement field2 = driver.findElement(By.id("name"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", field2);
        field2.sendKeys("test_name");

        String actualText1 =  field1.getAttribute("value");
        Assert.assertEquals(actualText1, "test_id");

        String actualText2 =  field2.getAttribute("value");
        Assert.assertEquals(actualText2, "test_name");

    }

}
