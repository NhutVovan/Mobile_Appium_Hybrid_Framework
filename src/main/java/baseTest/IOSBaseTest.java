package baseTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import utilities.GlobalConstants;

public class IOSBaseTest extends AppiumBaseTest {
	
	
	public IOSDriver ConfigureServerIOS(IOSDriver driver) throws IOException {
		Properties prop = new Properties();
		FileInputStream fileStr = new FileInputStream(GlobalConstants.PROPERTIES_FILE_PATH);
		prop.load(fileStr);
		String ipAddress = prop.getProperty("ipAddress");
		String port = prop.getProperty("port");
		String iosDeviceName = prop.getProperty("iosDeviceName");
		String iosAppPath = prop.getProperty("iosAppPath");
		String iosPlatformVersion = prop.getProperty("iosPlatformVersion");
		
		//Start Appium server
		startAppiumServer();
				
		XCUITestOptions  options = new XCUITestOptions();
		options.setDeviceName(iosDeviceName);
		options.setApp(iosAppPath);
		options.setPlatformVersion(iosPlatformVersion);
		//Appium -> Webdriver Agent - IOS App.
		options.setWdaLaunchTimeout(Duration.ofSeconds(20));
			
	
		driver = new IOSDriver(new URL("http://"+ipAddress+":"+port), options);
			
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
		return driver;
	}
	
	public void TearDownServerIOS(IOSDriver driver) {
		//Quit driver
		driver.quit();
		//Stop Appium server
		service.stop();
	}

}
