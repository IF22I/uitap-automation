package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class MouseOverTest extends BaseTest{

    @Test (groups = {"smoke"})
    public void testMouseOver(){

        driver.get(BASE_URL + "/mouseover");

        By clickMe = By.linkText("Click me");
        By count = By.id("clickCount");

        int start = Integer.parseInt(driver.findElement(count).getText());

        driver.findElement(clickMe).click();
        driver.findElement(clickMe).click();

        int end = Integer.parseInt(driver.findElement(count).getText());

        assertTrue(end == start +2);

    }

}
