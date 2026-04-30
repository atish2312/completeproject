    package pages;
    
    import driver.DriverFactory;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebElement;
    import utilities.Waits;

    import java.util.ArrayList;
    import java.util.List;
    import java.util.Set;


    public class ProductAdd extends Waits {

        By productNames = By.xpath("//div[@class='inventory_item_description']/div/a");
        By addToCart = By.xpath("./ancestor::div[@class='inventory_item_description']/div[2]/button");
        By countCheckoutButton = By.xpath("//a[@class='shopping_cart_link']/span");
        By getMenu = By.xpath("//div[@class='bm-burger-button']");
        By logoutBUtton = By.xpath("//a[text()='Logout']");
        By checkCountCart = By.xpath("//span[@class='shopping_cart_badge']");


        public boolean selectSingleProduct(String productName) {
            boolean productClicked = false;
            List<WebElement> products = DriverFactory.getDriver().findElements(productNames);
            for (WebElement product : products) {
                String productNames = product.getText();
                if (productNames.equalsIgnoreCase(productName)) {
                   waitForElementClickable(product.findElement(addToCart)).click();
                     productClicked = true;
                    break;
                }
            }
            return productClicked;
        }

        public boolean selectMultipleProducts(Set<String> itemNames){
            int clickCount = 0;
            List<WebElement> productList = waitForElementVisible(productNames);
            for(WebElement products : productList){
                String name = products.getText();
                if(itemNames.contains(name)){
                        waitForElementClickable(products.findElement(addToCart)).click();
                        clickCount++;
                }

            }
            return clickCount == itemNames.size();
        }

        public int verifyCheckoutCount(){
        String names = waitForElementClickable(countCheckoutButton).getText();
            return Integer.parseInt(names);
        }

        public  String productAddWithoutLogin(){
            return DriverFactory.getDriver().getCurrentUrl();

        }
        public void setLogoutButton(){
            waitForElementClickable(getMenu).click();
            waitForElementClickable(logoutBUtton).click();
        }
        public Integer getCountCart(){
            String count=  DriverFactory.getDriver().findElement(checkCountCart).getText();
            return Integer.parseInt(count);
        }


    }



