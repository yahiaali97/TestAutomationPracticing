package TestPackage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class AlertDemo extends beforeMethod {

    @Test(enabled = false)
    public void HandleAlert() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement alertBtn = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        alertBtn.click();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        Assert.assertEquals("I am a JS Alert", alertText);
        Thread.sleep(2000);
        alert.accept();
    }

    @Test(enabled = false)
    public void HandlePromptAlert() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement alertBtn = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        alertBtn.click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(500);
        alert.sendKeys("My name is Yahya");
        alert.accept();
    }

    @Test
    public void HandleConfirmAlert() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement alertBtn = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        alertBtn.click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(500);
        alert.dismiss();
    }

    @AfterTest(enabled = true)
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
