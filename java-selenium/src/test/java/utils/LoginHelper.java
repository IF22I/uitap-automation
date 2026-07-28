package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginHelper {

    public static void loginAs(WebDriver driver, String username, String password){

        driver.get("http://uitestingplayground.com/sampleapp");
        driver.findElement(By.cssSelector("[name='UserName']")).sendKeys(username);
        driver.findElement(By.cssSelector("[name='Password']")).sendKeys(password);
        driver.findElement(By.id("login")).click();

    }

}
