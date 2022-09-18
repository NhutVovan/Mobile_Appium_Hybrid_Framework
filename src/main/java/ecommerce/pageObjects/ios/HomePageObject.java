package ecommerce.pageObjects.ios;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import utilities.IOSActions;

public class HomePageObject extends IOSActions {
	IOSDriver driver;
	
	public HomePageObject(IOSDriver driver){
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@iOSXCUITFindBy(accessibility="Alert Views")
	private WebElement alertViews;
	
	
	
	public AlertViewsPageObject selectAlertViews() {
		alertViews.click();
		return new AlertViewsPageObject(driver);
	}
	
}
