package com.assignment.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.assignment.qa.base.TestBase;

public class TasksPage extends TestBase{

	
	@FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[1]")
	WebElement taskLabel;
	
	public TasksPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyTaskLabel(){
		return taskLabel.isDisplayed();
	}
}
