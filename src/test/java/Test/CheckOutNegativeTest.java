package Test;


import TestData.ProductData;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.ProductAdd;
import utilities.HelperMethod;

public class CheckOutNegativeTest extends BaseTest {

    @Test
    public void emptyUserDetails(){
        HelperMethod.loginCredentials();
        ProductAdd pd = new ProductAdd();
        CheckoutPage chk = new CheckoutPage();
        Assert.assertTrue(pd.selectMultipleProducts(ProductData.getProductData()));
        Assert.assertEquals(pd.verifyCheckoutCount(),ProductData.getProductData().size());

        Assert.assertEquals(chk.VerifyCheckoutPage(),"https://www.saucedemo.com/cart.html");
        Assert.assertEquals(chk.verifyTheItems(), ProductData.getProductData());
        chk.clickOnCheckoutButton();
        chk.checkDetails("", "","");
        String errorText = chk.getCheckoutOverviewError();
        Assert.assertTrue(errorText.contains("First Name is required"));


    }

}

