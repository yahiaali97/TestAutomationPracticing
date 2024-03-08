package TestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class WebTablesDemo extends TestBase {
    @Test
    public void testWebTable() {
        driver.get("https://the-internet.herokuapp.com/tables");
        WebElement WebTable = driver.findElement(By.id("table1"));
        List<WebElement> rows = driver.findElements(By.tagName("tr"));
        assertEquals(10, rows.size());

        for (WebElement row : rows) {
            List<WebElement> cols = row.findElements(By.tagName("td"));
            for (WebElement col : cols) {
                System.out.println(col.getText());
            }
        }
    }
}
