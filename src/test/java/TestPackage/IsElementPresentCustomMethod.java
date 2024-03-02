package TestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;

public class IsElementPresentCustomMethod {
    WebDriver driver;

    @BeforeTest
    public void StartSession() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testElementPresent() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        if (isElementPresent(By.xpath("//*[@id=\"checkboxes\"]/input[1]"))) {
            WebElement CheckBox1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
            Thread.sleep(1000);
            if (!CheckBox1.isSelected()) {
                CheckBox1.click();
            } else {
                Assert.fail("Checkbox 1 doesn't exist");
            }
        }
        Thread.sleep(1000);
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;

        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @AfterTest
    public void tearDownSession() {
        driver.quit();
    }
}