package Test;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductAdd;

import java.util.HashSet;
import java.util.Set;

public class ProductAddToCartTest extends BaseTest {

    @Test
    public void addSingleItemToCart(){
        ProductAdd pd = new ProductAdd();
        Assert.assertTrue(pd.selectSingleProduct("Sauce Labs Fleece Jacket"),"Product are not added in cart");

    }
    @Test
    public void addMultipleItemToCart(){
        ProductAdd pd = new ProductAdd();
        Set<String> items = new HashSet<>();
        items.add("Sauce Labs Bolt T-Shirt");
        items.add("Sauce Labs Onesie");
        Assert.assertTrue(pd.selectMultipleProducts(items));
        Assert.assertEquals(pd.verifyCheckoutCount(),items.size());
    }
}
