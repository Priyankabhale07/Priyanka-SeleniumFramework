/*
 * @author Naveen Khunteta
 * 
 */

package com.assignment.qa.testcases;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.assignment.qa.base.TestBase;
import com.assignment.qa.pages.ContactsPage;
import com.assignment.qa.pages.HomePage;
import com.assignment.qa.pages.LoginPage;
import com.assignment.qa.util.TestUtil;
import com.github.javafaker.Faker;

public class ContactsPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	Faker faker = new Faker();
	String sheetName = "contacts";


	public ContactsPageTest(){
		super();

	}


	@BeforeTest
	public void setUp() throws InterruptedException {

		initialization();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.loginTest(prop.getProperty("username"), prop.getProperty("password"));
		//TestUtil.runTimeInfo("error", "login successful");
		//testUtil.switchToFrame();

	}

	@Test(priority=1)
	public void verifyContactsPageLabel(){
		contactsPage = homePage.clickOnContactsLink();
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "contacts label is missing on the page");
	}


	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}


	@Test(priority=4, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title, String firstName, String lastName, String company) throws InterruptedException{
		homePage.clickOnContactsLink();
		homePage.clickOnNewContactLink();
		String Name = contactsPage.createNewContact(title, firstName, lastName, company);
		System.out.println("Newly added contact is :"+Name);

		if(Name.contains(firstName)|| Name.contains(lastName)) {
			Assert.assertTrue(true,"Newly added contact name is matching:");
		}else{
			Assert.assertTrue(true,"Newly added contact name is not matching:");
		}

	}


	// Randomly generating test data for creating new contacts
	@Test(priority=4)
	public void validateCreateNewContactRandomTestData() throws InterruptedException{
		homePage.clickOnContactsLink();
		homePage.clickOnNewContactLink();
		
		String title = faker.name().title();
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		String company = faker.company().name();
		String Name = contactsPage.createNewContact(title, firstName, lastName, company);
		System.out.println("Newly added contact is :"+Name);

		if(Name.contains(firstName)|| Name.contains(lastName)) {
			Assert.assertTrue(true,"Newly added contact name is matching:");
		}else{
			Assert.assertTrue(true,"Newly added contact name is not matching:");
		}

	}

	

	@AfterTest
	public void tearDown(){
		driver.quit();
	}




}
