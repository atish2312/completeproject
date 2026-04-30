package pages;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Waits;

import java.util.ArrayList;
import java.util.List;

public class CheckoutPage extends Waits {

    By checkoutIcon = By.xpath("//a[@class='shopping_cart_link']");
    By countCheckoutButton = By.xpath("/.span");
    By items = By.xpath("//div[@class='cart_item_label']/a/div");
    By getCheckoutIcon = By.xpath("//button[text()='Checkout']");
    By getFirstName = By.xpath("//input[@placeholder='First Name']");
    By getLastName = By.xpath("//input[@placeholder='Last Name']");
    By getZipCode = By.xpath("//input[@placeholder='Zip/Postal Code']");
    By getContinueButton = By.xpath("//input[@type='submit']");
    By getProductName = By.xpath("//div[@class='inventory_item_name']");
    By getProductPrice = By.xpath("./ancestor::div[@class='cart_item_label']/div[@class='item_pricebar']/div");
    By getFinishButton = By.xpath("//button[text()='Finish']");
    By getCheckoutCompletion = By.xpath("//div[@id='checkout_complete_container']/h2");
    By errorCheckoutOverview = By.xpath("//h3[@data-test='error']");




    public String VerifyCheckoutPage(){
        waitForElementClickable(checkoutIcon).click();
         return DriverFactory.getDriver().getCurrentUrl();
    }

    public List<String> verifyTheItems(){
        ArrayList<String> storedItems = new ArrayList<>();
        List<WebElement> allItems = DriverFactory.getDriver().findElements(items);
        for(WebElement nameOfItems : allItems){
           storedItems.add(nameOfItems.getText());
        }
       return storedItems;
    }
    public void clickOnCheckoutButton(){
        waitForElementClickable(getCheckoutIcon).click();
    }

    public void checkDetails(String firstName,String lastName,String postCode){
        waitForElementClickable(getFirstName).sendKeys(firstName);
        waitForElementClickable(getLastName).sendKeys(lastName);
        waitForElementClickable(getZipCode).sendKeys(postCode);
        waitForElementClickable(getContinueButton).click();

    }
    public List<String> checkoutOverview(){
        ArrayList<String> productDetails = new ArrayList<>();
        List<WebElement>getProduct = DriverFactory.getDriver().findElements(getProductName);
        for(int i = 0 ; i<getProduct.size();i++){
            String name = getProduct.get(i).getText();
            productDetails.add(name);
        }
        waitForElementClickable(getFinishButton).click();
        return productDetails;
    }
    public String getCompletionCheckout(){
        return DriverFactory.getDriver().findElement(getCheckoutCompletion).getText();
    }
    public String getCheckoutOverviewError(){
        return DriverFactory.getDriver().findElement(errorCheckoutOverview).getText();
    }

}
