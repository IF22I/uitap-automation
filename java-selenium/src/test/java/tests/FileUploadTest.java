package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class FileUploadTest extends BaseTest{

    @Test (groups = {"smoke"})
    public void testFileUpload(){

        driver.get(BASE_URL + "/upload");

        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);

        File file = new File("src/test/resources/testdata/sample.txt");
        String absolutePath = file.getAbsolutePath();

        driver.findElement(By.id("browse")).sendKeys(absolutePath);

        WebElement info = driver.findElement(By.cssSelector(".file-list p"));
        Assert.assertTrue(info.getText().contains("sample.txt"));

    }
}
