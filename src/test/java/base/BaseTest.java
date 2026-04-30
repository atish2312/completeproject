package base;

import driver.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import utilities.ConfigReader;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static utilities.ScreenshotUtil.clearScreenshotFolder;

public class BaseTest  {

    @BeforeMethod
    public void setupBrowser(){
        clearScreenshotFolder();
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-extensions");

        options.addArguments("--guest");

        Map<String, Object> prefs = new HashMap<>();

        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

// Disable password leak detection (IMPORTANT for your popup)
        prefs.put("profile.password_manager_leak_detection", false);

        options.setExperimentalOption("prefs", prefs);
        WebDriver driver = new ChromeDriver(options);
        DriverFactory.setDriver(driver);
        WebDriverWait wait= new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(20));
        DriverFactory.getDriver().get(ConfigReader.get("url"));
    }

    @AfterMethod
    public void tearDown(){
      DriverFactory.getDriver().quit();
    }
}