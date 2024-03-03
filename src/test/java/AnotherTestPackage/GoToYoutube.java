package AnotherTestPackage;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class GoToYoutube {
    WebDriver driver;
    @BeforeTest
    public void StartSession() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void GoYoutube() {
        driver.get("https://www.youtube.com");
        WebElement Search = driver.findElement(By.name("search_query"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        new Actions(driver).
                click(Search).
                sendKeys("Mo Salah").
                sendKeys(Keys.ENTER).
                perform();
    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
