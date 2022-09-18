package ecommerce.pageObjects.android;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utilities.AndroidActions;

public class CartPageObject extends AndroidActions {

	AndroidDriver driver;
	
	public CartPageObject(AndroidDriver driver){
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
	private List<WebElement> productPrice;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement totalAmount;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/termsButton")
	private WebElement termsButton;
	
	@AndroidFindBy(id="android:id/button1")
	private WebElement acceptButton;
	
	@AndroidFindBy(className="android.widget.CheckBox")
	private WebElement checkBox;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
	private WebElement proceedButton;
	
	public Double getProductSum() {
		return summaryPriceInCart(productPrice);
	}
	
	public Double getTotalAmountDisplayed() {
		return convertPriceFromStringToDouble(totalAmount.getText());
	}
	
	public void getAcceptTermsConditions() {
		longPressAndroidApp(driver, termsButton);
		acceptButton.click();
	}
	
	public void getCheckBox() {
		checkBox.click();
	}
	
	public void submitOrder() {
		proceedButton.click();
	}
	
}
