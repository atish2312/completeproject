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
    By getFinishButton = By.xpath("//button[text()='Finish']");



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

    public String checkDetails(String firstName,String lastName,String postCode){
        waitForElementClickable(getFirstName).sendKeys(firstName);
        waitForElementClickable(getLastName).sendKeys(lastName);
        waitForElementClickable(getZipCode).sendKeys(postCode);
        waitForElementClickable(getContinueButton).click();
        return DriverFactory.getDriver().getCurrentUrl();
    }
    public void checkoutOverview(){
        
    }





}
