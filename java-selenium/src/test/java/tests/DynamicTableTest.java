package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DynamicTableTest extends BaseTest{

    @Test(groups = {"smoke"})
    public void testDynamicTable() {

        driver.get(BASE_URL + "/dynamictable");

        List<WebElement> headers = driver.findElements(By.cssSelector("span[role='columnheader']"));
        int cpuIndex = -1;
        for (int i = 0; i<headers.size(); i++){
            if (headers.get(i).getText().equals("CPU")){
                cpuIndex = i;
                break;
            }
        }

        List<WebElement> rows = driver.findElements(By.cssSelector("div[role='row']"));
        String cpuValue = null;
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.cssSelector("span[role='cell']"));
            if (!cells.isEmpty() && cells.get(0).getText().equals("Chrome")) {
                cpuValue = cells.get(cpuIndex).getText();
                break;
            }
        }

        WebElement warningLabel = driver.findElement(By.cssSelector("p.bg-warning"));
        String warningText = warningLabel.getText();
        String warningTextValue = warningText.split(":")[1].trim();

        double labelValue = Double.parseDouble(warningTextValue.replace("%", ""));
        double cpuNumeric = Double.parseDouble(cpuValue.replace("%", ""));

        Assert.assertEquals(labelValue, cpuNumeric);

    }

}
