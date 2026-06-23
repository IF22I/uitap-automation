package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TextInputTest extends BaseTest {

    @Test
    public void testTextInput(){

        driver.get(BASE_URL + "/textinput");

        WebElement field = driver.findElement(By.id("newButtonName"));
        field.clear();
        field.sendKeys("TextInputText");

        WebElement button = driver.findElement(By.id("updatingButton"));
        button.click();

        String actualText =  button.getText();
        Assert.assertEquals(actualText, "TextInputText");
    }

}
