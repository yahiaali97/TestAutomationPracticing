package TestPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class beforeMethod {
    WebDriver driver;
    @BeforeTest
    public void BeforeBase() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
}