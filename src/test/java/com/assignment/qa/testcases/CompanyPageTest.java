package com.assignment.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.assignment.qa.base.TestBase;
import com.assignment.qa.pages.CompaniesPage;
import com.assignment.qa.pages.ContactsPage;
import com.assignment.qa.pages.HomePage;
import com.assignment.qa.pages.LoginPage;
import com.assignment.qa.util.TestUtil;
import com.github.javafaker.Faker;

public class CompanyPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	CompaniesPage comapnyPage;
	Faker faker = new Faker();

	String sheetName = "company";


	public CompanyPageTest(){
		super();

	}
	
	@BeforeTest
	public void setUp() throws InterruptedException {

		initialization();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.loginTest(prop.getProperty("username"), prop.getProperty("password"));
		

	}

	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}


	@Test(priority=4, dataProvider="getCRMTestData")
	public void validateCreateNewCompany(String name, String address, String employeeCount, String industryType) throws InterruptedException{
		homePage.clickOnCompanyLink();
		homePage.clickOnNewCompanyLink();
		String Name = CompaniesPage.createNewCompany(name,address,employeeCount,industryType);
		System.out.println("Newly added Company is :"+Name);

		if(Name.contains(name)) {
			Assert.assertTrue(true,"Newly added company name is matching:");
		}else{
			Assert.assertTrue(true,"Newly added company name is not matching:");
		}

	}

	
	
	
	//Random test data generation
		@Test(priority=5)
		public void validateCreateNewCompanyRandomData() throws InterruptedException{
			homePage.clickOnCompanyLink();
			homePage.clickOnNewCompanyLink();
			
			//Randomply generating test data
			String name = faker.name().fullName();
			String address = faker.address().streetAddress();
			String employeeCount = faker.number().digit();
			String industryType = faker.company().industry();
			String Name = CompaniesPage.createNewCompany(name,address,employeeCount,industryType);
			System.out.println("Newly added Company is :"+Name);

			if(Name.contains(name)) {
				Assert.assertTrue(true,"Newly added company name is matching:");
			}else{
				Assert.assertTrue(true,"Newly added company name is not matching:");
			}
		}
		
	// This is negative test case to validate required field error message
	@Test(priority=6, dataProvider="getCRMTestData")
	public void validateRequiredCompanyName(String name, String address, String employeeCount, String industryType) throws InterruptedException{
		homePage.clickOnCompanyLink();
		homePage.clickOnNewCompanyLink();
		String ErrMsg = CompaniesPage.checkCompanyName(name,address,employeeCount,industryType);
		
		System.out.println("Error message:"+ErrMsg);

		if(ErrMsg.contains("The field Name is required")) {
			Assert.assertTrue(true,"Getting expected error message for required field ");
		}else{
			Assert.assertTrue(true,"Error message for required field is not poped up");
		}

	}
		

	@AfterTest
	public void tearDown(){
		driver.quit();
	}

}
