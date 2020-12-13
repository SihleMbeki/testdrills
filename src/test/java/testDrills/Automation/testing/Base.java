package testDrills.Automation.testing;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentTest;

import Utilities.ExtentReport;
import Utilities.WebDriverActions;

public class Base {

	/*
	 * Setting test suite methods
	 * 
	 * Pre-conditions 
	 * Conditions 
	 * Post-conditions
	 */

	ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();
	ThreadLocal<DesiredCapabilities> cp = new ThreadLocal<DesiredCapabilities>();
	ThreadLocal<ExtentTest> extent = new ThreadLocal<ExtentTest>();

	@BeforeSuite
	public void setTestSuite() {
		ExtentReport.createReport();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
	}

	@BeforeTest
	public void setTestReport() {

	}

	@BeforeClass
	public void method3() {
		//System.out.println("Before Class");
	}

	@AfterSuite
	public void postMethod1() {
		ExtentReport.closeReport();
	}

	@AfterTest
	public void postMethod2() {
	//	System.out.println("After Test");
	}

	@AfterClass
	public void postMethod3() {
		//System.out.println("After Class");
	}

	public WebDriver getDriver() {
		return dr.get();
	}

	public ExtentTest getTest() {
		return extent.get();
	}

	public void setTest(ExtentTest test) {
		extent.set(test);
	}

	public DesiredCapabilities getCapabilities() {
		return (DesiredCapabilities) cp.get();
	}

	public void setDriver(WebDriver driver) {
		dr.set(driver);
	}

	public void setCapabilities(DesiredCapabilities capabilities) {
		cp.set(capabilities);
	}

}
