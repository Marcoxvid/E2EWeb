# E2EWeb
Example of web testing of reading a Json file into an array and validating the data

# Project structure
| Src
      |Main
              |Java
                  |Pageobjects
                                  GuidePage.java
                                  HomePage.java
                                  Locators.java
                                  PhotosPage.java
      
                  |Utils
                                  WebDriverUtils.java

    |Test 
            |Java
                  |runners
                                  TestRunner.java
                  |stepdefinitions
                                  TestSteps.java
                  |Resources
                                  |Features
                                            TestFeature.feature
                  
            
# To run in a CI pipelineProject structure

Configure the environment variable in your pipeline, defining the name of the driver you want to use.
Example:
env:
  DRIVER: "chrome" # or "firefox"

Modify the setUp() method in the TestSteps.java file to read the environment variable and use its value when initializing the driver.

Example:
String driverType = System.getenv("DRIVER");
