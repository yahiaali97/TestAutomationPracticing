package TestPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestNGParameters {
    WebDriver driver;
    //By loginBtn = By.id("aa");
    @BeforeTest
    public void IndicateOFStart() {
        System.out.println("Started");
        // driver.findElement(loginBtn).click();
    }
    @Test(priority = 2)
    public void testToGoogle() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
    }

    @Test(priority = 1, enabled = true, groups = {"Go"},dependsOnMethods = {"testToGoogle"})
    public void testToFilgoal() {
        driver.navigate().to("https://www.filgoal.com");
        driver.quit();
    }

    @AfterTest
    public void endSession() {
        driver.quit();
    }

}