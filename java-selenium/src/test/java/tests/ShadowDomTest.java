package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.time.Duration;

public class ShadowDomTest extends BaseTest {

    private static final String SENTINEL = "SENTINEL";

    @Test(groups = {"smoke", "regression"})
    public void testShadowDom() {
        if (headlessBrowser || GraphicsEnvironment.isHeadless()) {
            throw new SkipException("Needs a visible browser and a desktop: headless Chrome does not write to the OS clipboard");
        }

        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(new StringSelection(SENTINEL), null);

        driver.get(BASE_URL + "/shadowdom");
        SearchContext shadowRoot = driver.findElement(By.tagName("guid-generator")).getShadowRoot();
        shadowRoot.findElement(By.cssSelector("#buttonGenerate")).click();
        shadowRoot.findElement(By.cssSelector("#buttonCopy")).click();

        String expected = shadowRoot.findElement(By.cssSelector("#editField")).getDomProperty("value");

        String clipboardText = new WebDriverWait(driver, Duration.ofSeconds(5))
                .withMessage("Clipboard still holds the sentinel: the Copy button did not write to it. Is the browser window focused?")
                .until(d -> {
                    String text = readClipboard(clipboard);
                    return SENTINEL.equals(text) ? null : text;
                });

        Assert.assertEquals(clipboardText, expected);
    }

    private static String readClipboard(Clipboard clipboard) {
        try {
            return (String) clipboard.getData(DataFlavor.stringFlavor);
        } catch (Exception e) {
            return null;
        }
    }
}