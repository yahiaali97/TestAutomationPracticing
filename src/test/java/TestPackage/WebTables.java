package TestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.List;

public class WebTables extends beforeMethod {

    @Test
    public void testWebTable() {
        driver.get("https://the-internet.herokuapp.com/tables");
        WebElement WebTable = driver.findElement(By.id("table1"));
        List<WebElement> rows = driver.findElements(By.tagName("tr"));
        Assert.assertEquals(10, rows.size());

        for (WebElement row : rows) {
            List<WebElement> cols = row.findElements(By.tagName("td"));
            for (WebElement col : cols) {
                System.out.println(col.getText());
            }
        }
    }

    @AfterTest
    public void tearDown() {

        driver.quit();
    }
}
