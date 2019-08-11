package com.nsw.testPages;

import static org.junit.Assert.assertTrue;
import org.junit.Assert;
import com.nsw.libraryFunctions.LibraryFunctions;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Locations extends LibraryFunctions {
	
	public static String locateUsButton = "//div[@class='inline-nav']//a[contains(text(),'Find locations')]";
	public static String locationText = "//input[@id='locatorTextSearch']";
	public static String locationResult ="//button[@class='button button--primary button--xxlarge']";
	public static String validateLocation ="//a[@class='location__title' and contains(text(),'%s')]";
	public static String locationPageHeading = "//nav[@class='breadcrumb']/following::h1[contains(text(),'%s')]";

	// To click on Find Locations button
	@When("^Click on Locate Us button$")
	public void click_on_Locate_Us_button() {
	    // Write code here that turns the phrase above into concrete actions
		try
		{
			click(locateUsButton);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			Assert.fail("Unable to click Locate us button");
		}
	}
	
	// Enter the required Suburb and click Locate button
	@When("^Enter Suburb  \"([^\"]*)\"$")
	public void enter_Suburb(String subUrb) {
		try
		{
			type(locationText,subUrb);
			click(locationResult);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			Assert.fail("Unable to Locate the required suburb");
		}
	}
	
	// To validate the service center name for the selected location
	@Then("^Validate the service centre name  \"([^\"]*)\"$")
	public void validate_the_service_centre_name(String serviceCentre) throws Exception {
		try
		{
			//serviceCentre = readJSONData("serviceCentre");
			click(String.format(validateLocation,serviceCentre));
			
			//To validate the bread crumb
			String[] breadCb = {"Home","Find a location"};
			validateBreadCrumb(breadCb);

			//VerifyPageTitle();
			assertTrue(getBrowserTitle().contains(serviceCentre));
			
			//Validate Page Heading
			verifyElementIsPresent(String.format(locationPageHeading, serviceCentre),serviceCentre);
			
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			Assert.fail("Unable to find the service center for the selected location");
		}
	}
	
	// Close the browser
	@Then("^Close the browser$")
	public void close_the_browser() 
	{
		try
		{
			driver.quit();
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			Assert.fail("Unable to close the browser");
		}
	}


}
