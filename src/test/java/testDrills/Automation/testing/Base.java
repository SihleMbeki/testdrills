package testDrills.Automation.testing;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class Base {
	/*Setting test suite methods
	 * 
	 *Pre-conditions
	 *Conditions
	 *Cost-conditions
	 */
	
	@BeforeSuite
	public void method1() {
		System.out.println("Before Suite");
	}
	
	@BeforeTest
	public void method2() {
		System.out.println("Before Test");
	}
	
	@BeforeClass
	public void method3() {
		System.out.println("Before Class");
	}
	
	@AfterSuite
	public void postMethod1() {
		System.out.println("After Suite");
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
