package TestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.Set;

import static org.testng.Assert.assertEquals;

public class HandleCookiesDemo extends beforeAndAfterBase {
    @Test
    public void testCookies() {
        driver.get("http://magento-demo.lexiconn.com/");
        WebElement selectElement = driver.findElement(By.id("select-language"));
        Select options = new Select(selectElement);
//        System.out.println(options.getOptions().size());
//        options.selectByIndex(2);
        assertEquals("English", options.getFirstSelectedOption().getText());

        // Store Cookies should be null
        Cookie storeCookie = driver.manage().getCookieNamed("store");
        assertEquals(null, storeCookie);

        options.selectByVisibleText("German");

        //Store Cookie
        storeCookie = driver.manage().getCookieNamed("store");
        assertEquals("german", storeCookie.getValue());
        System.out.println(storeCookie.getValue());

        // Get All available cookies
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println("Number of Cookies: " + cookies.size());
        System.out.println(cookies);
    }
}
