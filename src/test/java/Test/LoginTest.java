package Test;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigReader;

public class LoginTest extends BaseTest {

//    @Test
    public void validationCredentials(){
        LoginPage lp = new LoginPage();
        lp.credentials(ConfigReader.get("username"),ConfigReader.get("password"));
        Assert.assertEquals(lp.getPageUrl(),"https://www.saucedemo.com/inventory.html");
    }
}
