package TestPackage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AlertDemo extends BeforeAndAfterBase {

    @Test
    public void HandleAlert() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement alertBtn = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        alertBtn.click();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        assertEquals("I am a JS Alert", alertText);
        Thread.sleep(2000);
        alert.accept();
    }

    @Test
    public void HandlePromptAlert() throws InterruptedException {
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement alertBtn = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        alertBtn.click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(500);
        alert.sendKeys("My name is Yahya");
        alert.accept();
    }

    @Test
    public void HandleConfirmAlert() throws InterruptedException {
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement alertBtn = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        alertBtn.click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(500);
        alert.dismiss();
    }
}
