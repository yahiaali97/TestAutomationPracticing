package TestPackage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class ContextMenuDemo extends TestBase {
    @Test
    public void testContextMenu() throws InterruptedException {
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo/accesskeys.html");

        WebElement ClickMeBtn =
                driver.findElement(By.cssSelector("span.context-menu-one.btn.btn-neutral"));
        WebElement contextMenu =
                driver.findElement
                        (By.cssSelector("li.context-menu-item.context-menu-icon.context-menu-icon-edit"));

        Actions builder = new Actions(driver);
        builder
                .contextClick(ClickMeBtn)
                .moveToElement(contextMenu)
                .click()
                .perform();

        Thread.sleep(1000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertEquals("clicked: edit", alert.getText());
        alert.dismiss();
    }
}
