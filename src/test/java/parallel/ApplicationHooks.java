 package parallel;

import java.io.File;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	private Properties prop;
	
	@Before(order=0)
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();
	}
	
	@Before(order=1)
	public void lauchBrowser() {
		driverFactory = new DriverFactory();
		String browserName = prop.getProperty("browser");
		driver = driverFactory.init_driver(browserName);
	}
	
	@After(order=0)
	public void quitBrowser() {
		driver.quit();
	}
	
	@After(order=1)
	public void tearDown(Scenario sc) {
		if(sc.isFailed()) {
			String screenshotName = sc.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			sc.attach(sourcePath, "image/png", screenshotName);
		}
	}
}
