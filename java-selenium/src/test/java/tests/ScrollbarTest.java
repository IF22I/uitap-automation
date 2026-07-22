package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ScrollbarTest extends BaseTest{

    @Test
    public void testScrollbar() {

        driver.get(BASE_URL + "/scrollbars");

        WebElement button = driver.findElement(By.id("hidingButton"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);

        button.click();

    }

}
