package TestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class ExplicitWaitDemo extends TestBase {
    @Test
    public void testExplicitWait() {
        driver.get("https://www.filgoal.com/?top=true");
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement logo = driver.findElement(By.id("logo"));
        wait.until(d -> logo.isDisplayed());
        assertEquals("a", logo.getTagName());
    }
}
