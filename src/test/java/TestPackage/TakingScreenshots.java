package TestPackage;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class TakingScreenshots {
    WebDriver driver;

    @BeforeTest
    public void startSession() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void takeScr() throws IOException, InterruptedException {
        driver.get("https://www.google.com");
        Thread.sleep(3000);
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String destinationPath = "SeleniumScreens\\screenshot.png";
        FileUtils.copyFile(screenshotFile, new File(destinationPath));
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}