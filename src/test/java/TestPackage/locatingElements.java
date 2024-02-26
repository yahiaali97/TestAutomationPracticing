package TestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;

public class locatingElements {
    WebDriver driver;

    @BeforeTest
    public void StartSession() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void ListOfElements() {
        driver.get("https://the-internet.herokuapp.com/tables");
        WebElement table = driver.findElement(By.id("table1"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        System.out.println(rows.size());
        System.out.println(rows.get(1).getText());
    }
    @Test
    public void cssSelector() {
        driver.navigate().to("https://the-internet.herokuapp.com/login");
        String buttonText = driver.findElement(By.cssSelector("button.radius")).getText();
        System.out.println(buttonText);
    }
    @Test
    public void getAttributes() {
        driver.navigate().to("https://the-internet.herokuapp.com");
        List<WebElement> links = driver.findElements(By.tagName("a"));
        int LinkSize = links.size();
        System.out.println(LinkSize);
        int linkNumber = 1;
        for (WebElement link : links) {
            System.out.println("Link " + linkNumber + ":");
            System.out.println(link.getAttribute("href"));
            linkNumber++;
        }
        try {
            Assert.assertEquals(46, LinkSize);
        }
        catch (Exception e) {
            Assert.fail("Test failed: " + e.getMessage());
        }
    }
    @AfterTest
    public void endSession(){
        driver.close();
        driver.quit();
    }
}