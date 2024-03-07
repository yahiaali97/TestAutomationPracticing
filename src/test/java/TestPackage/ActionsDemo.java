package TestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActionsDemo extends beforeAndAfterBase {
    @Test
    public void Start() {

        driver.get("https://demo.nopcommerce.com");
        System.out.println("The Current Title: " + driver.getTitle());
        System.out.println("The Current URL: " + driver.getCurrentUrl());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement SearchField = driver.findElement(By.id("small-searchterms"));

        new Actions(driver).
                click(SearchField).
                sendKeys("Build your own computer").
                sendKeys(Keys.ENTER).
                perform();
    }
}