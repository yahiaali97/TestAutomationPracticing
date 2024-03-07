package TestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FramesDemo extends BeforeAndAfterBase {
    @Test
    public void testFramesByIDOrName() {
        driver.get("https://cookbook.seleniumacademy.com/Frames.html");
        driver.switchTo().frame("left");
        WebElement msg = driver.findElement(By.tagName("p"));
        assertEquals("This is Left Frame", msg.getText());
        System.out.println(msg.getText());
    }

    @Test(enabled = true)
    public void testFramesDefaultContent() {
        driver.switchTo().defaultContent();
    }

    @Test(enabled = true)
    public void testFramesByIDOrName2() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame("right");
        WebElement msg2 = driver.findElement(By.tagName("p"));
        assertEquals("This is Right Frame", msg2.getText());
        System.out.println(msg2.getText());
    }

    @Test
    public void testFramesByIndex() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        WebElement msg3 = driver.findElement(By.tagName("p"));
        assertEquals("This Frame doesn't have id or name", msg3.getText());
        System.out.println(msg3.getText());
    }
}