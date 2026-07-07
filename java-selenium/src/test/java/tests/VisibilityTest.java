package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class VisibilityTest extends BaseTest{

   @Test
   public void testVisibility(){
       driver.get(BASE_URL + "/visibility");

       driver.findElement(By.id("hideButton")).click();

       WebElement zeroWidth = driver.findElement(By.id("zeroWidthButton"));
       Assert.assertFalse(zeroWidth.isDisplayed());

       WebElement overlapped = driver.findElement(By.id("overlappedButton"));
       Assert.assertTrue(overlapped.isDisplayed());

       WebElement transparent = driver.findElement(By.id("transparentButton"));
       Assert.assertFalse(transparent.isDisplayed());

       WebElement invisible = driver.findElement(By.id("invisibleButton"));
       Assert.assertFalse(invisible.isDisplayed());

       WebElement notDisplayed = driver.findElement(By.id("notdisplayedButton"));
       Assert.assertFalse(notDisplayed.isDisplayed());

       WebElement offscreen = driver.findElement(By.id("offscreenButton"));
       Assert.assertFalse(offscreen.isDisplayed());

       Assert.assertTrue(driver.findElements(By.id("removedButton")).isEmpty());

   }

}
