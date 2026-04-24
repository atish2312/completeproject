package pages;

import driver.DriverFactory;
import org.openqa.selenium.By;
import utilities.Waits;

public class LoginPage extends Waits {

    By username = By.xpath("//input[@placeholder='Username']");
    By password = By.xpath("//input[@placeholder='Password']");

    public void credentials(String enterUsername , String enterPassword){
            waitForElementClickable(username).sendKeys(enterUsername);
            waitForElementClickable(password).sendKeys(enterPassword);
    }
}
