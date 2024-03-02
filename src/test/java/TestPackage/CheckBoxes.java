package TestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckBoxes {
    WebDriver driver;

    @BeforeTest
    public void StartSession() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void Start() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement CheckBox1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
        Thread.sleep(2000);
        CheckBox1.click();
        WebElement CheckBox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
        if(CheckBox2.isSelected()) {
            CheckBox2.click();
            CheckBox2.isDisplayed();
            CheckBox2.isEnabled();
            CheckBox2.isSelected();
        }
        Thread.sleep(1000);

        try {
            Assert.assertTrue(CheckBox1.isSelected(), "Checkbox 1 Checked Successfully");
            System.out.println("Checkbox 1 Checked Successfully");
        } catch (AssertionError e) {
            System.out.println("Checkbox 1 not checked: " + e.getMessage());
        }
    }

    @AfterTest
    public void tearDown() {

        driver.quit();
    }
}
