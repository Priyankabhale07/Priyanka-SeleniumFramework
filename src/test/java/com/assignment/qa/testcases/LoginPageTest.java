package com.assignment.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.assignment.qa.base.TestBase;
import com.assignment.qa.pages.HomePage;
import com.assignment.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeTest
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Free CRM #1 cloud software for any business large or small");
	}
	
	
	@Test(priority=2)
	public void loginTest(){
		boolean loginFlag = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		if(loginFlag) {
			System.out.println("Login Successful");
			Assert.assertTrue(true, "Login Success");
		}else {
			System.out.println("Login Unsuccessful");
			Assert.assertTrue(false, "Login Unsuccess");

		}
	}
	
	
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
	
	
	
	

}
