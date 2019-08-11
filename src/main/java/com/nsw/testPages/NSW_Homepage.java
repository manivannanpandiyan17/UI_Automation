package com.nsw.testPages;

import org.junit.Assert;
import com.nsw.libraryFunctions.LibraryFunctions;
import cucumber.api.java.en.Given;

public class NSW_Homepage extends LibraryFunctions {

	// To open the browser and launch the application
	@Given("^Launch the NSW application$")
	public void launch_the_NSW_application() {
		try
		{
			// Initiate the browser and launch the application
			startBrowser();
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			Assert.fail("Unable to launch the application");
		}
	}
}