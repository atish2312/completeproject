package utilities;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits extends DriverFactory {
    public WebDriverWait wait;

    public Waits(){
        wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(20));
    }

    public  WebElement waitForElementClickable(WebElement ele){
        return wait.until(ExpectedConditions.elementToBeClickable(ele));
    }

    public  WebElement waitForElementClickable(By ele){
        return wait.until(ExpectedConditions.elementToBeClickable(ele));
    }

}
