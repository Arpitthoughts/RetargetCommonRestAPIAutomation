package Reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Setup implements ITestListener {
private ExtentReports extentReports;
public static ThreadLocal<ExtentTest> extentTestThreadLocal= new ThreadLocal<>();
    public void onStart(ITestContext context) {
        String filepath="./"+"/Reports";
    extentReports= ExtentReportManager.createExtentReportInstance(filepath,"APIAutomationReport","TestExecutionReport");
    }

    public void onTestStart(ITestResult result) {
       ExtentTest extentTest= extentReports.createTest("Test Name "+result.getTestClass().getName()+"--"+result.getMethod().getMethodName());
    extentTestThreadLocal.set(extentTest);
    }

    public void onFinish(ITestContext context) {
        if (extentReports!=null)
            extentReports.flush();
    }
}
