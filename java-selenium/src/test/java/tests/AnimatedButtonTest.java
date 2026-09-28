package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AnimatedButtonTest extends BaseTest{
	@Test (groups = {"smoke"})
	public void testAnimatedButton(){

        driver.get(BASE_URL + "/animation");

        WebElement button = driver.findElement(By.id("animationButton"));
        button.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.not(
                ExpectedConditions.attributeContains(By.id("movingTarget"), "class", "spin")));

        WebElement movingButton = driver.findElement(By.id("movingTarget"));
        movingButton.click();

        Assert.assertEquals(driver.findElement(By.id("opstatus")).getText(),
                "Moving Target clicked. It's class name is 'btn btn-primary'");

    }
}
