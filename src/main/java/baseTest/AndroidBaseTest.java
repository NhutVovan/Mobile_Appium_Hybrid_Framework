package baseTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import utilities.GlobalConstants;

public class AndroidBaseTest extends AppiumBaseTest {
	
	
	public void ConfigureServerAndroid() throws IOException {
		Properties prop = new Properties();
		FileInputStream fileStr = new FileInputStream(GlobalConstants.PROPERTIES_FILE_PATH);
		prop.load(fileStr);
		String ipAddress = prop.getProperty("ipAddress");
		String port = prop.getProperty("port");
		String androidDeviceName = prop.getProperty("androidDeviceName");
		String androidAppPath = prop.getProperty("androidAppPath");
		
		//Start Appium server
		startAppiumServer();
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(androidDeviceName);
		options.setApp(androidAppPath);
		//options.setChromedriverExecutable(GlobalConstants.BROWSER_DRIVER_PATH);
		//options.setCapability("browserName", "Chrome");
		
		driver = new AndroidDriver(new URL("http://"+ipAddress+":"+port), options);
					
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIME_OUT));
	}
	
	public void TearDownServerAndroid() {
		//Quit driver
		driver.quit();
		//Stop Appium server
		service.stop();
	}

}
