package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@name=\"name\"]")
	private WebElement customerNameWE;
	@FindBy(id="message")
	private WebElement customerErrorMessageWE;
	@FindBy(name="addr")
	private WebElement addressWE;
	@FindBy(id="message3")
	private WebElement addressErrorMsgWE;
	@FindBy(name="city")
	private WebElement cityWE;
	@FindBy(id="message4")
	private WebElement cityErrorMsgWE;
	@FindBy(name="state")
	private WebElement stateWE;
	@FindBy(id="message5")
	private WebElement stateWarnMessageWE;
	@FindBy(name="pinno")
	private WebElement pinnoWE;
	@FindBy(id="message6")
	private WebElement pinnoErrorMsgWE;
	@FindBy(name="telephoneno")
	private WebElement telephoneWE;
	@FindBy(id="message7")
	private WebElement telephoneErrorMsgWE;
	@FindBy(name="emailid")
	private WebElement emailidWE;
	@FindBy(id="message9")
	private WebElement emailidErrorWE;
	@FindBy(xpath="//td[text()=\"Customer Name\"]")
	private WebElement CustomerNameTextWE;
	@FindBy(xpath="//td[text()=\"Gender\"]")
	private WebElement GenderTextWE;
	@FindBy(xpath="//td[text()=\"Date of Birth\"]")
	private WebElement DateOfBirthTextWE;
	@FindBy(xpath="//td[text()=\"Address\"]")
	private WebElement AddressTextWE;	
	@FindBy(xpath="//td[text()=\"City\"]")
	private WebElement CityTextWE;
	@FindBy(xpath="//td[text()=\"State\"]")
	private WebElement StateTextWE;
	@FindBy(xpath="//td[text()=\"PIN\"]")
	private WebElement PINTextWE;
	@FindBy(xpath="//td[text()=\"Mobile Number\"]")
	private WebElement TelephoneNumberTextWE;
	@FindBy(xpath="//td[text()=\"E-mail\"]")
	private WebElement EmailTextWE;
	@FindBy(name="rad1")
	private WebElement genderWE;
	@FindBy(id="dob")
	private WebElement dobWE;
	@FindBy(name="sub")
	private WebElement btnSubmit;
	@FindBy(name="password")
	private WebElement passwordWE;
	
	
	
	public AddCustomerPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement customerNameWE()
	{
		return customerNameWE;
	}
	public WebElement customerErrorMessageWE()
	{
		return customerErrorMessageWE;
	}
	/*public String readErrorMessageFromPassedWebElement(WebElement ele)
	{
		String strErrorMessage=ele.getText();
		return strErrorMessage;
	}*/
	public WebElement addressFieldWE()
	{
		return addressWE;
	}
	public WebElement cityFieldWE()
	{
		return cityWE;
	}
	public WebElement cityFieldErrorWE()
	{
		return cityErrorMsgWE;
	}
	public WebElement stateFieldWE()
	{
		return stateWE;
	}
	public WebElement stateFieldErrorWE()
	{
		return stateWarnMessageWE;
	}
	public WebElement pinnoWE()
	{
		return pinnoWE;
	}
	public WebElement pinnoErrorWE()
	{
		return pinnoErrorMsgWE;
	}
	public WebElement telephoneWE()
	{
		return telephoneWE;
	}
	public WebElement telephoneErrorMsgWE()
	{
		return telephoneErrorMsgWE;
	}
	public WebElement emailidWE()
	{
		return emailidWE;
	}
	public WebElement emailidErrorWE()
	{
		return emailidErrorWE;
	}
	public WebElement customerNameTextWE()
	{
		return CustomerNameTextWE;
	}
	public WebElement GenderTextWE()
	{
		return GenderTextWE;
	}
	public WebElement DateOfBirthTextWE()
	{
		return DateOfBirthTextWE;
	}
	public WebElement AddressTextWE()
	{
		return AddressTextWE;
	}
	public WebElement CityTextWE()
	{
		return CityTextWE;
	}
	public WebElement StateTextWE()
	{
		return StateTextWE;
	}
	public WebElement PINTextWE()
	{
		return PINTextWE;
	}
	public WebElement TelephoneNumberTextWE()
	{
		return TelephoneNumberTextWE;
	}
	public WebElement EmailTextWE()
	{
		return EmailTextWE;
	}
	public WebElement addressErrorMsg()
	{
		return addressErrorMsgWE;
	}
	public WebElement genderSelection()
	{
		return genderWE;
	}
	public WebElement dobSelect()
	{
		return dobWE;
	}
	public WebElement btnSubmitt()
	{
		return btnSubmit;
	}
	public WebElement passwordWEFun()
	{
		return passwordWE;
	}

}
