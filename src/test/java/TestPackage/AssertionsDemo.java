package TestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AssertionsDemo extends beforeAndAfterBase {

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void ToautomationexerciseSite() {
        try {
            driver.get("https://automationexercise.com/test_cases");
            String title = driver.getTitle();
            System.out.println("The Title is: " + title);
            assertEquals(title, "Automation Practice Website for UI Testing - Test Cases", "Title mismatch");
            assertTrue(title.contains("Testing"), "Title should contain 'Testing'");
            System.out.println(title.contains("Testing"));
            List<WebElement> Header = driver.findElements(By.tagName("li"));
            assertEquals(290,Header.size());
        } catch (Exception e) {
            // Handle exceptions, print details, and rethrow if necessary
            Assert.fail("Test failed: " + e.getMessage());

        }
        finally {
            tearDown(); // Ensure WebDriver is closed even if an exception occurs
        }
    }
}