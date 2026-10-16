package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class ProgressBarTest extends BaseTest {

    private static final int TARGET = 75;
    private static final int TOLERANCE = 3;

    @Test(groups = {"regression"})
    public void testProgressBar() {
        driver.get(BASE_URL + "/progressbar");
        driver.findElement(By.id("startButton")).click();

        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(60));
        ((JavascriptExecutor) driver).executeAsyncScript(
                "const target = arguments[0];" +
                        "const done = arguments[arguments.length - 1];" +
                        "const bar = document.getElementById('progressBar');" +
                        "const stop = document.getElementById('stopButton');" +
                        "(function check() {" +
                        "  if (Number(bar.getAttribute('aria-valuenow')) >= target) { stop.click(); done(); }" +
                        "  else { requestAnimationFrame(check); }" +
                        "})();",
                TARGET);

        // The bar's speed is random per page load (observed: 75% reached in 1.4 s to 25 s).
        // Polling from Java plus a WebDriver click adds a round trip of about 100 ms, which overshot on fast bars.
        // So detection and the Stop click run inside the browser on each animation frame.
        // Trade-off: the JS click skips Selenium's actionability checks; acceptable because Stop is always visible here.

        int finalValue = Integer.parseInt(driver.findElement(By.id("progressBar")).getDomAttribute("aria-valuenow"));
        int difference = Math.abs(finalValue - TARGET);
        assertTrue(difference <= TOLERANCE, "Stopped at " + finalValue + "%, " + difference + "% away from target " + TARGET + "%");
    }

}
