package WebAutomationTests.TestComponents;

import org.testng.annotations.AfterMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeMethod;

import webAutomation.pageObjects.LandingPage;

public class BaseTest {
	WebDriver driver;
	public LandingPage landingPage;
	
	public WebDriver getDriver() {
	    return driver;
	}
	
	public WebDriver initializeDriver() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/webAutomation/resources/GlobalData.properties");
		prop.load(fis);
		String browserName = System.getProperty("browser") != null ? System.getProperty("browser") : prop.getProperty("browser");
		String isHeadless = System.getProperty("headless") != null ?  System.getProperty("headless") : prop.getProperty("headless");
		ChromeOptions options = new ChromeOptions();
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		EdgeOptions edgeOptions = new EdgeOptions();
		
		if(browserName.equalsIgnoreCase("chrome")) {
			if(isHeadless.equals("true")) {
				options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440, 900));
		}
		
		else if(browserName.equalsIgnoreCase("fireFox")) {
			if(isHeadless.equals("true")) {
				firefoxOptions.addArguments("headless");
			}
			driver = new FirefoxDriver(firefoxOptions);
		
		}
		
		else if(browserName.equalsIgnoreCase("Edge")) {
			if(isHeadless.equals("true")) {
				edgeOptions.addArguments("headless");
			}
			driver = new EdgeDriver();
		
		}
		else if(browserName.equalsIgnoreCase("Safari")) {
			driver = new SafariDriver();
		
		}
		
		driver.manage().window().maximize();
		
		return driver;
		
	}
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication() throws IOException {
		driver = initializeDriver();
		landingPage = new LandingPage(driver);
		landingPage.goTo();
		return landingPage;
		
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		driver.quit();
	}
}
