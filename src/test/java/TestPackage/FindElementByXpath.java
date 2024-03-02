package TestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class FindElementByXpath extends beforeMethod{
    @Test
    public void XpathSelector() {
        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().window().fullscreen();
        WebElement Button = driver.findElement(By.xpath("//button[@class='radius']"));
        System.out.println(Button.getText());
        Button.click();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
