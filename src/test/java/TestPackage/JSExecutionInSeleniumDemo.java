package TestPackage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class JSExecutionInSeleniumDemo extends TestBase {
    @Test
    public void executeJSCode() {
        driver.get("https://www.google.com");
        JavascriptExecutor js = null;
        try {
            js = (JavascriptExecutor) driver;
            // Get Title By JS (Cast)
            String title = (String) js.executeScript("return document.title");
            assertEquals("Google", title);
            System.out.println(title);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }

        long links = (long) js.executeScript("var links = document.getElementsByTagName('a'); return links.length;");
        System.out.println(links);
        assertEquals(17, links);
    }
}