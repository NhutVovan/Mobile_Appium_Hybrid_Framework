package ecommerce.android;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

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
import utilities.GlobalConstants;


public class ECommerceShoppingApp_DataFromJsonFile extends AndroidBaseTest {
	
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
	public void Order_Product_Test(HashMap<String,String> input) throws IOException, InterruptedException {
		FormPageObject formPage = new FormPageObject((AndroidDriver)driver);
		formPage.setNameField(input.get("name"));
		formPage.setGender(input.get("gender"));
		formPage.setCountrySelection(input.get("country"));
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
	public Object[][] getData() throws IOException {
		FormPageObject formPage = new FormPageObject((AndroidDriver)driver);
		List<HashMap<String,String>> data = formPage.getJsonData(GlobalConstants.JSON_FILE_PATH);
		return new Object[][] {{data.get(0)}, {data.get(1)}, {data.get(2)}};
	}

}
