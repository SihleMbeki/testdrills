package Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverActions {
	WebDriver driver;
	
	public WebDriverActions() {
		WebDriverManager.chromedriver().setup();		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		driver= new ChromeDriver(options);
//		driver.get("http://google.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public ChromeDriver getDriver() {
		return (ChromeDriver) driver;
	}
}
