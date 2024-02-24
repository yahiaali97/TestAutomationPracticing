package TestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestClass {
    WebDriver driver;

    @BeforeTest
    public void IndicateOFStart() {
        System.out.println("Started");
    }

    @Test(priority = 2)
    public void testYouTubeSearch() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.youtube.com");
        System.out.println("The Current Title: " + driver.getTitle());
        System.out.println("The Current URL: " + driver.getCurrentUrl());

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement searchInputYoutube = driver.findElement(By.name("search_query"));
        Actions actions = new Actions(driver);
        actions.click(searchInputYoutube).sendKeys("جو شو").sendKeys(Keys.ENTER).perform();
        driver.quit();
    }

    @Test(priority = 1, enabled = true, groups = {"Go"})
    public void ToGoogle() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        String Title = driver.getTitle();
        System.out.println("The Title is:" + Title);
        Assert.assertEquals(Title, "Google");
        driver.quit();
    }

    @Test(dependsOnMethods = {"ToGoogle"}, groups = {"Go"})
    public void TestDependency() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.365scores.com/ar");
        driver.quit();
    }

    @AfterTest
    public void endSession() {
        System.out.println("End Session");
        driver.quit();
    }
}