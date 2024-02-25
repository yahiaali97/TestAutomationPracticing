package TestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import java.time.Duration;

public class TestClass {
    WebDriver driver;

    @Test
    public void Start() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com");
        System.out.println("The Current Title: " + driver.getTitle());
        System.out.println("The Current URL: " + driver.getCurrentUrl());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        WebElement SearchField = driver.findElement(By.id("small-searchterms"));
        //System.out.println(SearchField.getTagName());
        Actions actions = new Actions(driver);
        actions.click(SearchField).sendKeys("apple icam").sendKeys(Keys.ENTER).perform();
        driver.quit();
    }
}