Feature: NSW service Application
Description : This script will test the location of the service center in the selected suburb

Scenario Outline: To apply for a number plate and search for the required service center in the suburb
Given Launch the NSW application
When Search for the required text and validate the same "<searchText>"
And Click on Locate Us button
And Enter Suburb  "<subUrb>"
Then Validate the service centre name  "<serviceCentre>"
And Close the browser
Examples:
	| searchText							 | subUrb                       |  serviceCentre                |
	| Apply for a number plate | Sydney 2000									|  Marrickville Service Centre  |
	| Apply for a number plate | Sydney Domestic Airport 2020 |  Rockdale Service Centre      |