package TestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class UploadFileRobotDemo extends TestBase {
    @Test
    public void fileUploadWithRobot() throws InterruptedException, AWTException {
        driver.get("https://the-internet.herokuapp.com/upload");

        WebElement fileUploader = driver.findElement(By.id("file-upload"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("file-upload")));

        //Note: Input fields are not clickable anymore in new selenium versions
        fileUploader.click();

        //Code using robot class for file upload
        Robot robot = new Robot();

        //CTRL + C "Copy Image Path"
        String filePath = "src/test/resources/FileInput.png";
        StringSelection selection = new StringSelection(filePath);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, null);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(500);

        //CTRL + V "Paste Image Path"
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);


        driver.findElement(By.id("file-submit")).click();
        WebElement fileName = driver.findElement(By.id("uploaded-files"));
        assertEquals("FileInput.png", fileName.getText());
        System.out.println("Uploaded Successfully");
        Thread.sleep(500);

    }
}
