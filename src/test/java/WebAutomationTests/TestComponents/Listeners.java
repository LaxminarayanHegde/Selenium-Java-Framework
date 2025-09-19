package WebAutomationTests.TestComponents;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import utils.LoggerUtils;

public class Listeners implements ITestListener {
	
	ExtentReports extent = LoggerUtils.getReporterObject();
	ExtentTest test;
	WebDriver driver;
	ThreadLocal<ExtentTest> threadLocalExtent = new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		threadLocalExtent.set(test);
	}
	
	public void ontTestSuccess(ITestResult result) {
		threadLocalExtent.get().log(Status.PASS, "Test Passed");
	}
	
	public void onTestFailure(ITestResult result) {
		threadLocalExtent.get().fail(result.getThrowable());
		String screenshotPath = null ;
		try {
			driver = ((BaseTest)result.getInstance()).getDriver();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			screenshotPath = LoggerUtils.getScreenshot(driver, result.getMethod().getMethodName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		threadLocalExtent.get().addScreenCaptureFromPath(screenshotPath, result.getMethod().getMethodName());
	}
	
	public void onTestSkipped(ITestResult result) {
		threadLocalExtent.get().skip(result.getThrowable());
		String screenshotPath = null ;
		try {
			driver = ((BaseTest)result.getInstance()).getDriver();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			screenshotPath = LoggerUtils.getScreenshot(driver, result.getMethod().getMethodName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		threadLocalExtent.get().addScreenCaptureFromPath(screenshotPath, result.getMethod().getMethodName());
	}
	
	public void onFinish(ITestContext context) {
		extent.flush(); 
	}
}
