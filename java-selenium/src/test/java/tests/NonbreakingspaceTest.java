package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NonbreakingspaceTest extends BaseTest {

    @Test(groups = {"regression"})
    public void testNonbreakingspace() {

        driver.get(BASE_URL + "/nbsp");

        WebElement button = driver.findElement(By.xpath("//button[text()='My\u00A0Button']"));
        Assert.assertTrue(button.isDisplayed(), "Button located via non-breaking space XPath should be visible");

    }

}


