package TestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class TestClassAssertions {
    private WebDriver driver;

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void ToautomationexerciseSite() {
        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://automationexercise.com/test_cases");
            String title = driver.getTitle();
            System.out.println("The Title is: " + title);
            assertEquals(title, "Automation Practice Website for UI Testing - Test Cases", "Title mismatch");
            List<WebElement> Header = driver.findElements(By.tagName("li"));
            assertEquals(290,Header.size());
        } catch (Exception e) {
            // Handle exceptions, print details, and rethrow if necessary
            Assert.fail("Test failed: " + e.getMessage());

        } finally {
            tearDown(); // Ensure WebDriver is closed even if an exception occurs
        }
    }
}