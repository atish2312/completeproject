    package Test;

    import base.BaseTest;
    import org.testng.Assert;
    import org.testng.annotations.Test;
    import pages.LoginPage;
    import utilities.ConfigReader;

    public class LoginNegativeTest extends BaseTest {
        @Test
        public void invalidCredentials(){
            LoginPage lp = new LoginPage();
            lp.credentials("test","test123");
            String error = lp.getErrorMessage();
            Assert.assertTrue(error.contains("Username and password do not match any user in this service"));
        }

        @Test
        public void emptyFields(){
            LoginPage lp = new LoginPage();
            lp.credentials("","");
            String error = lp.getErrorMessage();
            Assert.assertTrue(error.contains("Username is required"));
        }
    }
