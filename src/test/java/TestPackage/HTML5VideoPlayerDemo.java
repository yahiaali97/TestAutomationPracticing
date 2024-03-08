package TestPackage;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class HTML5VideoPlayerDemo extends TestBase {
    @Test
    public void testHTML5VideoPlayer() throws InterruptedException, IOException {
        driver.get("https://cookbook.seleniumacademy.com/html5video.html");
        WebElement videoPlayer = driver.findElement(By.id("vplayer"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String source = (String) js.executeScript("return arguments [0].currentSrc", videoPlayer);
        long duration = (long) js.executeScript("return arguments [0].duration", videoPlayer);

        Assert.assertEquals("http://html5demos.com/assets/dizzy.mp4", source);
        Assert.assertEquals(25, duration);

        js.executeScript("arguments[0].muted = true", videoPlayer);
        js.executeScript("arguments[0].play()", videoPlayer);

        Thread.sleep(3000);

        js.executeScript("arguments[0].pause()", videoPlayer);

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./Screenshots/pause_play.png"));
    }
}