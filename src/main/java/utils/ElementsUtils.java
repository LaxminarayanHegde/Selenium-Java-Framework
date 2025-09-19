package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementsUtils {
	WebDriver driver;
	
	public ElementsUtils(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement waitForElementToAppear(By element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(element));			
	}

}
