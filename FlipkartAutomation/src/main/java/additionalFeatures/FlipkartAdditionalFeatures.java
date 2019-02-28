package additionalFeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

public class FlipkartAdditionalFeatures {
	
	//User defined methods to handle additional web components...
	public static boolean closingLoginWindow(WebDriver oldBrowserInstance) {
	
		System.out.println("In the Window Handling Method...");
		
		//Step 1 : Logic for closing the login window...
		//WebElement closeButton = oldBrowserInstance.findElement(By.className("_2AkmmA _29YdH8"));
		WebElement closeButton = oldBrowserInstance.findElement(By.xpath("/html/body/div[2]/div/div/button"));
		closeButton.click();
		
		return true;
	}

	public static WebDriver getBrowserInstance(String browserName) {
		
		// TODO Auto-generated method stub
		if(browserName.equals("ff")) {
			System.setProperty("webdriver.gecko.driver","E:\\Online_Trainings\\Selenium_Sessions\\WebDriverExe\\geckodriver.exe");
			return new FirefoxDriver();
		} else if(browserName.equals("ie")) {
			System.setProperty("webdriver.ie.driver","E:\\Online_Trainings\\Selenium_Sessions\\WebDriverExe\\IEDriverServer.exe");
			return new InternetExplorerDriver();
		} else if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","E:\\Online_Trainings\\Selenium_Sessions\\WebDriverExe\\chromedriver.exe");
			return new ChromeDriver();
		} else if(browserName.equals("opera")) {
			//System.setProperty()
			return new OperaDriver();
		} else if(browserName.equals("safari")) {
			return new SafariDriver();
		} else {
			return null;
		}
	} //Closing of the Method...

	public static String getPassword() {
		return "dummyvalue";
	}
} //Closing of the Class...
