package TestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import java.time.Duration;

public class ATestClass {
    WebDriver driver;

    @Test
    public void testYouTubeSearch() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.youtube.com");
        System.out.println("The Current Title: " + driver.getTitle());
        System.out.println("The Current URL: " + driver.getCurrentUrl());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement searchInputYoutube = driver.findElement(By.name("search_query"));
        System.out.println(searchInputYoutube.getTagName());
        Actions actions = new Actions(driver);
        actions.click(searchInputYoutube).sendKeys("جو شو").sendKeys(Keys.ENTER).perform();
        driver.quit();
    }
}