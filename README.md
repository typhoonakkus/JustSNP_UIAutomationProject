TEST AUTOMATION FRAMEWORK

This project is a test automation framework built using Java, Cucumber (BDD), TestNG, Selenium WebDriver, and Allure Reports.
Page Object Model structure has been adopted in this project.
The framework is also strengthened using the TestNG structure.

Technologies and Libraries Used

 → Java 11+
 → Maven (build management)
 → Selenium WebDriver
 → Cucumber (BDD)
 → TestNG (test suite and parallel execution, annotations, assertions)
 → Allure Reports 
 → WebDriverManager (automatic driver management)

Project Structure
  The framework is organized as follows:
  
  src/test/java      → Step Definitions, Runners, Hooks  
  src/test/resources → Feature files (.feature), Configurations , API Test files (Postman) : functionalTesting.postman_collection , TEST.postman_environment 
  src/main/java      → Core framework classes (Driver, Utilities)  
  pom.xml            → Maven build configuration  
  testng.xml         → Parallel execution setup  

Run Commands

mvn clean test -Dtest=Runner  → Run all tests

"-Dcucumber.filter.tags=@Smoke" → Run tests with a specific tag (e.g., @Smoke).

"-Dbrowser=firefox" → added for browser selection. If not added, the default definition will work.

-DbaseURL=https://test.domain.com → added for specific url. If not added, the default defined url will work.

-DrunMode=grid → Parallel execution using TestNG XML (Grid execution)

Run API test using postman collections with newman
newman run src/test/resources/functionalTesting.postman_collection.json -e src/test/resources/TEST.postman_environment.json --export-environment src/test/resources/TEST.postman_environment.json


Reporting with Allure

  After test execution, Allure results are stored under:
  target/allure-results
  Generate the report:
  mvn allure:report 
  if allure generate report runtime ,open the report using mvn allure:serve
  
This creates the folder:
  target/allure-report
  Open the report in browser (local server):
  allure serve target/allure-results

Info

  DriverManager class allows running tests either locally or on Selenium Grid.  
  Utility/Find.java contains dynamic methods for finding elements (Element, Elements).  
  Utility/Assertion.java includes customized assertion methods built on top of TestNG Assert. 
  Utility/Util.java contains specific action methods (dragandDrop, fileUpload etc.) 
  @Before and @After hooks are configured to run before and after each scenario.  
  Reports are reset and regenerated on every mvn clean execution.
