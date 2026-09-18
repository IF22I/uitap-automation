package tests;

import org.openqa.selenium.*;
import org.testng.annotations.Test;
import org.testng.Assert;

import static org.testng.Assert.*;

public class HiddenLayersTest extends BaseTest{

    @Test(groups = {"regression"})
    public void testHiddenLayers() {

        driver.get(BASE_URL + "/hiddenlayers");

        WebElement greenButton = driver.findElement(By.id("greenButton"));

        Point location = greenButton.getLocation();
        Dimension size = greenButton.getSize();

        int x = location.getX();
        int y = location.getY();
        int width = size.getWidth();
        int height = size.getHeight();

        int centerX = x + width / 2;
        int centerY = y + height / 2;

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String topElementId = (String) js.executeScript(
                "return document.elementFromPoint(arguments[0], arguments[1]).id;", centerX, centerY
        );

        driver.findElement(By.id(topElementId)).click();

        String bottomElementId = (String) js.executeScript(
                "return document.elementFromPoint(arguments[0], arguments[1]).id;", centerX, centerY
        );

        assertNotEquals(topElementId, bottomElementId);

    }

}
