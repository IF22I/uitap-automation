package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.LoginHelper;

public class SampleAppTest extends  BaseTest{

    @Test
    public void testSampleApp(){

        LoginHelper.loginAs(driver, "test_user", "pwd");

        String actualText = driver.findElement(By.id("loginstatus")).getText();
        Assert.assertEquals(actualText, "Welcome, test_user!");
    }
}
