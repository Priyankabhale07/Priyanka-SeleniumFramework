package com.assignment.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.assignment.qa.base.TestBase;

public class LoginPage extends TestBase{

	//Page Factory - OR:
	@FindBy(name="email")
	WebElement username;


	@FindBy(name="password")
	WebElement password;

	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement loginBtn;

	@FindBy(xpath="//a[@href='/home']")
	WebElement homeBtn;


	@FindBy(xpath="//a[@href='https://ui.freecrm.com']")
	WebElement LogIN;


	//Initializing  Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
 
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}


	public boolean login(String uname, String pword){
		LogIN.click();
		username.sendKeys(uname);
		password.sendKeys(pword);
		loginBtn.click(); 
		boolean homeFlag = homeBtn.isDisplayed();
		return homeFlag  ;
	}

	public HomePage loginTest(String un, String pwd){
		LogIN.click();
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click(); 
		return new HomePage();
	}

}
