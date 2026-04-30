package Test;

import TestData.ProductData;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductAdd;
import utilities.HelperMethod;

import java.util.HashSet;
import java.util.Set;

public class ProductAddToCartTest extends BaseTest {

    @Test
    public void addSingleItemToCart(){
        HelperMethod.loginCredentials();
        ProductAdd pd = new ProductAdd();
        Assert.assertTrue(pd.selectSingleProduct("Sauce Labs Fleece Jacket"),"Product are not added in cart");

    }
    @Test
    public void addMultipleItemToCart(){
        HelperMethod.loginCredentials();
        ProductAdd pd = new ProductAdd();
        Assert.assertTrue(pd.selectMultipleProducts(ProductData.getProductData()));
        Assert.assertEquals(pd.verifyCheckoutCount(),ProductData.getProductData().size());
    }
}
