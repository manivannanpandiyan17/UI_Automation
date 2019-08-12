$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/main/java/com/nsw/testCases/Scenarios.Feature");
formatter.feature({
  "name": "NSW service Application",
  "description": "Description : This script will test the location of the service center in the selected suburb",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "To apply for a number plate and search for the required service center in the suburb",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "Launch the NSW application",
  "keyword": "Given "
});
formatter.step({
  "name": "Search for the required text and validate the same \"\u003csearchText\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "Click on Locate Us button",
  "keyword": "And "
});
formatter.step({
  "name": "Enter Suburb  \"\u003csubUrb\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "Validate the service centre name  \"\u003cserviceCentre\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "name": "Close the browser",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "searchText",
        "subUrb",
        "serviceCentre"
      ]
    },
    {
      "cells": [
        "Apply for a number plate",
        "Sydney 2000",
        "Marrickville Service Centre"
      ]
    },
    {
      "cells": [
        "Apply for a number plate",
        "Sydney Domestic Airport 2020",
        "Rockdale Service Centre"
      ]
    }
  ]
});
formatter.scenario({
  "name": "To apply for a number plate and search for the required service center in the suburb",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "Launch the NSW application",
  "keyword": "Given "
});
formatter.match({
  "location": "NSW_Homepage.launch_the_NSW_application()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Search for the required text and validate the same \"Apply for a number plate\"",
  "keyword": "When "
});
formatter.match({
  "location": "Search.search_for_the_required_text_and_validate_the_same(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on Locate Us button",
  "keyword": "And "
});
formatter.match({
  "location": "Locations.click_on_Locate_Us_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Enter Suburb  \"Sydney 2000\"",
  "keyword": "And "
});
formatter.match({
  "location": "Locations.enter_Suburb(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Validate the service centre name  \"Marrickville Service Centre\"",
  "keyword": "Then "
});
formatter.match({
  "location": "Locations.validate_the_service_centre_name(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Close the browser",
  "keyword": "And "
});
formatter.match({
  "location": "Locations.close_the_browser()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "To apply for a number plate and search for the required service center in the suburb",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "Launch the NSW application",
  "keyword": "Given "
});
formatter.match({
  "location": "NSW_Homepage.launch_the_NSW_application()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Search for the required text and validate the same \"Apply for a number plate\"",
  "keyword": "When "
});
formatter.match({
  "location": "Search.search_for_the_required_text_and_validate_the_same(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on Locate Us button",
  "keyword": "And "
});
formatter.match({
  "location": "Locations.click_on_Locate_Us_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Enter Suburb  \"Sydney Domestic Airport 2020\"",
  "keyword": "And "
});
formatter.match({
  "location": "Locations.enter_Suburb(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Validate the service centre name  \"Rockdale Service Centre\"",
  "keyword": "Then "
});
formatter.match({
  "location": "Locations.validate_the_service_centre_name(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Close the browser",
  "keyword": "And "
});
formatter.match({
  "location": "Locations.close_the_browser()"
});
formatter.result({
  "status": "passed"
});
});