    package Test;

    import TestData.CheckOutInformation;
    import TestData.ProductData;
    import base.BaseTest;
    import org.testng.Assert;
    import org.testng.annotations.Test;
    import pages.CheckoutPage;
    import pages.LoginPage;
    import pages.ProductAdd;
    import utilities.ConfigReader;

    import java.util.ArrayList;
    import java.util.List;

    public class CheckOutTest extends BaseTest {


        @Test
        public void verifyCheckout(){
            ProductAdd pd = new ProductAdd();
            CheckoutPage chk = new CheckoutPage();
            Assert.assertTrue(pd.selectMultipleProducts(ProductData.getProductData()));
            Assert.assertEquals(pd.verifyCheckoutCount(),ProductData.getProductData().size());

            Assert.assertEquals(chk.VerifyCheckoutPage(),"https://www.saucedemo.com/cart.html");
            Assert.assertEquals(chk.verifyTheItems(), ProductData.getProductData());
            chk.clickOnCheckoutButton();
            chk.checkDetails(CheckOutInformation.getFirstName(),CheckOutInformation.getLastName(),CheckOutInformation.getPostalCode());
            Assert.assertEquals(chk.checkoutOverview(),ProductData.getProductData());
            Assert.assertEquals(chk.getCompletionCheckout(),"Thank you for your order!");
        }

    }
