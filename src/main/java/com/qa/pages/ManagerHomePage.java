package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagerHomePage {
	
	WebDriver driver;
	
	@FindBy(linkText="New Customer")
	private WebElement newCustometLinkWE;
	@FindBy(linkText="Edit Customer")
	private WebElement editCustomerLinkWE;
	@FindBy(linkText="New Account")
	private WebElement newAccountLinkWE;
	@FindBy(linkText="Edit Account")
	private WebElement editAccountLinkWE;
	
	public ManagerHomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public AddCustomerPage clickOnNewCustomerLinkText()
	{
		newCustometLinkWE.click();
		return new AddCustomerPage(driver);
	}
	public EditCustomerPage clickOnEditCustomerLink()
	{
		editCustomerLinkWE.click();
		return new EditCustomerPage(driver);
	}
	public NewAccountPage clickOnNewAccountLinkWE()
	{
		newAccountLinkWE.click();
		return new NewAccountPage(driver);
	}
	public EditAccountPage cliclOnEditAccountLink()
	{
		editAccountLinkWE.click();
		return new EditAccountPage(driver);
	}
}
