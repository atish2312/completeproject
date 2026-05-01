package utilities;

import driver.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;

public class ScreenshotUtil {

    public static String takeScreenshot(String testName){
       TakesScreenshot tk = (TakesScreenshot) DriverFactory.getDriver();
       File source = tk.getScreenshotAs(OutputType.FILE);

       String path = System.getProperty("user.dir")+"/reports/screenshots/"+testName+".png";
try {
    FileUtils.copyFile(source, new File(path));
} catch (IOException e) {
    throw new RuntimeException(e);
}
       return path;
    }

}