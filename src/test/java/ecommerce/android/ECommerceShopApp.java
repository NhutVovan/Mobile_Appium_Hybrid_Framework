package ecommerce.android;

import java.io.IOException;
import org.testng.annotations.Test;
import baseTest.AndroidBaseTest;
import ecommerce.pageObjects.android.FormPageObject;
import ecommerce.pageObjects.android.ProductCataloguePageObject;
import io.appium.java_client.android.AndroidDriver;


public class ECommerceShopApp extends AndroidBaseTest {
	
	
	@Test
	public void appiumTest() throws IOException, InterruptedException {
		//ConfigureServer
		ConfigureServerAndroid();
		
		FormPageObject formPage = new FormPageObject((AndroidDriver)driver);
		formPage.setNameField("Joe Terry");
		formPage.setGender("female");
		formPage.setCountrySelection("Argentina");
		ProductCataloguePageObject productCataloguePage= formPage.submitForm();
		
		productCataloguePage.addItemToCartByIndex(0);
		productCataloguePage.addItemToCartByIndex(0);
		productCataloguePage.goToCartPage();
		
		//TearDownServer
		TearDownServerAndroid();
	}

}
