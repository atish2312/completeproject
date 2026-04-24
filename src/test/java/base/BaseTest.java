package base;

import driver.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.ConfigReader;

import java.time.Duration;

public class BaseTest  {

    @BeforeMethod
    public void setupBrowser(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        DriverFactory.setDriver(driver);
        WebDriverWait wait= new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(20));
        DriverFactory.getDriver().get(ConfigReader.get("url"));
    }

    @AfterMethod
    public void tearDown(){
        DriverFactory.getDriver().quit();
    }
}
