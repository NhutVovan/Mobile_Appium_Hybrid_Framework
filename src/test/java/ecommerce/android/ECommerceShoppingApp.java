package ecommerce.android;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import baseTest.AndroidBaseTest;
import ecommerce.pageObjects.android.CartPageObject;
import ecommerce.pageObjects.android.FormPageObject;
import ecommerce.pageObjects.android.ProductCataloguePageObject;
import io.appium.java_client.android.AndroidDriver;


public class ECommerceShoppingApp extends AndroidBaseTest {
	
	
	@Test
	public void appiumTest() throws IOException, InterruptedException {
		//ConfigureServer
		ConfigureServerAndroid();
		
		FormPageObject formPage = new FormPageObject((AndroidDriver)driver);
		formPage.setNameField("Jodie Foster");
		formPage.setGender("female");
		formPage.setCountrySelection("Argentina");
		ProductCataloguePageObject productCataloguePage= formPage.submitForm();
		
		productCataloguePage.addItemToCartByIndex(0);
		productCataloguePage.addItemToCartByIndex(0);
		CartPageObject cartPage = productCataloguePage.goToCartPage();
		Double totalSum = cartPage.getProductSum();
		Double totalDisplayed = cartPage.getTotalAmountDisplayed();
		//Check amount correct
		Assert.assertEquals(totalSum, totalDisplayed);
		
		cartPage.getAcceptTermsConditions();
		cartPage.getCheckBox();
		cartPage.submitOrder();
		
		//TearDownServer
		TearDownServerAndroid();
	}

}
