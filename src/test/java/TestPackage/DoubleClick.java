package TestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class DoubleClick {
    WebDriver driver;
    @BeforeTest
    public void StartSession() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://cookbook.seleniumacademy.com/DoubleClickDemo.html");
    }

    @Test(enabled = true)
    public void DoubleClickTest() throws InterruptedException {
        WebElement message = driver.findElement(By.id("message"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Actions builder = new Actions(driver);
        builder.doubleClick(message).perform();
        Thread.sleep(3000);
    }

    @BeforeTest
    public void endSession() {
        driver.quit();
    }
}
