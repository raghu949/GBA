package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewAccountPage {
	
	WebDriver driver;
	
	@FindBy(name="cusid")
	private WebElement customerIdWE;
	@FindBy(name="selaccount")
	private WebElement selectAccountWE;
	@FindBy(name="inideposit")
	private WebElement intialDepositWE;
	@FindBy(name="button2")
	private WebElement newAccountSubmittBtnWE;
	@FindBy(id="message14")
	private WebElement customerIdErrorMsgWE;
	@FindBy(id="message19")
	private WebElement intialDepositErrorMsgWE;
	
	
	
	NewAccountPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement customerIdWE()
	{
		return customerIdWE;
	}
	public WebElement selectAccountWE()
	{
		return selectAccountWE;
	}
	public WebElement intialDepositWE()
	{
		return intialDepositWE;
	}
	public void clickOnSubmittBtn()
	{
		newAccountSubmittBtnWE.click();;
	}
	public WebElement customerIdErrorMsgWE()
	{
		return customerIdErrorMsgWE;
	}
	public WebElement intialDepositErrorMsgWE()
	{
		return intialDepositErrorMsgWE;
	}
}
