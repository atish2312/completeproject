package driver;

import org.openqa.selenium.WebDriver;

import javax.sql.rowset.WebRowSet;

public class DriverFactory {

    private final static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setDriver(WebDriver d){
        driver.set(d);
    }

    public static WebDriver getDriver(){
        return driver.get();

    }
    public static void quitDriver(){
        if(getDriver()!=null){
            getDriver().quit();
        }
    }


}
