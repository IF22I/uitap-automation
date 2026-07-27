package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleAppTest extends  BaseTest{

    @Test
    public void testSampleApp(){

        driver.get(BASE_URL + "/sampleapp");

        WebElement username = driver.findElement(By.cssSelector("[name='UserName']"));
        username.sendKeys("test_user");

        WebElement password = driver.findElement(By.cssSelector("[name='Password']"));
        password.sendKeys("pwd");

        WebElement button = driver.findElement(By.id("login"));
        button.click();

        WebElement result = driver.findElement(By.id("loginstatus"));
        String actualText =  result.getText();
        Assert.assertEquals(actualText, "Welcome, test_user!");

    }

}
