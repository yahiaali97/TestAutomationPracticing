package TestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DropdownList {
    WebDriver driver;
    @BeforeTest
    public void StartSession() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    @Test
    public void Dropdown() {
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        dropdown.selectByIndex(2);
        Assert.assertEquals();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
