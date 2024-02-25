package TestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class MatchingAllElements {
    WebDriver driver;
    @Test
    public void AllMatchedElements() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/test_cases");
        List<WebElement> Header = driver.findElements(By.tagName("li"));
        System.out.println(Header);
        driver.quit();
    }
}
