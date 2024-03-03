package TestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExplicitWait extends beforeAndAfterBase {
    @Test
    public void testExplicitWait() {
        driver.get("https://www.filgoal.com/?top=true");
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement logo = driver.findElement(By.id("logo"));
        wait.until(d -> logo.isDisplayed());
        Assert.assertEquals("a", logo.getTagName());
    }
}
