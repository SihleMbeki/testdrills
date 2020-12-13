package testDrills.Automation.testing;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import PageObjects.YouTube;
import Utilities.ExtentReport;
import Utilities.SoccerTeams;
import Utilities.WebDriverActions;

public class AppTest extends Base {

	/*
	 * Setting test class methods
	 * 
	 * Pre-condition 
	 * Set test report 
	 * {{Parameters}} Method Name :String
	 */

	WebDriver driver;
	DesiredCapabilities capabilities = null;
	ExtentTest test;

	@BeforeMethod
	public void createTestReport(Method method) {
		test = ExtentReport.createTest(method.getName());
		setTest(test);
	}

	@Test(priority = 1, dataProviderClass = SoccerTeams.class, dataProvider = "getTableData")
	public void test(String name, String surname, String browser) {

		// setting up the webdriver instance
		if (browser.equals("chrome")) {
			capabilities = new DesiredCapabilities();// DesiredCapabilities.chrome();
			setCapabilities(capabilities);
			getCapabilities().setBrowserName("chrome");
			getCapabilities().setPlatform(Platform.ANY);
			ChromeOptions options = new ChromeOptions();
			options.merge(getCapabilities());
		}

		try {
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), getCapabilities());
			setDriver(driver);

		} catch (MalformedURLException e) {
			e.printStackTrace();
			Assert.fail();
		}
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Creating the action page for the home page
		YouTube homepage = PageFactory.initElements(getDriver(), YouTube.class);
		getDriver().navigate().to("https://www.youtube.com/");
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.visibilityOf(homepage.searchBar));
		getTest().log(Status.PASS, "Name:" + name + " Surname:" + surname);
		homepage.searchBar.sendKeys("Name:" + name + " Surname:" + surname);

		try {
			getDriver().quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 2)
	@Parameters("BrowserType")
	public void test2(String browser) {
		getTest().log(Status.PASS, "Browser " + browser);
	}

}
