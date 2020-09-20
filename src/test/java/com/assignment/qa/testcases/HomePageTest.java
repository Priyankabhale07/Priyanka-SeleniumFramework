package com.assignment.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.assignment.qa.base.TestBase;
import com.assignment.qa.pages.CompaniesPage;
import com.assignment.qa.pages.ContactsPage;
import com.assignment.qa.pages.DealsPage;
import com.assignment.qa.pages.HomePage;
import com.assignment.qa.pages.LoginPage;
import com.assignment.qa.pages.TasksPage;
import com.assignment.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	CompaniesPage companiesPage;
	DealsPage dealsPage;
	TasksPage tasksPage;
	
	

	public HomePageTest() {
		super();
	}

	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser
	
	@BeforeTest
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.loginTest(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Cogmento CRM","Home page title not matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest(){
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest() throws InterruptedException{
		//testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
		boolean flag = contactsPage.verifyContactsLabel();
		if(flag) {
			System.out.println("Navigated on Contact Page");
			Assert.assertTrue(true, "Navigated on Contact Page");
		}else {
			System.out.println("Navigation to contact page is not succesful");
			Assert.assertTrue(false, "Navigation to contact page is not succesful");
		}
		Thread.sleep(5000);
	}
	
	@Test(priority=4)
	public void verifyCompanyLinkTest() throws InterruptedException{
		//testUtil.switchToFrame();
		companiesPage = homePage.clickOnCompanyLink();
		boolean flag = companiesPage.verifyCompanyLabel();
		if(flag) {
			System.out.println("Navigated on Company Page");
			Assert.assertTrue(true, "Navigated on Company Page");
		}else {
			System.out.println("Navigation to Company page is not succesful");
			Assert.assertTrue(false, "Navigation to Company page is not succesful");
		}
		Thread.sleep(5000);
	}
	
	@Test(priority=4)
	public void verifyDealsLinkTest() throws InterruptedException{
		//testUtil.switchToFrame();
		dealsPage = homePage.clickOnDealsLink();
		boolean flag = dealsPage.verifyDealsLabel();
		if(flag) {
			System.out.println("Navigated on Deals Page");
			Assert.assertTrue(true, "Navigated on Deals Page");
		}else {
			System.out.println("Navigation to Deals page is not succesful");
			Assert.assertTrue(false, "Navigation to Deals page is not succesful");
		}
		Thread.sleep(5000);
	}
	
	
	@Test(priority=5)
	public void verifyTaskLinkTest() throws InterruptedException{
		//testUtil.switchToFrame();
		tasksPage = homePage.clickOnTasksLink();
		boolean flag = tasksPage.verifyTaskLabel();
		if(flag) {
			System.out.println("Navigated on Tasks Page");
			Assert.assertTrue(true, "Navigated on Tasks Page");
		}else {
			System.out.println("Navigation to Tasks page is not succesful");
			Assert.assertTrue(false, "Navigation to Tasks page is not succesful");
		}
		Thread.sleep(5000);
	}
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
	
	

}
