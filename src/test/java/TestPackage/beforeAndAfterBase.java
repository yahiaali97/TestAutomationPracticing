package TestPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class beforeAndAfterBase {
    WebDriver driver;
    @BeforeTest
    public void beforeBase() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterTest(enabled = true)
    public void afterBase() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}