import utilities.Waits;

public class LoginPage extends Waits {

    By username = By.xpath("//input[@placeholder='Username']");
    By password = By.xpath("//input[@placeholder='Password']");
    By loginButton = By.xpath("//input[@name='login-button']");

        public  void credentials(String enterUsername , String enterPassword){
            waitForElementClickable(username).sendKeys(enterUsername);
            waitForElementClickable(password).sendKeys(enterPassword);
            waitForElementClickable(loginButton).click();

        }
        public String getPageUrl(){
            return   DriverFactory.getDriver().getCurrentUrl();
        }


    }