package TestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FindElementByXpathDemo extends beforeAndAfterBase {

    @Test
    public void XpathSelector() {
        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().window().fullscreen();
        WebElement Button = driver.findElement(By.xpath("//button[@class='radius']"));
        System.out.println(Button.getText());
        Button.click();
    }
}
