package ecommerce.android;

import java.io.IOException;
import org.testng.annotations.Test;
import baseTest.AndroidBaseTest;
import ecommerce.pageObjects.android.FormPageObject;
import io.appium.java_client.android.AndroidDriver;


public class FormPageTest extends AndroidBaseTest {
	
	
	@Test
	public void appiumTest() throws IOException {
		
		ConfigureServerAndroid();
		
		FormPageObject formPage = new FormPageObject((AndroidDriver)driver);
		formPage.setNameField("Joe Terry");
		formPage.setGender("female");
		
		TearDownServerAndroid();
	}

}
