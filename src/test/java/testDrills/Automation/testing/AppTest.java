package testDrills.Automation.testing;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

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
		test.log(Status.PASS, "Name:" + name + "Surname:" + surname);
	}

	@Test(priority = 2)
	public void test2() {
		System.out.println("Actual test");
	}

}
