package TestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragAndDrop extends beforeAndAfterBase {
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
}
