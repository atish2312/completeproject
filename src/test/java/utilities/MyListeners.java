package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListeners implements ITestListener {

    private static ExtentReports extentReports = ExtentManager.getReport();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extentReports.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String path = ScreenshotUtil.takeScreenshot(result.getName());
        test.get().fail(result.getThrowable());
        test.get().addScreenCaptureFromPath(path);

    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
    }
}
