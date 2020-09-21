--> This framework is build to demonstrate assignment given by TouchCore Systems Pune on Selenium webdriver with Java and maven as building tool and TestNG framework as reporting/ test framework

--> Insights
Page object Model - Creating dedicated class file for each web page and writing down respective locators from that webpage and releated methods w.r.t. operations performed on that page
Data driven - For some of the test cases, test data is randomly generated and for few test cases its supplied from test data file and used through dataprovider annotation.

--> Framework 
Current framework is hybrid framwork, Combination of Page Object Model(POM)& Test data driven framwork.
As a part of POM,I have created separate class files for each webpage(Example: In this Web application I have Login Page, ContactPage, Companies Page etc. hence I have created respective .java class files for each web page.)
Hence, in those .java class files I have written respective locators from that webpage and releated methods w.r.t. operations performed on that page.
Benefits of having Page object Model is, if there is any change in respective webpage, then we need to enhance that class file only irrespective of anything else in our framework.

Framework is divided into 3 layers - 
-> utility layer  = This layer is useful for creating common utilities used accross framework like reading data from excel, taking screenshot etc
-> Page object layer = This layer is for handling page objects and object repositories
-> test cases layer = This layer is for writing test cases and calling methods for validation which are included in page object

Test Date - 
-> Randomly generated test data
-> Test data passing from excel file

Reporting
Testng reporting is used in this framework and with this basic extent report is also used.

How to Execute - 
-> First Need to clone project from github - https://github.com/Priyankabhale07/Priyanka-SeleniumFramework

-> After cloning repository, open command prompt and navigate to workspace location where repository is placed

-> Run below command ( prerequisite - java 1.8 and maven is installed)


To run CompanyPage tests use below command 9remove quotes before use) --------
'mvn clean test -Dsurefire.suiteXmlFiles=src/main/resources/CompanyPageTest.xml'

or To run HomePage tests use below command --------------------------
'mvn clean test -Dsurefire.suiteXmlFiles=src/main/resources/HomePageTest.xml'

or To run LoginPage tests use below command --------------------------
'mvn clean test -Dsurefire.suiteXmlFiles=src/main/resources/LoginPageTest.xml'

or To run ContactPage tests use below command  ---------------------------
'mvn clean test -Dsurefire.suiteXmlFiles=src/main/resources/ContactPageTest.xml'


Run any command w.r.t. test suite for that respective screen. We can also add all these 4 suites in one masterTestng and execute it for bulk execution.

Explanation for passing xml filename as parameter - 
We have multiple testng xmls so we cannot hardcode any one xml in pom.xml inside mavensurefire plugin so I have parameterized it

Benifits of passing testng.xml name as parameter - 
We can use such setup for creating Jenkins build and in maven job we can easily pass testng.xml filename as parameter from maven goals options in Build section.


--> Major Tools/libraries/dependancies used 
Java 1.8, Selenium 3.14, Chromedriver 85.X, maven, TestNG, maven surefire plugin, apache poi etc


Below Test cases are added in each test class

Company Page - 
1) Verify company Page label
2) Validate company added for set of testdata given from test data sheet
3) Randomly generated test data is passed to test case to validate New Company add functionality
4) Negative Test case -  Verify that company is not added if required field is blank

Contact Page - 
1) Verify Contact Page label
2) Validate contact added for 3 sets of testdata
3) Randomly generated test data is passed to test case to validate contact add functionality

Homepage - 
1) Verify pagetitle of homescreen
2) Verify username of user is displayed
3) Verify Company tab on homescreen
4) Verify Contact tab on homescreen
5) Verify Deals tab on homescreen
6) Verify Task tab on homescreen

Login Page - 
1) Verify Page title 
2)Verify Login is succesful or not

Note- Execution Evidences are placed under Execution Evidences-20Sept folder. Kindly check if needed.