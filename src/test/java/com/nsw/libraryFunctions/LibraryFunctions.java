package com.nsw.libraryFunctions;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LibraryFunctions {

	public static WebDriver driver;
	public static String testData;
	public static String browser;
	public static Properties prop;
	public static String driverPath;
	public static String nodeUrl;

	// Reads browser details from the config file, opens the browser and launches the application
	public final void startBrowser() {
		try 
		{		
			readConfigFile();
			if (browser.equalsIgnoreCase("ie"))
			{
				System.setProperty("webdriver.ie.driver","IEDriver.exe");
				driver = new InternetExplorerDriver();
			}
			else if  (browser.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.gecko.driver","geckodriver.exe");
				driver = new FirefoxDriver();
			}
			else if  (browser.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver","chromedriver.exe");
				driver = new ChromeDriver();
			}	
			else if (browser.equalsIgnoreCase("grid"))
			{
				DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				capabilities.setBrowserName("chrome");
				capabilities.setPlatform(Platform.WIN10);
				driver=new RemoteWebDriver(new URL(nodeUrl + "/wd/hub"),capabilities);
			}
			else
			{
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				options.addArguments("--disable-gpu"); 	
				options.addArguments("--window-size=1024,768");
				System.setProperty("webdriver.chrome.driver","chromedriver.exe");
				driver = new ChromeDriver(options);	
			}
			driver.get("https://www.service.nsw.gov.au/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}

	}

	// To verify the format of the locators and correct the same
	public final WebElement getWebElementDisplay(final String locator) throws Exception {
		WebElement returnobj = null;
		try {
			String xpath;
			if (locator.contains("Xpath=") || locator.startsWith("//") || locator.startsWith("(")) {
				xpath = locator.replace("Xpath=", "");
				returnobj = driver.findElement(By.xpath(xpath));
			} else if (locator.contains("id=")) {
				xpath = locator.replace("id=", "");
				returnobj = driver.findElement(By.id(xpath));
			} else if (locator.contains("class=")) {
				xpath = locator.replace("class=", "");
				returnobj = driver.findElement(By.className(xpath));
			} else if (locator.contains("name=")) {
				xpath = locator.replace("name=", "");
				returnobj = driver.findElement(By.name(xpath));
			} else {
				return returnobj;
			}
			if (returnobj.isDisplayed()) {
				return returnobj;
			}
			else 
			{
				return null;
			}

		} 
		catch (Exception e)
		{
			return null;
		}
	}

	// To perform click operation
	public final void click(final String locator) throws Exception {
		try {
			WebElement obj = getWebElementDisplay(locator);
			if (obj == null) {
				throw new Exception();
			} else {
				obj.click();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	// To enter the required text in the text box
	public final void type(final String locator, final String searchText) throws Exception {

		try {
			WebElement obj = getWebElementDisplay(locator);
			obj.sendKeys(searchText);

		} 
		catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	// To validate the bread crumb in the selected page
	public final void validateBreadCrumb(String args[]) throws Exception
	{
		String breadCrumb = "//nav[@class='breadcrumb']/ol/li/a[text()='%s']";
		try {
			int count = args.length;
			for(int i=0;i<count;i++) {
				verifyElementIsPresent(String.format(breadCrumb, args[i]),args[i]);
			}
		}catch (Exception e) {
			throw new Exception();
		}
	}

	// To get the title of the selected page
	public final String getBrowserTitle() throws Exception {
		try {
			return driver.getTitle();
		} catch (Exception e) {
			throw new Exception();
		}
	}

	// To verify if the element is present in the location
	public final void verifyElementIsPresent(final String locator, String msg)throws Exception {

		try {
			waitForElementPresent(locator, 5);
			WebElement obj = getWebElementDisplay(locator);

			if (obj == null) {
				Assert.fail(msg+" element not found");
				throw new Exception();
			}

		} catch (Exception e) {
			throw new Exception();
		}
	}

	// To check for the element present in the location
	public final void waitForElementPresent(final String xpath, final int secs) throws Exception {
		try {
			for (int i = 0; i <= secs; i++) {
				boolean condition = isElementDisplay(xpath);
				if (condition) {
					break;
				}
			}
		} catch (Exception e) {
			throw new Exception();
		}
	}

	// To verify if the element is displayed
	public final boolean isElementDisplay(final String locator) throws Exception {
		try {
			WebElement obj = getWebElementDisplay(locator);
			if (obj == null) {
				return false;
			} else {
				return obj.isDisplayed();
			}

		} catch (Exception e) {
			throw new Exception();
		}
	}

	// To read the data from JSON file
	public String readJSONData(String keyword) throws Exception {
		try
		{

			Reader reader = new
					FileReader("src/test/java/com/nsw/testData/TestData.json"); 
			JSONParser parser	  = new JSONParser(); 
			JSONArray jsonArr = (JSONArray)parser.parse(reader);
			for(Object obj : jsonArr)
			{ 
				JSONObject jo = (JSONObject)obj; 
				testData = (String)jo.get(keyword); 
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new Exception();
		}
		return testData;
	}

	// To read config file for browser related details
	public static void readConfigFile()
	{
		try
		{
			prop = new Properties();
			InputStream input = new FileInputStream("src/test/java/com/nsw/configuration/Config.properties");
			prop.load(input);
			browser = prop.getProperty("browser");
			nodeUrl = prop.getProperty("nodeUrl");			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}    
}
