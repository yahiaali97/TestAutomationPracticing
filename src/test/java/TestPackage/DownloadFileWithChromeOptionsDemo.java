package TestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

public class DownloadFileWithChromeOptionsDemo {
    WebDriver driver;
    public static String userDir = System.getProperty("user.dir");
    public static String relativePath = "\\DownloadedFiles";
    public static String downloadPath = userDir + relativePath;

    public static ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("applicationCacheEnabled", false);
        chromeOptions.addArguments("--disable-extensions");
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadPath);
        chromeOptions.setExperimentalOption("prefs", chromePrefs);
        chromeOptions.addArguments("--headless");
        return chromeOptions;
    }

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver(getChromeOptions());
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/download");
    }

    @Test
    public void testDownloadFile() throws InterruptedException {
        WebElement selectedFile = driver.findElement(By.linkText("example.json"));
        selectedFile.click();
        System.out.println(downloadPath);
        Thread.sleep(100);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}