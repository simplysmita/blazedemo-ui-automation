# This Test Automation Framework is created using Java + Selenium Web Driver + TestNG.

Purpose:
---------------
This is the automation suite for Blazedemo UI.

|   Scenarios                   |   Manual  |   Automated   |  
|  -----------------------      |  ---------|   ---------   |
|Accessing blazedemo site       |   x       |       x       |
|Title Verification             |   x       |       x       |
|HyperLink Verification         |   x       |       x       |
|Verification of Departure header above departure dropdown    |   x       |               |
|Verification of Destination header above destination dropdown    |   x       |               |
|Find Flights                   |   x       |       x       |
|Choose Flights                 |   x       |       x       |
|Alignment of Flight details table in Reserve page    |   x       |               | 
|Verify Departs & Arrival City  |   x       |       x       |
|Navigate back to Find Fights   |   x       |       x       |
|Alignment of fields in Purchase Flight page         |   x       |               | 
|Remember Me checkBox           |   x       |       x       |
|Purchase Flight                |   x       |       x       |
|ID confirmation in Confirmation page|   x       |       x       |

[x]-denotes can be validated.

Scenarios not covered:
----------------------

* Verification of Departure and destination City headers is not covered. They are not mentioned as label of the inputs
  fields rather it is a separate header element. So, we are unable to establish a link between the header text and input
  field.
* Alignment of Web elements is not covered. It will slow down the execution process, the maintenance and update of
  alignment dimension on regular basis become too much of an overhead.
* Assertion of Flight details in Purchase Flight is not covered. The purchase Flights screen has static information
  which is not updating.
* Negative scenarios are not covered as I am able to create a booking even with invalid information. e.g:
  With Invalid Credit Card Number With Credit Card Year in Past Missing Passenger details etc.

Prerequisites:
---------------

* Java jdk-1.8 or higher
* Apache Maven 3 or higher
* IDE(Eclipse or Intellij) With Java 8 or higher
* ChromeDriver, Please check the version of your Chrome browser and download the corresponding version of ChromeDriver
  from https://chromedriver.chromium.org/downloads

Execution From CommandLine:
---------------------------

* Clone the repository.
* Please copy and paste the chrome driver to src/test/resources folder in the project.
* Open CommandPrompt, Navigate to project root directory.
* run the command "**mvn clean verify**"
* The test results and ConfirmationId can be verified in the logs.

Execution From IDE:
---------------------------

* Clone the repository to your local workspace.
* Please copy and paste the chrome driver to src/test/resources folder in the project.
* Run the Maven command "**clean verify**"
* Monitor the logs for test results and ConfirmationId