package TestPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {
    WebDriver driver;
    @BeforeTest
    public void BeforeBase() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterTest(enabled = true)
    public void tearDown() throws InterruptedException {
        Thread.sleep(500);
        driver.quit();
    }
}