package TestPackage;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class TakingScreenshots extends beforeAndAfterBase {

    @Test
    public void takeScr() throws IOException, InterruptedException {
        driver.get("https://www.google.com");
        Thread.sleep(3000);
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String destinationPath = "SeleniumScreens\\screenshot.png";
        FileUtils.copyFile(screenshotFile, new File(destinationPath));
    }
}