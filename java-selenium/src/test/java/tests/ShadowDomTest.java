package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;

public class ShadowDomTest extends BaseTest{

    @Test(groups = {"smoke"})
    public void testShadowDom() throws Exception {

        if (GraphicsEnvironment.isHeadless()) {
            throw new SkipException("System clipboard requires a desktop session; unavailable on headless runners");
        }

        driver.get(BASE_URL + "/shadowdom");

        WebElement host = driver.findElement(By.tagName("guid-generator"));
        SearchContext shadowRoot = host.getShadowRoot();

        shadowRoot.findElement(By.cssSelector("#buttonGenerate")).click();
        shadowRoot.findElement(By.cssSelector("#buttonCopy")).click();

        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        String clipboardText = (String) clipboard.getData(DataFlavor.stringFlavor);

        WebElement element = shadowRoot.findElement(By.cssSelector("#editField"));

        Assert.assertEquals(clipboardText, element.getAttribute("value"));
    }

}
