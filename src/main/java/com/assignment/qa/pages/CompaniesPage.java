package com.assignment.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.assignment.qa.base.TestBase;

public class CompaniesPage extends TestBase{

	
	@FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[1]")
	WebElement companyLabel;
	
	@FindBy(xpath="//input[@name='name']")
	static
	WebElement name;
	
	@FindBy(xpath="//input[@name='address']")
	static
	WebElement address;
	
	@FindBy(xpath="//input[@name='num_employees']")
	static
	WebElement employeeCount;
	
	@FindBy(xpath="//input[@name='industry']")
	static
	WebElement industryType;
	
	@FindBy(xpath = "//i[@class='save icon']")
	static
	WebElement saveBtn;
	
	@FindBy(xpath="//label[contains(text(),'Company')]")
	WebElement company;
	

	@FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[1]")
	static
	WebElement getName;
	
	
	public CompaniesPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyCompanyLabel(){
		return companyLabel.isDisplayed();
	}
	
	public static  String createNewCompany(String cname, String caddress, String cemployeeCount, String cindustryType) throws InterruptedException{
			
			name.sendKeys(cname);
			address.sendKeys(caddress);
			employeeCount.sendKeys(cemployeeCount);
			industryType.sendKeys(cindustryType);
			saveBtn.click();
			Thread.sleep(3000);
			
			return getName.getText();
			
		}
}
