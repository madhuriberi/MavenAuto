package testometer.org.FlipkartAutomation;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;

import testometer.org.flipkartBusinessLayer.FlipkartAutomationMain;

public class TestFlipkartAutomationMain {
	
	@BeforeTest
	public void beforetestFlipkartLoginAutomationPassed() {
		System.out.println("Before the Actual Test Case Method...");
	}
	
	//Test Case for flipkartLoginAutomation method...
	@Test(priority = 9)
	public void testFlipkartLoginAutomationPassed() throws InterruptedException, IOException {
		
		//Invoking the Actual source code method...
		String actualReturnValue = FlipkartAutomationMain.flipkartLoginAutomation("https://flipkart.com/");
		
		
		//Actual assertion...
		Assert.assertEquals(actualReturnValue, "Success");
	}
	
	//Test Case for flipkartLoginAutomation method...
	@Test(priority = 5)
	public void testFlipkartLoginAutomationFailed() throws InterruptedException, IOException {
			
			//Invoking the Actual source code method...
			String actualReturnValue = FlipkartAutomationMain.flipkartLoginAutomation("https://www.flipkart.com/");
			
			//Actual assertion...
			Assert.assertEquals(actualReturnValue, "success");
	}
	
	
}//End of the Test case Class...
