package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extentReports;

    public static ExtentReports getReport() {
        if (extentReports == null) {
            ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/reports");
            extentReports = new ExtentReports();
            extentReports.attachReporter(reporter);

        }
        return extentReports;
    }
}

