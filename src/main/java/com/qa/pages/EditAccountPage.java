package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditAccountPage {
	
	WebDriver driver;
	
	@FindBy(name="accountno")
	private WebElement accountNoWE;
	@FindBy(id="message2")
	private WebElement accountNoErrorMessageWE;
	@FindBy(name="AccSubmit")
	private WebElement accountSubmittBtnWE;
	
	
	EditAccountPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement accountNoFun()
	{
		return accountNoWE;
	}
	public WebElement accountNoErrorMsg()
	{
		return accountNoErrorMessageWE;
	}
	public void clickOnAccountSubmittBtn()
	{
		accountSubmittBtnWE.click();
	}

}
