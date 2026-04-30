package utilities;

import pages.LoginPage;

public class HelperMethod {

    public static void loginCredentials(){
        LoginPage lp = new LoginPage();
        lp.credentials(ConfigReader.get("username"),ConfigReader.get("password"));

    }


}
