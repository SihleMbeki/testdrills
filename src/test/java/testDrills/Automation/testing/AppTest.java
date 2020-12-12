package testDrills.Automation.testing;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import PageObjects.YouTube;
import Utilities.ExtentReport;
import Utilities.SoccerTeams;

public class AppTest extends Base {

	/*
	 * Setting test class methods
	 * 
	 * Pre-condition - Set test report
	 * Parameters: Method Name
	 */

	@BeforeMethod
	public void createTestReport(Method method) {
		test = ExtentReport.createTest(method.getName());
	}

	@Test(priority = 1, dataProviderClass = SoccerTeams.class, dataProvider = "getTableData")
	// @Parameters("BrowserType")
	public void test(String name, String surname) {
		YouTube homepage=PageFactory.initElements(webDriver.getDriver(), YouTube.class);
		webDriver.getDriver().navigate().to("https://www.youtube.com/");
		WebDriverWait wait = new WebDriverWait(webDriver.getDriver(),10);
		wait.until(ExpectedConditions.visibilityOf(homepage.searchBar));
		test.log(Status.PASS, "Name:" + name + "Surname:" + surname);
		homepage.searchBar.sendKeys( "Name:" + name + "Surname:" + surname);
		webDriver.getDriver().close();
	}

	@Test(priority = 2)
	public void test2() {
		System.out.println("Actual test");
	}

}
