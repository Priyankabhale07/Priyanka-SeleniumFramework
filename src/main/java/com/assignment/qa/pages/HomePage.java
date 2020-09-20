package com.assignment.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.assignment.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//span[contains(text(), 'Priyanka Bhale')]")
	@CacheLookup
	WebElement userNameLabel;

	@FindBy(xpath = "//span[contains(text(),'Contacts')]")
	WebElement contactsLink;

	@FindBy(xpath = "//a[@href='/contacts/new']")
	WebElement newContactLink;

	@FindBy(xpath = "//span[contains(text(),'Companies')]")
	WebElement companyLink;

	@FindBy(xpath = "//a[@href='/companies/new']")
	WebElement newCompanyLink;


	@FindBy(xpath = "//span[contains(text(),'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath = "//span[contains(text(),'Tasks')]")
	WebElement tasksLink;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle(){
		return driver.getTitle();
	}


	public boolean verifyCorrectUserName(){
		return userNameLabel.isDisplayed();
	}

	public ContactsPage clickOnContactsLink(){
		contactsLink.click();
		return new ContactsPage();
	}


	public CompaniesPage clickOnCompanyLink(){
		companyLink.click();
		return new CompaniesPage();
	}

	public DealsPage clickOnDealsLink(){
		dealsLink.click();
		return new DealsPage();
	}

	public TasksPage clickOnTasksLink(){
		tasksLink.click();
		return new TasksPage();
	}

	public void clickOnNewContactLink(){
		//	Actions action = new Actions(driver);
		//	action.moveToElement(contactsLink).build().perform();
		newContactLink.click();

	}

	public void clickOnNewCompanyLink(){
		//	Actions action = new Actions(driver);
		//	action.moveToElement(contactsLink).build().perform();
		driver.navigate().refresh();
		newCompanyLink.click();

	}







}
