package utilities;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;

public class IOSActions {

	public void touchAndHoldIOSApp(IOSDriver driver, WebElement ele) {
		Map<String, Object>params = new HashMap();
		params.put("element", ((RemoteWebElement)ele).getId());
		params.put("duration",5);
		
		driver.executeScript("mobile:touchAndHold", params);
	}
	
	public void scrollDownIOSApp(IOSDriver driver, WebElement ele) {
		Map<String, Object>params = new HashMap();
		params.put("direction", "down");
		params.put("element", ((RemoteWebElement)ele).getId());
		
		driver.executeScript("mobile:scroll", params);
	}
	
	public void scrollUpIOSApp(IOSDriver driver, WebElement ele) {
		Map<String, Object>params = new HashMap();
		params.put("direction", "up");
		params.put("element", ((RemoteWebElement)ele).getId());
		
		driver.executeScript("mobile:scroll", params);
	}
	
	public void sendKeyToPickerIOSApp(IOSDriver driver, String accessibilityId, String textValue) {
		driver.findElement(AppiumBy.accessibilityId(accessibilityId)).sendKeys(textValue);
	}
	
	public void slideIOSApp(IOSDriver driver, String accessibilityId, String textValue) {
		WebElement slider = driver.findElement(AppiumBy.accessibilityId(accessibilityId));
		slider.sendKeys(textValue); //Range of value from 0-1
	}
	
	public void swipeLeftIOSApp(IOSDriver driver) {
		Map<String, Object> swipepara = new HashMap<String, Object>();
		swipepara.put("direction", "left");
		driver.executeScript("mobile:swipe", swipepara);//by default. It will swipe from the center of element.
	}
	
	public void launchBuiltInIOSApp(IOSDriver driver, String bundleIdName) {
		Map<String, String> param = new HashMap<String, String>();
		param.put("bundleId", bundleIdName);
		driver.executeScript("mobile:launchApp", param); //Bundle id is unique
	}
}
