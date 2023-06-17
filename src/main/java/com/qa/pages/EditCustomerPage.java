package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage {
	
	WebDriver driver;
	
	@FindBy(name="cusid")
	private WebElement customerIdWE;
	@FindBy(id="message14")
	private WebElement customerErrorMessageWE;
	@FindBy(name="AccSubmit")
	private WebElement accountSubmittBtnWE;
	
	
	EditCustomerPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement customerIdWE()
	{
		return customerIdWE;
	}
	public WebElement customerErrorMsg()
	{
		return customerErrorMessageWE;
	}
	public void clickOnAccountSubmittBtn()
	{
		accountSubmittBtnWE.click();
	}

}
