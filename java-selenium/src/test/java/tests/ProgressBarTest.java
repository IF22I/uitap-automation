package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class ProgressBarTest extends BaseTest{

    @Test
    public void testProgressBar(){

        driver.get(BASE_URL + "/progressbar");

        driver.findElement(By.id("startButton")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(d -> Integer.parseInt(d.findElement(By.id("progressBar")).getAttribute("aria-valuenow")) >= 75);

        driver.findElement(By.id("stopButton")).click();

        int finalValue = Integer.parseInt(driver.findElement(By.id("progressBar")).getAttribute("aria-valuenow"));

        int difference = Math.abs(finalValue - 75);
        assertTrue(difference <= 3, "Stopped " + difference + "% away from target");

    }

}
