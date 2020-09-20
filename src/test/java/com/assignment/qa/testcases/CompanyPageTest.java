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

public class CompanyPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	CompaniesPage comapnyPage;

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



	@AfterTest
	public void tearDown(){
		driver.quit();
	}

}
