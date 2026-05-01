package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListeners implements ITestListener {

    private static final ExtentReports extentReports = ExtentManager.getReport();
    private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extentReports.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test Passed");
    }


    public void onTestFailure(ITestResult result) {
        String path = ScreenshotUtil.takeScreenshot(result.getName());
        test.get().fail(result.getThrowable());
        test.get().fail(MediaEntityBuilder.createScreenCaptureFromPath(path).build());

    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
    }
}
