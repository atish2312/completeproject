package TestData;

import java.util.HashSet;
import java.util.Set;

public class ProductData {
    public static Set<String> getProductData(){
        Set<String> items = new HashSet<>();
        items.add("Sauce Labs Bolt T-Shirt");
        items.add("Sauce Labs Onesie");
        return items;
    }
}
