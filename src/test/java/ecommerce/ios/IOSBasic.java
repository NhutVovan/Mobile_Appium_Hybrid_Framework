package ecommerce.ios;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import baseTest.IOSBaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;


public class IOSBasic extends IOSBaseTest {
	IOSDriver driver;
	
	@Test
	public void IOS_Basic_Testing() {
		
		driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
		//IOS have more lacator like IOSclassChain, IOSPredicateString
		//IOSclassChain much faster than xpath
		
		//Long press on IOS
		WebElement element = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton['lable == 'increment''"));
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("element",((RemoteWebElement) element).getId());
		params.put("duration", 5);
		driver.executeScript("mobile:touchAndHold", params);
		
		//Scroll on IOS
		WebElement scroll = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton['lable == 'increment''"));
		Map<String, Object> para = new HashMap<String, Object>();
		para.put("direction", "down");
		para.put("element",((RemoteWebElement) scroll).getId());
		driver.executeScript("mobile:scroll", para);
		
		//Send key to picker
		driver.findElement(AppiumBy.accessibilityId("Greem color component value")).sendKeys("80");
		
		//Slider (slide 100%)
		WebElement slider = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeSlider['lable == 'AppLen''"));
		slider.sendKeys("1%"); //Range of value from 0-1
		
		//Work on built in app
		Map<String, String> param = new HashMap<String, String>();
		param.put("bundleId", "com.apple.mobileslideshow");
		driver.executeScript("mobile:launchApp", param); //Bundle id is unique
		
		
		//Swipe on IOS
		Map<String, Object> swipepara = new HashMap<String, Object>();
		swipepara.put("direction", "left");
		driver.executeScript("mobile:swipe", swipepara);//by default. It will swipe from the center of element.
		
	}
}
