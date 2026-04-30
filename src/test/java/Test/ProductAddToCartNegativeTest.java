package Test;

import TestData.ProductData;
import driver.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductAdd;
import utilities.ConfigReader;

public class ProductAddToCartNegativeTest {

    @Test
    public void addProductWithoutLogin(){
        ProductAdd pd = new ProductAdd();
        String currentUrl = DriverFactory.getDriver().getCurrentUrl();
        Assert.assertEquals(currentUrl,pd.productAddWithoutLogin());
    }
    @Test
    public void cartEmptyAfterLogin(){
        LoginPage lp = new LoginPage();
        lp.credentials(ConfigReader.get("username"),ConfigReader.get("password"));
        ProductAdd pd = new ProductAdd();
        pd.selectMultipleProducts(ProductData.getProductData());
        pd.setLogoutButton();
        lp.credentials(ConfigReader.get("username"),ConfigReader.get("password"));
        int count = pd.getCountCart();
        






    }

}

