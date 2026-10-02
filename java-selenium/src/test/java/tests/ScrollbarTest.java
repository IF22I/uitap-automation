package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ScrollbarTest extends BaseTest {

    @Test (groups = {"regression"})
    public void testScrollbar() {

        driver.get(BASE_URL + "/scrollbars");

        WebElement button = driver.findElement(By.id("hidingButton"));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView(true);", button);
        button.click();

        Boolean inViewport = (Boolean) js.executeScript(
                "var r = arguments[0].getBoundingClientRect();"
                        + "return r.top >= 0 && r.left >= 0 && r.bottom <= window.innerHeight"
                        + " && r.right <= window.innerWidth;", button);
        Assert.assertTrue(inViewport, "The hiding button should be inside the viewport after scrolling");

    }

}
