package utilities;

import driver.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {

    public static String takeScreenshot(String testName){
        TakesScreenshot tk = (TakesScreenshot) DriverFactory.getDriver();
        File source = tk.getScreenshotAs(OutputType.FILE);
        String dir  = System.getProperty("user.dir")+"/screenshot/"+testName+".png";
        new File(dir).mkdirs();
        String path = dir  + testName + ".png";

        try {
            FileUtils.copyFile(source, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }
    public static void clearScreenshotFolder(){
        File folder = new File(System.getProperty("user.dir")+"/screenshot/");
        if(folder.exists()){
            for (File fl : folder.listFiles()){
                fl.delete();

            }
        }
    }
}
