package TestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DropdownListDemo extends TestBase {
    @Test
    public void Dropdown() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement selectElement = driver.findElement(By.id("dropdown"));
        Select Options = new Select(selectElement);
        Options.getOptions().size();
        Options.selectByIndex(2);
        Assert.assertFalse(Options.isMultiple());
        Options.selectByVisibleText("Option 1");
        assertEquals("Option 1", Options.getFirstSelectedOption().getText());
    }
}
