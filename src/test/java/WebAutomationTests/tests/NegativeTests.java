package WebAutomationTests.tests;

import org.testng.annotations.Test;
import WebAutomationTests.TestComponents.BaseTest;
import WebAutomationTests.TestComponents.RetryTest;

public class NegativeTests extends BaseTest{
	
	@Test(groups={"NegativeTest", "Regression"}, retryAnalyzer = RetryTest.class)
	public void loginValidationWithEmptyEmailIdAndEmptyPasswordField() {
		landingPage.validateEmptyEmailIdAndEmptyPasswordField();
	}
	
	@Test(groups={"NegativeTest","Regression"})
	public void loginValidationWithEmptyEmailIdField() {
		landingPage.validateEmptyEmailIdField("Testautomation@123");
	}
	
	@Test(groups={"Regression", "NegativeTest"})
	public void loginValidationWithEmptyPasswordField() {
		landingPage.validateEmptyPasswordField("testautomation2@gmail.com");
	}
}
