package TestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class HTML5CanvasDrawingDemo extends TestBase {
    @Test
    public void testCanvasDrawing() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/draw-in-canvas.html");
        Actions actions = new Actions(driver);
        WebElement canvasElement = driver.findElement(By.id("my-canvas"));
        actions.moveToElement(canvasElement).clickAndHold();

        int numPoints = 10;
        int radius = 30;
        for (int i = 0; i <= numPoints; i++) {
            double angle = Math.toRadians((double) (360 * 1) / numPoints);
            double x = Math.sin(angle) * radius;
            double y = Math.cos(angle) * radius;

            actions.moveByOffset((int) x, (int) y);
        }
        actions.release(canvasElement).build().perform();
    }
}