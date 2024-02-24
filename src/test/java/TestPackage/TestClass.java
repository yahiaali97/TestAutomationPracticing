package TestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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

    @Test (priority = 2)
    public void testYouTubeSearch() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.youtube.com");
        System.out.println("The Current Title: "+driver.getTitle());
        System.out.println("The Current URL: "+driver.getCurrentUrl());

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement searchInputYoutube = driver.findElement(By.name("search_query"));
        Actions actions = new Actions(driver);
        actions.click(searchInputYoutube).sendKeys("جو شو").sendKeys(Keys.ENTER).perform();
    }

    @Test(priority = 1, enabled = true)
    public void ToGoogle() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.get("https://www.google.com");
        driver.get("https://www.google.com");
        driver.quit();
    }

    @Test(dependsOnMethods= {"ToGoogle"})
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