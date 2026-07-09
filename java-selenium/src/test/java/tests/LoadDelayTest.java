package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LoadDelayTest extends BaseTest {

    @Test
    public void testLoadDelay() {

/*        driver.get(BASE_URL);

        driver.findElement(By.linkText("Load Delay")).click();
        driver.findElement(By.cssSelector(".btn-primary")).click();

    }*/

        driver.get(BASE_URL + "/loaddelay");
        driver.findElement(By.cssSelector(".btn-primary")).click();

    }

}
