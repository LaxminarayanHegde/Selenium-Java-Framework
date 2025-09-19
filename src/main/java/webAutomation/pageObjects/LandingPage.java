package webAutomation.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.ElementsUtils;

public class LandingPage extends ElementsUtils{
	
	WebDriver driver;
	
	// Locators
	private By emailTextField = By.id("userEmail");
	private By passwordTextField = By.id("userPassword");
	private By loginButton = By.cssSelector(".login-btn");
	private By cartPageTitle = By.xpath("//h3[text()='Automation']");
	
	private By emptyEmailFieldErrorMsg = By.xpath("//div[text()='*Email is required']");
	private By emptyPasswordFieldErrorMsg = By.xpath("//div[text()='*Password is required']");

	// Constructor
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	// Methods
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public void loginApplication(String emailId, String password) {
		driver.findElement(emailTextField).sendKeys(emailId);
		driver.findElement(passwordTextField).sendKeys(password);
		driver.findElement(loginButton).click();
		String cartTitleString = waitForElementToAppear(cartPageTitle).getText();
		Assert.assertEquals(cartTitleString, "AUTOMATION");
	}
	
	public void validateEmptyEmailIdAndEmptyPasswordField() {
		driver.findElement(loginButton).click();
		String emptyEmailFieldErrorString = waitForElementToAppear(emptyEmailFieldErrorMsg).getText();
		Assert.assertEquals(emptyEmailFieldErrorString, "*Email is required");
		String emptyPasswordFieldErrorString = waitForElementToAppear(emptyPasswordFieldErrorMsg).getText();
		Assert.assertEquals(emptyPasswordFieldErrorString, "*Password is required");
	}
	
	public void validateEmptyEmailIdField(String password) {
		driver.findElement(passwordTextField).sendKeys(password);
		driver.findElement(loginButton).click();
		String emptyEmailFieldErrorString = waitForElementToAppear(emptyEmailFieldErrorMsg).getText();
		Assert.assertEquals(emptyEmailFieldErrorString, "*Email is required");
	}
	
	public void validateEmptyPasswordField(String emailId) {
		driver.findElement(emailTextField).sendKeys(emailId);
		driver.findElement(loginButton).click();
		String emptyPasswordFieldErrorString = waitForElementToAppear(emptyPasswordFieldErrorMsg).getText();
		Assert.assertEquals(emptyPasswordFieldErrorString, "*Password is required");
	}	
}