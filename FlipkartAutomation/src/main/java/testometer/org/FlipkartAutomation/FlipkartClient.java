package testometer.org.FlipkartAutomation;

import java.awt.AWTException;
import java.io.IOException;

import testometer.org.flipkartBusinessLayer.FlipkartAutomationMain;

/**
 * Hello world!
 *
 */
public class FlipkartClient 
{
	// Instance/Object Variables...
	public static String webApplicationURL = "https://www.flipkart.com/";
		
    public static void main( String[] args ) throws InterruptedException, IOException, AWTException
    {
        System.out.println( "Welcome to Automation World!!!" );
        
        //Creating instances/object for the Flipkart Automation Class...
        FlipkartAutomationMain flipkartMain = new FlipkartAutomationMain("https://www.flipkart.com/");
        
        //Invoking the Workflows Automation Methods...
        //flipkartMain.searchFeatureAutomation();
        FlipkartAutomationMain.searchFeatureAutomation();
        
        //FlipkartAutomationMain.flipkartLoginAutomation(webApplicationURL); //Login workflow Automation...
        //FlipkartAutomationMain.handlingWindowsAutomation("https://www.naukri.com/");
        //FlipkartAutomationMain.handlingWebPopupsAutomation("https://www.utimf.com/");
        //FlipkartAutomationMain.handlingUDIAIWebPopupsAutomation("https://uidai.gov.in/");
        //FlipkartAutomationMain.handlingDboxesAutomation("http://toolsqa.com/automation-practice-form/");
        //FlipkartAutomationMain.handlingUDIAISearchWorkflowUsingAUIAPI("https://uidai.gov.in/");
        //FlipkartAutomationMain.handlingDADUsingAUIAPI("http://demo.guru99.com/test/drag_drop.html");
    }
}
