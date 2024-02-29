package TestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;

public class Actions {
    WebDriver driver;
    @BeforeTest
    public void StartSession() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com");
    }

    @Test
    public void Start() {

        System.out.println("The Current Title: " + driver.getTitle());
        System.out.println("The Current URL: " + driver.getCurrentUrl());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        WebElement SearchField = driver.findElement(By.id("small-searchterms"));
        //System.out.println(SearchField.getTagName());
        org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(driver);
        actions.click(SearchField).sendKeys("apple icam").sendKeys(Keys.ENTER).perform();
    }

    @BeforeTest
    public void endSession() {
        driver.quit();
    }
}