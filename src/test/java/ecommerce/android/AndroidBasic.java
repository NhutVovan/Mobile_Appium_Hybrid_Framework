package ecommerce.android;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import baseTest.AndroidBaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import utilities.GlobalConstants;

public class AndroidBasic extends AndroidBaseTest {
	AndroidDriver driver;
	
	@Test
	public void appiumTest() throws IOException {
		
		//Start Appium server
		service = new AppiumServiceBuilder().withAppiumJS(new File(GlobalConstants.APPIUMJS_PATH))
								.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel2XL");
		options.setApp("D:\\Selenium\\Mobile Testing\\Mobile_Testing_Appium_Android\\Appium\\src\\main\\java\\resources\\ApiDemos-debug.apk");
		//options.setChromedriverExecutable(GlobalConstants.BROWSER_DRIVER_PATH);
		//options.setCapability("browserName", "Chrome");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		
		//Automation testcases
		//Xpath, id, accessibilityId, classname, androidUIAutomator
		//Find element via class name
		driver.findElement(AppiumBy.className(""));
		//Find element via xpath
		driver.findElement(AppiumBy.xpath(""));
		//Find element via id
		driver.findElement(AppiumBy.id(""));
		//Hide Keyboard
		driver.hideKeyboard();
		//Get Toast message text
		driver.findElement(By.xpath("(//android.wiget.Toast)[1]")).getAttribute("name");
		//Go direct to activity via package
		Activity activity = new Activity("io.appium.android.apis","io.appium.android.apis.Preference.PrepreferenceDefendencies");
		driver.startActivity(activity);
		// Device Rotation
		DeviceRotation landscap = new DeviceRotation(0,0,90);
		driver.rotate(landscap);
		//Set clipboard va pass tu clipboard
		driver.setClipboardText("New Phone");
		String name = driver.getClipboardText();
		//Press key in android
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		//Add to cart when the same id
		int productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		for (int i=0;i<productCount; i++) {
			String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			if (productName.equalsIgnoreCase("Jordan 6 Rings")) {
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
			}
		}
		//Explicit wait
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		explicitWait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar-title")), "text", "Card"));
		//Summary of product price in cart
		List<WebElement> productPrice = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		int count = productPrice.size();
		Double sum = 0.0;
		for (int i=0;i<count; i++) {
			String amountString = productPrice.get(i).getText();
			Double price = Double.parseDouble(amountString.substring(1));
			sum = sum + price;
		}
		//Switch driver from android driver to web driver
		Set<String> contexts = driver.getContextHandles();
		for(String contextName:contexts) {
			System.out.println("context Name handking: " + contextName);
		}
		driver.context("WEBVIEW.com"); //Change the context name corresponding
		//Switch back to app
		driver.context("NATIVE_APP");
		
		
		
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//Quit driver
		driver.quit();
		//Stop Appium server
		service.stop();
	}

}
