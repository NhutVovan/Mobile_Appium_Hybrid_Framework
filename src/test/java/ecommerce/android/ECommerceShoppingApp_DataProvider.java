package ecommerce.android;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import baseTest.AndroidBaseTest;
import ecommerce.pageObjects.android.CartPageObject;
import ecommerce.pageObjects.android.FormPageObject;
import ecommerce.pageObjects.android.ProductCataloguePageObject;
import io.appium.java_client.android.AndroidDriver;


public class ECommerceShoppingApp_DataProvider extends AndroidBaseTest {
	@BeforeClass
	public void BeforeClass() throws IOException {
		//ConfigureServer
		ConfigureServerAndroid();
	}
	
			
	@BeforeMethod
	public void beforeMethod() {
		preSetup();
	}
		
	@Test(dataProvider="getData")
	public void Order_Product_Test(String name, String gender, String country) throws IOException, InterruptedException {
				
		FormPageObject formPage = new FormPageObject((AndroidDriver)driver);
		formPage.setNameField(name);
		formPage.setGender(gender);
		formPage.setCountrySelection(country);
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
		
	}
	
	@AfterClass
	public void AfterClass() {
		//TearDownServer
		TearDownServerAndroid();
	}
	
	@DataProvider
	public Object getData() {
		return new Object[][] {{"John Terry","male","Canada"}, {"Jodie","female","India"}, {"Messi","male","Brazil"}};
	}

}
