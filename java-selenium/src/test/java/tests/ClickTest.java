package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ClickTest extends BaseTest {

    @Test
    public void testClickButton(){
        driver.get(BASE_URL + "/click");

        WebElement button = driver.findElement(By.id("badButton"));
        button.click();

//        String buttonClass = button.getAttribute("class");
//        Assert.assertTrue(
//                buttonClass.contains("btn-success"),
//                "Expected 'btn-success' class after clicking the button, but got: " + buttonClass
//        );
    }
}