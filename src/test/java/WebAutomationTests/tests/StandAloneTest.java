package WebAutomationTests.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import WebAutomationTests.TestComponents.BaseTest;
import utils.FilesUtil;


public class StandAloneTest extends BaseTest{
	
	@Test(groups= {"Regression","Smoke"}, dataProvider = "getData")
    public void loginValidations(HashMap<String, String> testData) throws IOException {  
		landingPage.loginApplication(testData.get("emailId"), testData.get("password"));
		
    }
	
	@DataProvider
	public Object[][] getData() throws IOException{
		String filePath = System.getProperty("user.dir")+"/src/main/java/webAutomation/resources/TestData/UserLoginCredentials.json";
		List<HashMap<String, String>> testData = FilesUtil.getJsonDataFromFile(filePath);
		return new Object[][] {{testData.get(0)},{testData.get(1)}};
	}
	
//	@DataProvider
//	public Object[][] getData() {
//		return new Object[][] {{"testautomation2@gmail.com","Testautomation@123"},{"testautomation3@gmail.com","Testautomation@123"}};
//	}
	
//	@DataProvider
//	public Object[][] getData(){
//		HashMap<String, String> map = new HashMap<>();
//		map.put("emailId", "testautomation2@gmail.com");
//		map.put("password", "Testautomation@123");
//		
//		HashMap<String, String> map2 = new HashMap<>();
//		map2.put("emailId", "testautomation3@gmail.com");
//		map2.put("password", "Testautomation@123");
//		
//		return new Object[][] {{map},{map2}}; 
//	}
}