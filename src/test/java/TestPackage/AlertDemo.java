package TestPackage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AlertDemo {
    WebDriver driver;

    @BeforeTest
    public void StartSession() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void HandleAlert() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement alertBtn = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        alertBtn.click();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        Thread.sleep(2000);
        alert.accept();
        System.out.println("Alert Text: " + alertText);
    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
