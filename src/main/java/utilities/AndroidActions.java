package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AndroidActions extends JavaActions {

	
	public void longPressAndroidApp(AndroidDriver driver, WebElement element) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId(), "duration", 2000
			));
	}
	
	public void scrollToElementAndroidApp(AndroidDriver driver, String elementText) {
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+elementText+"\"));"));
	}
	
	public boolean scrollDownAndroidApp(AndroidDriver driver) {
		return (boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
				"left", 100, "top", 100, "width", 200, "height", 200,
				"direction", "down",
				"percent", 3.0));
	}
	
	public boolean scrollUpAndroidApp(AndroidDriver driver) {
		return (boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
				"left", 100, "top", 100, "width", 200, "height", 200,
				"direction", "up",
				"percent", 3.0));
	}
	
	public boolean swipeLeftAndroidApp(AndroidDriver driver, WebElement element) {
		return (boolean) ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement) element).getId(),
				"direction", "left",
				"percent", 0.75));
	}
	
	public void swipeRightAndroidApp(AndroidDriver driver, WebElement element) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement) element).getId(),
				"direction", "right",
				"percent", 0.75));
	}
	
	public void dragAndDropAndroidApp(AndroidDriver driver, WebElement element, long endx, long endy) {
		 	((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement) element).getId(),
				"endX", endx,
				"endY", endy));
	}
	
	public void scrollDownAndroidBrowser(AndroidDriver driver, String pixelscrolldown) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + pixelscrolldown + ")","" );
	}
	
}
