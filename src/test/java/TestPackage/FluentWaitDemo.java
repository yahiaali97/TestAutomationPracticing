package TestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;



public class FluentWaitDemo extends beforeAndAfterBase {
    @Test
    public void testFluentWait() {
        driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
        WebElement revealed = driver.findElement(By.id("revealed"));
        driver.findElement(By.id("reveal")).click();

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(2))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class);

        wait.until(
                d -> {
                    revealed.sendKeys("Displayed");
                    return true;
                });

        Assert.assertEquals("Displayed", revealed.getDomProperty("value"));
    }
}
