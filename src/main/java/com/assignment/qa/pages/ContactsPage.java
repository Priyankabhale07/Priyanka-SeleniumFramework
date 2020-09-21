package com.assignment.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.assignment.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[1]")
	WebElement contactsLabel;

	@FindBy(name="first_name")
	WebElement firstName;

	@FindBy(name="last_name")
	WebElement lastName;

	@FindBy(xpath="//label[contains(text(),'Company')]")
	WebElement company;

	@FindBy(xpath = "//i[@class='save icon']")
	WebElement saveBtn;

	@FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[1]")
	WebElement getName;



	// Initializing the Page Objects:
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}


	public boolean verifyContactsLabel(){
		return contactsLabel.isDisplayed();
	}

	public String createNewContact(String title, String ftName, String ltName, String comp) throws InterruptedException{

		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		saveBtn.click();
		Thread.sleep(3000);  // forcefully given this thread to see actions on UI else it will be very quicker
		return getName.getText();

	}




}
