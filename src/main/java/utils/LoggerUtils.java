package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class LoggerUtils {
	
	public static ExtentReports getReporterObject() {
		String filePath = System.getProperty("user.dir")+"/reports/index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(filePath);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Laxminarayan");
		return extent;
	}
	
	public static String getScreenshot(WebDriver driver, String testCaseName) throws IOException {
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenShotFilePath = System.getProperty("user.dir")+"/reports/"+testCaseName+".png";
		File destinationFile = new File(screenShotFilePath);
		FileUtils.copyFile(source,destinationFile);
		return screenShotFilePath;	
	}

}
