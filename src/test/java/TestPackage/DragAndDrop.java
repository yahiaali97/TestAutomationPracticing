package TestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragAndDrop {
    WebDriver driver;

    @BeforeTest
    public void StartSession() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void DragDrop() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        WebElement source = driver.findElement(By.id("column-a"));
        boolean assertShapeA = source.isDisplayed();
        System.out.println(assertShapeA);

        WebElement target = driver.findElement(By.id("column-b"));
        boolean assertShapeB = target.isDisplayed();
        System.out.println(assertShapeB);
        Thread.sleep(1000);

        new Actions(driver).
                dragAndDrop(source, target).
                perform();
    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(500);
        driver.quit();
    }
}
