package testometer.org.flipkartBusinessLayer;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import additionalFeatures.FlipkartAdditionalFeatures;

public class FlipkartAutomationMain {

	// Instance/Object Variables...
	public static String webApplicationURL;
	private static WebDriver newBrowserInstance;

	// Parameterized Constructor...
	public FlipkartAutomationMain(String webApplicationURL) {
		this.webApplicationURL = webApplicationURL;
	} // End of the Constructor...

	
	// User-defined Methods for Automation of Work flows in Flipkart Web App...
	public static void searchFeatureAutomation() throws InterruptedException {

		try {
			// Step 1 : Creating the Browser instance of choice...
			// System.setProperty("webdriver.chrome.driver",
			// "E:\\Online_Trainings\\chromedriver.exe");
			// newBrowserInstance = new ChromeDriver(); //Created the Browser
			// instance...

			System.setProperty("webdriver.gecko.driver", "E:\\Online_Trainings\\geckodriver.exe");
			newBrowserInstance = new FirefoxDriver(); // Created the Browser
														// instance...

			// Step 2 : Launching the Browser and Loading the AUT...Web App...
			newBrowserInstance.get(webApplicationURL);

			// Step 3 : Locating the Web Elements and automating the Flow...

			// Invoking the Additional Method to handle the Login window...
			boolean returnValue = FlipkartAdditionalFeatures.closingLoginWindow(newBrowserInstance);
			if (returnValue) {
				WebElement searchTextBox = newBrowserInstance.findElement(By.className("LM6RPg"));
				searchTextBox.sendKeys("Selenium Text Books"); // Pushing the
																// Search text
																// box value...

				WebElement searchButton = newBrowserInstance.findElement(By.className("vh79eN"));
				searchButton.click(); // Clicking on the the search Button...
			}

			// Waiting Concept..
			Thread.sleep(10000);

		} // End of try...
		catch (NoSuchElementException nsee) {
			System.out.println("OOPS...In Exception Block...");
			nsee.printStackTrace();
		} // End of catch...

		finally {
			// Step 4 : Closing the Instances...
			newBrowserInstance.quit();
		} // End of finally...

		System.out.println("Wow..Success...");
	} // End of the Search Workflow method...

	
	// User-defined Method for Automation of login into Flipkart Web App...
	public static String flipkartLoginAutomation(String webApplicationURL) throws InterruptedException, IOException {

		try {
			// Step 1 : Creating the Browser instance of choice uisng Java IO
			// API for user interactions...
			System.out.println("Please Enter The Browser Name of Your Choice[chrome/ie/ff] :");
			BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
			String browserName = userInput.readLine();

			newBrowserInstance = FlipkartAdditionalFeatures.getBrowserInstance(browserName);

			// Step 2 : Launching the Browser and Loading the AUT...Web App...
			newBrowserInstance.get(webApplicationURL);

			// Unconditional Synchronization - Implicit wait...
			newBrowserInstance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			// Step 3 : Locating the Web Elements and automating the Flow...
			// WebElement loginSignUpText =
			// newBrowserInstance.findElement(By.xpath("/html/body/div[1]/div/header/div[1]/div/div[3]/div[1]/div/a"));
			// loginSignUpText.click();

			WebElement loginTextBox = newBrowserInstance.findElement(By.className("_2zrpKA"));
			loginTextBox.sendKeys("123456789");

			// WebElement pwdTextBox =
			// newBrowserInstance.findElement(By.className("_2zrpKA _3v41xv"));
			WebElement pwdTextBox = newBrowserInstance.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input"));
			pwdTextBox.sendKeys("somepwd");
			// pwdTextBox.sendKeys(FlipkartAdditionalFeatures.getPassword());

			// WebElement loginButton =
			// newBrowserInstance.findElement(By.className("_2AkmmA _1LctnI
			// _7UHT_c"));
			WebElement loginButton = newBrowserInstance
					.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[3]/button"));
			loginButton.click();

		} // End of try...
		catch (NoSuchElementException nsee) {
			System.out.println("OOPS...In Exception Block...");
			nsee.printStackTrace();
		} // End of catch...

		finally {
			// Step 4 : Closing the Instances...
			newBrowserInstance.quit();
		} // End of finally...

		System.out.println("Wow..Success...");
		
		return "Success";
	} // End of the Search Workflow method...

	
	// User-defined Method for Automation of handling Window based Popups Naukri.com Web App...
	public static void handlingWindowsAutomation(String webApplicationURL) throws InterruptedException, IOException {

		try {
			// Step 1 : Creating the Browser instance of choice uisng Java IO
			// API for user interactions...
			System.out.println("Please Enter The Browser Name of Your Choice[chrome/ie/ff] :");
			BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
			String browserName = userInput.readLine();

			newBrowserInstance = FlipkartAdditionalFeatures.getBrowserInstance(browserName);

			// Step 2 : Launching the Browser and Loading the AUT...Web App...
			newBrowserInstance.get(webApplicationURL);

			// Unconditional Synchronization - Implicit wait...
			newBrowserInstance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			// Step 3 : Automating the handling of the Windows popup Flow...
			// Storing the window popups unique id into windowsHandles
			// variable...
			Set<String> windowsHandles = newBrowserInstance.getWindowHandles();
			System.out.println("Total No. Of Windows : " + windowsHandles.size());
			System.out.println(windowsHandles);

			// Looping through the Set to iterate/navigate through the list of
			// handlers..
			for (String allHandles : windowsHandles) {
				// Switching the focus onto the 1st window...
				newBrowserInstance.switchTo().window(allHandles);
				System.out.println(newBrowserInstance.getTitle());

				if (newBrowserInstance.getTitle().equals("Toyo Engineering - Google Chrome"))
					newBrowserInstance.close();

				System.out.println("Child Window Closed....");
			}

		} // End of try...
		catch (NoSuchElementException nsee) {
			System.out.println("OOPS...In Exception Block...");
			nsee.printStackTrace();
		} // End of catch...

		finally {
			// Step 4 : Closing the Instances...
			newBrowserInstance.quit();
		} // End of finally...

		System.out.println("Wow..Successfully Handled the Windows...");
	} // End of the Search Workflow method...

	
	// User-defined Method for Automation of handling Web based Popups utimf.com Web App...
	public static void handlingWebPopupsAutomation(String webApplicationURL) throws InterruptedException, IOException {

		try {
			// Step 1 : Creating the Browser instance of choice uisng Java IO
			// API for user interactions...
			System.out.println("Please Enter The Browser Name of Your Choice[chrome/ie/ff] :");
			BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
			String browserName = userInput.readLine();

			newBrowserInstance = FlipkartAdditionalFeatures.getBrowserInstance(browserName);

			// Step 2 : Launching the Browser and Loading the AUT...Web App...
			newBrowserInstance.get(webApplicationURL);

			// Unconditional Synchronization - Implicit wait...
			newBrowserInstance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			// Step 3 : Automating the handling of the Web based popups Flow...
			WebElement loginButton = newBrowserInstance
					.findElement(By.xpath("//*[@id='fund-1']/div[1]/div/div[1]/div[2]/div"));
			loginButton.click();

			// Focus to be switched onto the Login Popup...
			Alert loginPopupAlert = newBrowserInstance.switchTo().alert();

			// Click on the Ok...button...
			loginPopupAlert.accept();

		} // End of try...
		catch (NoSuchElementException nsee) {
			System.out.println("OOPS...In Exception Block...");
			nsee.printStackTrace();
		} // End of catch...

		finally {
			// Step 4 : Closing the Instances...
			newBrowserInstance.quit();
		} // End of finally...

		System.out.println("Wow..Successfully Handled the Windows...");
	} // End of the Search Workflow method...

	
	// User-defined Method for Automation of handling Web based Popups
	public static void handlingDboxesAutomation(String webApplicationURL) throws InterruptedException, IOException, AWTException {

		try {
			// Step 1 : Creating the Browser instance of choice uisng Java IO API for user interactions...
			System.out.println("Please Enter The Browser Name of Your Choice[chrome/ie/ff] :");
			BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
			String browserName = userInput.readLine();

			newBrowserInstance = FlipkartAdditionalFeatures.getBrowserInstance(browserName);

			// Step 2 : Launching the Browser and Loading the AUT...Web App...
			newBrowserInstance.get(webApplicationURL);

			// Unconditional Synchronization - Implicit wait...
			newBrowserInstance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			// Step 3 : Automating the handling of the Web based popups Flow...
			WebElement chooseFileButton = newBrowserInstance.findElement(By.cssSelector("input#photo.input-file"));

			JavascriptExecutor executor = (JavascriptExecutor) newBrowserInstance;
			executor.executeScript("arguments[0].click();", chooseFileButton);

			// Handling of the Dialog box using java.awt.Robot class..
			Robot openDBox = new Robot();

			openDBox.keyPress(KeyEvent.VK_S);
			openDBox.keyRelease(KeyEvent.VK_S);
			openDBox.keyPress(KeyEvent.VK_R);
			openDBox.keyRelease(KeyEvent.VK_R);
			openDBox.keyPress(KeyEvent.VK_C);
			openDBox.keyRelease(KeyEvent.VK_C);

			// Clicking the Open button...
			openDBox.keyPress(KeyEvent.VK_ENTER);
			openDBox.keyRelease(KeyEvent.VK_ENTER);

			Thread.sleep(10000);
			System.out.println("Done....");

		} // End of try...
		catch (NoSuchElementException nsee) {
			System.out.println("OOPS...In Exception Block...");
			nsee.printStackTrace();
		} // End of catch...

		finally {
			// Step 4 : Closing the Instances...
			newBrowserInstance.quit();
		} // End of finally...

		System.out.println("Wow..Successfully Handled the Windows...");
	} // End of the Search Workflow method...

	
	// User-defined Method for Automation of handling Web based Popups utimf.com Web App...
	public static void handlingUDIAIWebPopupsAutomation(String webApplicationURL)
			throws InterruptedException, IOException {

		try {
			// Step 1 : Creating the Browser instance of choice uisng Java IO
			// API for user interactions...
			System.out.println("Please Enter The Browser Name of Your Choice[chrome/ie/ff] :");
			BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
			String browserName = userInput.readLine();

			newBrowserInstance = FlipkartAdditionalFeatures.getBrowserInstance(browserName);

			// Step 2 : Launching the Browser and Loading the AUT...Web App...
			newBrowserInstance.get(webApplicationURL);

			// Unconditional Synchronization - Implicit wait...
			newBrowserInstance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			// Step 3 : Automating the handling of the Web based popups Flow...
			WebElement resourceLinkText = newBrowserInstance.findElement(By.cssSelector("a.item-108.deeper.parent.mega-item-a.dropTrigger"));
			resourceLinkText.click();

			WebElement authenticationLinkText = newBrowserInstance.findElement(By.xpath("//*[@id='main245']/a"));
			authenticationLinkText.click();

			WebElement biometricLinkText = newBrowserInstance.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div/div[2]/div/p[3]/span/a"));
			biometricLinkText.click();

			// Business Logic for Handling Alert popup...
			Alert biometericAlert = newBrowserInstance.switchTo().alert(); // Switching
																			// the
																			// focus..

			Thread.sleep(20000);
			biometericAlert.accept();

		} // End of try...
		catch (NoSuchElementException nsee) {
			System.out.println("OOPS...In Exception Block...");
			nsee.printStackTrace();
		} // End of catch...

		finally {
			// Step 4 : Closing the Instances...
			newBrowserInstance.quit();
		} // End of finally...

		System.out.println("Wow..Successfully Handled the Windows...");
	} // End of the Search Workflow method...
	
	
	// User-defined Method for Automation of handling Web based Popups utimf.com Web App...
	public static void handlingUDIAISearchWorkflowUsingAUIAPI(String webApplicationURL)
				throws InterruptedException, IOException {

			try {
				// Step 1 : Creating the Browser instance of choice uisng Java IO API for user interactions...
				System.out.println("Please Enter The Browser Name of Your Choice[chrome/ie/ff] :");
				BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
				String browserName = userInput.readLine();

				newBrowserInstance = FlipkartAdditionalFeatures.getBrowserInstance(browserName);

				// Step 2 : Launching the Browser and Loading the AUT...Web App...
				newBrowserInstance.get(webApplicationURL);

				// Unconditional Synchronization - Implicit wait...
				newBrowserInstance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				// Step 3 : Automating the handling of the Web based popups Flow using Actions class...
				WebElement searchButton = newBrowserInstance.findElement(By.className("searchBtn"));
				WebElement searchTextBox = newBrowserInstance.findElement(By.className("LM6RPg"));
				WebElement goButton = newBrowserInstance.findElement(By.xpath("//*[@id='mod-searchform1081']/div/button"));
				
				//Using the Adv. User Interactions API...
				Actions newActions = new Actions(newBrowserInstance);
				
				Action newAction = newActions.moveToElement(searchButton)
						  					 .click(searchButton)
						  					 .moveToElement(searchTextBox)
						  					 .sendKeys("Aadhar Centres")
						  					 .moveToElement(goButton)
						  					 .click(goButton)
						  					 .build();
				newAction.perform();//Actual execution of all above events as a single event...
				
				// Business Logic for Handling Alert popup...
				Alert biometericAlert = newBrowserInstance.switchTo().alert(); // Switching the focus..

				Thread.sleep(20000);
				biometericAlert.accept();

			} // End of try...
			catch (NoSuchElementException nsee) {
				System.out.println("OOPS...In Exception Block...");
				nsee.printStackTrace();
			} // End of catch...

			finally {
				// Step 4 : Closing the Instances...
				newBrowserInstance.quit();
			} // End of finally...

			System.out.println("Wow..Successfully Handled the Windows...");
		} // End of the Search Workflow method...
	
	
	// User-defined Method for Automation of handling Web based Popups utimf.com Web App...
	public static void handlingDADUsingAUIAPI(String webApplicationURL)
					throws InterruptedException, IOException {

				try {
					// Step 1 : Creating the Browser instance of choice uisng Java IO API for user interactions...
					System.out.println("Please Enter The Browser Name of Your Choice[chrome/ie/ff] :");
					BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
					String browserName = userInput.readLine();

					newBrowserInstance = FlipkartAdditionalFeatures.getBrowserInstance(browserName);

					// Step 2 : Launching the Browser and Loading the AUT...Web App...
					newBrowserInstance.get(webApplicationURL);

					// Unconditional Synchronization - Implicit wait...
					newBrowserInstance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

					// Step 3 : Automating the handling of the DAD Flow using Actions class...
					WebElement dragableElement = newBrowserInstance.findElement(By.xpath("//*[@id='fourth']/a"));
					WebElement dropableElement = newBrowserInstance.findElement(By.xpath("//*[@id='amt7']/li"));
					
					//Using the Adv. User Interactions API...
					Actions newActions = new Actions(newBrowserInstance);
					
					Action newAction = newActions.dragAndDrop(dragableElement, dropableElement)
							  					 .build();
					newAction.perform();//Actual execution of all above events as a single event...
					
					Thread.sleep(20000);

				} // End of try...
				catch (NoSuchElementException nsee) {
					System.out.println("OOPS...In Exception Block...");
					nsee.printStackTrace();
				} // End of catch...

				finally {
					// Step 4 : Closing the Instances...
					newBrowserInstance.quit();
				} // End of finally...

				System.out.println("Wow..Successfully Handled the DAD...");
			} // End of the Search Workflow method...
}
