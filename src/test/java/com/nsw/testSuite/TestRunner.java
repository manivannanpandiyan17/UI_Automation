package com.nsw.testSuite;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/main/java/com/nsw/testCases/Scenarios.Feature", glue= {"com.nsw.testPages"}, plugin = { "pretty", "html:src/main/java/com/nsw/reports/cucumber-reports" }, monochrome=true)
public class TestRunner {

}