# TEST AUTOMATION FRAMEWORK

This project is a test automation framework built using Java, Cucumber (BDD), TestNG, Selenium WebDriver, and Allure Reports.
Page Object Model structure has been adopted in this project.
The framework is also strengthened using the TestNG structure.

## _Technologies and Libraries Used_

→ IDE - Intellij Download Intellij here : [IntelliJ IDEA](https://www.jetbrains.com/idea/download/)
→ Java jdk 17 download : [Java SE 17 Downloads](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
→ Maven (build management) - With surefire plugin
→ Selenium WebDriver (mvn dependency)
→ Cucumber (BDD) (mvn dependency)
→ TestNG (test suite and parallel execution, annotations, assertions) (mvn dependency)
→ Allure (Report) 
  Download Allure from the [Allure Releases page](https://github.com/allure-framework/allure2/releases).
→ WebDriverManager (automatic driver management) (mvn dependency)
→ API Test Tool Postman using Newman : 
    Download Postman here: [Postman Download](https://www.postman.com/downloads/)
    For using Newman need to Donwload NodeJs here: [NodeJs Download](https://nodejs.org/en/download/)
    npm install -g newman [CLI] 
  After installation, open Postman and import:
   functionalTesting.postman_collection.json
   TEST.postman_environment.json
 

## _Project Structure_
 **The framework is organized as follows**
 
 * src/test/java      → Base, Pages, Step Definitions, Runner, Hooks, Utility
 * src/test/resources → Feature files (.feature), Configurations , API Test files (Postman) : functionalTesting.postman_collection , TEST.postman_environment 
 * src/main/java      → Core framework classes (Driver, Utilities)  
 * pom.xml            → Maven build configuration  
 * testng.xml         → Parallel execution setup  

## _Run Commands_

* mvn clean test -Dtest=Runner  → Run all tests

* "-Dcucumber.filter.tags=@Smoke" → Run tests with a specific tag (e.g., @Smoke).

* "-Dbrowser=firefox" → added for browser selection. If not added, the default definition will work.

* -DbaseURL=https://test.domain.com → added for specific url. If not added, the default defined url will work.

* -DrunMode=grid → Parallel execution using TestNG XML (Grid execution)

* Run API Test : postman collections and postman environment files using newman
 run command:
 newman run src/test/resources/functionalTesting.postman_collection.json -e src/test/resources/TEST.postman_environment.json --export-environment src/test/resources/TEST.postman_environment.json


## _Reporting with Allure_

 * After test execution, Allure results are stored under: target/allure-results 
 * Generate the report:  mvn allure:report 
 * This creates the folder: target/allure-report
 * If allure generate report runtime ,open the report using mvn allure:serve    
 * Open the report in browser (local server): allure serve target/allure-results

## Info:
 DriverManager class allows running tests either locally or on Selenium Grid.  
 Utility/Find.java contains dynamic methods for finding elements (Element, Elements).  
 Utility/Assertion.java includes customized assertion methods built on top of TestNG Assert. 
 Utility/Util.java contains custom and specific action methods (click, sendKeys, dragandDrop, fileUpload etc.) 
 @Before and @After hooks are configured to run before and after each scenario.  
 Reports are reset and regenerated on every mvn clean execution.

 ***************************************************************************
 ---
# Mobile Automation Strategy

## 1.Objective

The objective of this test plan is to validate the core functionalities of the mobile e-commerce application through automation.

---   

## 2.Framework and Tool Selection

In this project we will use **Appium** server for both Android and IOS App.
We can build frameworks using many different languages ​​using Appium. However, we will build our framework in Java.
Appium (Java + TestNG + Allure + CI/CD Integration).
**Advantage of Java and Appium**
* To ensure compatibility with our web ui framework
* Avoid the effort of building a new one from scratch
* This will ensure easy maintenance and has a large comminity network
* With Appium, we can use the same Page Object Model and test scenarios for both platforms, reducing duplicated efforts.

---

## 3.Prioritized User Scenarios for Automation

The focus will be on high-impact user journeys that are critical for customer experience and business funcionalities. 

1. **Login with Biometrics (Fingerprint/FaceID)**  
  Validate that users can securely log in using biometrics on supported devices.  

2. **Product Search & Filter**  
  - Enter a keyword in the search bar.  
  - Apply category filters and sorting options.  
  - Verify relevant products are displayed correctly.  

3. **Add to Cart & Checkout**  
  - Select a product
   - add it to the cart
   - remove from the cart.  
  - Proceed to checkout and complete a purchase with a valid payment method.  
  - Confirm order success screen is displayed.  

4. **Push Notification Verification**  
  - Trigger a promotional or order update notification.  
  - Verify notification is received and redirects user to the correct screen.  

5. **Order Tracking**  
  - Access **My Orders** section.  
  - Select a recent order and verify status updates (e.g., Shipped, Out for Delivery, Delivered).  

---
         
## 5. Test Deliverables
- Automated scripts for prioritized scenarios.  
- Execution reports (Allure/ExtentReports).  
- Defect logs in Jira.

 
                                                  
