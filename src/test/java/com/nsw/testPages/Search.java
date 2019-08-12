package com.nsw.testPages;

import static org.junit.Assert.assertTrue;
import org.junit.Assert;
import com.nsw.libraryFunctions.LibraryFunctions;
import cucumber.api.java.en.When;

public class Search extends LibraryFunctions{

	public static String searchTextbox = "//input[@class='form__text form--large']";
	public static String searchButton = "//div[@id='homeAutosuggest']/following::button[@class='button button--primary']";
	public static String searchResult = "//a[text()='%s']";
	public static String searchPageHeading = "//nav[@class='breadcrumb']/following::h1[contains(text(),'%s')]";

	// To enter the required text in the search text box and validate the same 
	@When("^Search for the required text and validate the same \"([^\"]*)\"$")
	public void search_for_the_required_text_and_validate_the_same(String searchText){		
		try
		{	
			type(searchTextbox,searchText);
			click(searchButton);
			click(String.format(searchResult, searchText));
			String[] breadCb = {"Home","Browse services","Driving and transport","Number plates"};
			validateBreadCrumb(breadCb);
			assertTrue(getBrowserTitle().contains(searchText));
			verifyElementIsPresent(String.format(searchPageHeading, searchText),searchText);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			Assert.fail("Unable to search the text and validate the same");
		}
	}
}
