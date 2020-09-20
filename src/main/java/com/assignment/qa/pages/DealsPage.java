package com.assignment.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.assignment.qa.base.TestBase;

public class DealsPage extends TestBase{

	@FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[1]")
	WebElement dealsLabel;
	
	
	// Initializing the Page Objects:
		public DealsPage() {
			PageFactory.initElements(driver, this);
		}
		
		public boolean verifyDealsLabel(){
			return dealsLabel.isDisplayed();
		}
}
