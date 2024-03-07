package TestPackage;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;


public class HandleMultipleWindowsDemo extends BeforeAndAfterBase {

    @Test(enabled = false)
    public void testWindowUsingTitle() {
        // Store WindowHandle of parent window
        String currentWindowID = driver.getWindowHandle();
        driver.findElement(By.id("visitbutton")).click();
        for (String windowID : driver.getWindowHandles()) {
            String title = driver.switchTo().window(windowID).getTitle();
            if (title.equals("Visit Us")) {
                assertEquals("Visit Us", driver.getTitle());
                // write any code to handle elements in visit us page
                System.out.println(driver.getTitle());
                driver.close();
                break;
            }
        }
        driver.switchTo().window(currentWindowID);
    }

    @Test(enabled = true)
    public void testWindowUsingName() throws InterruptedException {
        driver.navigate().to("http://cookbook.seleniumacademy.com/Config.html");
        // Store WindowHandle of parent window
        String currentWindowID = driver.getWindowHandle();
        Thread.sleep(1000);

        driver.findElement(By.id("helpbutton")).click();
        Thread.sleep(1000);

        driver.switchTo().window("HelpWindow");
        assertEquals("Help", driver.getTitle());
        System.out.println(driver.getTitle());
        Thread.sleep(1000);

        // code inside Help windows
        driver.close();
        driver.switchTo().window(currentWindowID);
    }
}