package TestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class DropdownList extends beforeMethod{
    @Test
    public void Dropdown() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement selectElement = driver.findElement(By.id("dropdown"));
        Select Options = new Select(selectElement);
        Options.getOptions().size();
        Options.selectByIndex(2);
        Assert.assertFalse(Options.isMultiple());
        Options.selectByVisibleText("Option 1");
        Assert.assertEquals("Option 1", Options.getFirstSelectedOption().getText());
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
