package TestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.assertEquals;

public class UploadFilesDemo extends TestBase {
    @Test
    public void fileUploadTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");
        File uploadFile = new File("src/test/resources/FileInput.png");

        WebElement fileInput = driver.findElement(By.id("file-upload"));
        fileInput.sendKeys(uploadFile.getAbsolutePath());
        driver.findElement(By.id("file-submit")).click();

        WebElement fileName = driver.findElement(By.id("uploaded-files"));
        assertEquals("FileInput.png", fileName.getText());
        System.out.println("Uploaded Successfully");
        Thread.sleep(500);
    }
}