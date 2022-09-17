package baseTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import utilities.GlobalConstants;

public class AppiumBaseTest {

	public static AppiumDriverLocalService service;
	public AppiumDriver driver;
	
	public void startAppiumServer() throws IOException {
		Properties prop = new Properties();
		FileInputStream fileStr = new FileInputStream(GlobalConstants.PROPERTIES_FILE_PATH);
		prop.load(fileStr);
		String ipAddress = prop.getProperty("ipAddress");
		String port = prop.getProperty("port");
		
		//Start Appium server
		service = new AppiumServiceBuilder().withAppiumJS(new File(GlobalConstants.APPIUMJS_PATH))
						.withIPAddress(ipAddress).usingPort(Integer.parseInt(port)).build();
		service.start();
	}
	
	public void waitForElementAppear(AppiumDriver driver, String eleId,  String attribute, String attributeValue) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		explicitWait.until(ExpectedConditions.attributeContains(driver.findElement(By.id(eleId)), attribute, attributeValue));
	}
}
