package testDrills.Automation.testing;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AppTest extends Base{

	/*Setting test class methods
	 * 
	 *Pre-conditions
	 *Conditions
	 *Cost-conditions
	 */
	
	@BeforeMethod
	public void createTestReport(Method method) {
		System.out.println("Before Method"+method.getName());
	}
	
	@Test(priority=1)
	@Parameters("BrowserType")
	public void test(String browser) {
		System.out.println(browser);
		assert Boolean.TRUE;
	}
	@Test(priority=2)
	public void test2() {
		System.out.println("Actual test");
		assert Boolean.TRUE;
	}
	
	
	
}
