package TestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class HandleMultipleWindows extends beforeAndAfterBase {
    @Test
    public void doubleClickTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");



        String originalWindow = driver.getWindowHandle();
        WebElement newWindowBtn = driver.findElement(By.xpath("//a[@href=\"/windows/new\"]"));
        newWindowBtn.click();

        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        Thread.sleep(1000);
    }
}