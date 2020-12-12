package testDrills.Automation.testing;

import java.lang.reflect.Method;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentTest;

import Utilities.ExtentReport;

public class Base {
	//Test item for the page results
	ExtentTest test;
	
	/*Setting test suite methods
	 * 
	 *Pre-conditions
	 *Conditions
	 *Cost-conditions
	 */
	
	@BeforeSuite
	public void setTestSuite() {
		ExtentReport.createReport();
	}
	
	@BeforeTest
	public void setTestReport() {
	
	}
	
	@BeforeClass
	public void method3() {
		System.out.println("Before Class");
	}
	
	@AfterSuite
	public void postMethod1() {
		ExtentReport.closeReport();
	}
	
	@AfterTest
	public void postMethod2() {
		System.out.println("After Test");
	}
	
	@AfterClass
	public void postMethod3() {
		System.out.println("After Class");
	}
}
