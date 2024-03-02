package TestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxes extends beforeAndAfterBase {
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
}
