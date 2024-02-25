package TestPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClassAssertions {
    private WebDriver driver;

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void ToGoogle() {
        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.google.com");
            String title = driver.getTitle();
            System.out.println("The Title is: " + title);

            Assert.assertEquals(title, "Google", "Title mismatch");

        } catch (Exception e) {
            // Handle exceptions, print details, and rethrow if necessary
            Assert.fail("Test failed: " + e.getMessage());

        } finally {
            tearDown(); // Ensure WebDriver is closed even if an exception occurs
        }
    }
}