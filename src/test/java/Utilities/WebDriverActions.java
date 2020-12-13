package Utilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import testDrills.Automation.testing.Base;

public class WebDriverActions extends Base{
	/*
	 * Set chrome driver instance threads 
	 *  
	 */

	public RemoteWebDriver driver;
	public DesiredCapabilities capabilities = null;

	

	public  void createDriverInstance(String browser) {
		

	}

}
