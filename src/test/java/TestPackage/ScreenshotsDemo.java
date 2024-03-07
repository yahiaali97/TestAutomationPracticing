package TestPackage;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class ScreenshotsDemo extends beforeAndAfterBase {
    @Test
    public void testCase() {

        try {
            driver.get("https://www.amazon.eg");
            WebElement searchTxt = driver.findElement(By.id("twotabsearchtextbox"));
            System.out.println(driver.getTitle());
            assertTrue(driver.getTitle().contains("أمازون"));
            new Actions(driver)
                    .click(searchTxt)
                    .sendKeys("Airpods")
                    .sendKeys(Keys.ENTER)
                    .perform();
        } catch (Exception e) {
            System.err.println("Error in testCase: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }

    @AfterMethod
    public void takeScreenshotOnFailure(ITestResult result) throws IOException {

        if (result.getStatus() == ITestResult.FAILURE) {
            try {
                File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                String destinationPath = "SeleniumScreens" + File.separator + "Failure.png";
                FileUtils.copyFile(screenshotFile, new File(destinationPath));
                System.out.println("Screenshot saved: " + destinationPath);
            } catch (IOException e) {
                System.err.println("Error while taking screenshot: " + e.getMessage());
            }
        }
        driver.quit();
    }
}