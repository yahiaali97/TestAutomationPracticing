package TestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ScrollDemo extends beforeAndAfterBase{
    @Test
    public void testScrollDown() throws InterruptedException {
        driver.get("https://demo.nopcommerce.com");
        Thread.sleep(500);
        JavascriptExecutor js =  (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,1000)");
        Thread.sleep(500);
        WebElement partialLinkText = driver.findElement(By.partialLinkText("MacBook Pro"));
        assertEquals("Apple MacBook Pro 13-inch", partialLinkText.getText());
        System.out.println(partialLinkText.getText());
    }
}
