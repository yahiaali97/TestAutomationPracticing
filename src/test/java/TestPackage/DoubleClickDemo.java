package TestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class DoubleClickDemo extends TestBase {
    @Test(enabled = true)
    public void DoubleClickTest() throws InterruptedException {
        driver.get("https://cookbook.seleniumacademy.com/DoubleClickDemo.html");
        WebElement message = driver.findElement(By.id("message"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Actions builder = new Actions(driver);
        builder.doubleClick(message).perform();
        Thread.sleep(3000);
    }
}
