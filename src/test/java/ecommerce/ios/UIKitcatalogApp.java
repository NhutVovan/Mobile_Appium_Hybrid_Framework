package ecommerce.ios;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.IOSBaseTest;
import ecommerce.pageObjects.ios.AlertViewsPageObject;
import ecommerce.pageObjects.ios.HomePageObject;
import io.appium.java_client.ios.IOSDriver;

public class UIKitcatalogApp extends IOSBaseTest {
	
	@Test
	public void AlertViewsTest() throws IOException {
	//ConfigureServer
	ConfigureServerIOS();
			
	HomePageObject homePage = new HomePageObject((IOSDriver)driver);
	AlertViewsPageObject alertViewsPage = homePage.selectAlertViews();
	alertViewsPage.fillTextLabel("Hello");
	String actualMessage = alertViewsPage.getConfirmMessage();
	Assert.assertEquals(actualMessage, "A message should be a short, complete sentence.");
	
	//TearDownServer
	TearDownServerIOS();
	}
	
}
