# UI_Automation
Assessment for UI Automation

Automated the UI using BDD framework (i.e. CUCUMBER) with JAVA

Framework folder structure is under src/main/java

Under com.nsw.configuration, provide the configuration details such as Browser and node details

Supports the following browsers - chrome, firefox, ie, headless and grid

Under com.nsw.libraryFunctions, all selenium related functions are available

Under com.nsw.testCases, Test cases are provided in a Feature file and have used data driven approach to pick the test data from the feature file

Test data can be changed or newly added in the feature file

Under com.nsw.testPages, all application related functions are available in the form of Page object model

Under com.nsw.reports, Test report will be generated in the HTML Format

#Execute test

To execute the test from eclipse, right click on the TestRunner.Java file and run as Junit

To execute in cmd, navigate to the POM file directory and run the command as mvn clean install

Tests will run successfully and reports will be generated in its respective directory

Tests are pushed into git repository and integrated with circle CI to inititate the test after each build
