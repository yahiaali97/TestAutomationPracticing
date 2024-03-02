package TestPackage;

import org.testng.annotations.Test;


public class HandleMultipleWindows extends beforeMethod {
    @Test
    public void doubleClickTest() throws InterruptedException {
        driver.get("https://cookbook.seleniumacademy.com/DoubleClickDemo.html");
    }
}