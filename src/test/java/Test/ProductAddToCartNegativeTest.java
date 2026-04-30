package Test;

import TestData.ProductData;
import base.BaseTest;
import driver.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductAdd;
import utilities.ConfigReader;
import utilities.HelperMethod;

public class ProductAddToCartNegativeTest extends BaseTest {

    @Test
    public void addProductWithoutLogin(){

        DriverFactory.getDriver().get("https://www.saucedemo.com/");
        DriverFactory.getDriver().get("https://www.saucedemo.com/inventory.html");
        ProductAdd pd = new ProductAdd();
        String currentUrl = DriverFactory.getDriver().getCurrentUrl();
        Assert.assertEquals(currentUrl,pd.productAddWithoutLogin());
    }
    @Test
    public void cartEmptyAfterLogin(){
        HelperMethod.loginCredentials();
        ProductAdd pd = new ProductAdd();
        pd.selectMultipleProducts(ProductData.getProductData());
        pd.setLogoutButton();
        HelperMethod.loginCredentials();
        int count = pd.getCountCart();
        Assert.assertEquals(count,0);
    }

}

