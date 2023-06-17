package com.qa.testcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.baseclass.BaseClass;
import com.qa.pages.AddCustomerPage;
import com.qa.pages.ManagerHomePage;
import com.qa.utilities.Utility;

public class NewCustomerValidations extends BaseClass {
	
	WebDriver driver;
	ManagerHomePage managerHomePage;
	AddCustomerPage addCustomerPage;
	
	NewCustomerValidations()
	{
		super();
	}
	
	@BeforeMethod
	public void startTesting() throws Exception
	{
		
		driver=initializeBrowser(prop.getProperty("browserName"));
		
		managerHomePage=new ManagerHomePage(driver);
		addCustomerPage=managerHomePage.clickOnNewCustomerLinkText();
		System.out.println("Clicked on Link");
		Thread.sleep(5000);
		if(driver.getTitle()!="Guru99 Bank New Customer Entry Page")
		{
			
		//WebElement frames = driver.findElement(By.xpath("//iframe[@title=\"3rd party ad content\"]"));
		//int frameCount=frames.size();
		
		WebElement eleClose;
	 
		if(driver.findElement(By.xpath("//iframe[@title=\"3rd party ad content\"]")).isDisplayed())
		{
			driver.switchTo().frame("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0");
			eleClose=driver.findElement(By.xpath("//div[@id=\"dismiss-button\"]"));
			eleClose.click();
			
			/*if(driver.findElement(By.xpath("//div[@id=\"dismiss-button\"]")).isDisplayed())
			{
				driver.switchTo().frame("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0");
				driver.switchTo().frame("ad_iframe");
				eleClose=driver.findElement(By.xpath("//div[@id=\"dismiss-button\"]"));
				eleClose.click();
			}
			else
				{	driver.switchTo().frame("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0");
					eleClose=driver.findElement(By.xpath("//div[@id=\"dismiss-button\"]"));
					eleClose.click();
				}*/
		}

		}
	}

	
	@AfterMethod
	public void tearDown()
	{
		closeBrowser();
	}
	
	@Test(priority=1)
	public void verifyCustomerNameWithNumbers() 
	{
		System.out.println(driver.getTitle());
		//Utility.waitImplementation(driver, addCustomerPage.customerNameWE(), Duration.ofSeconds(Utility.WEBELEMENTWAITTIME));
		addCustomerPage.customerNameWE().sendKeys(testProp.getProperty("customerNameWithNumbers"));
		Assert.assertEquals(Utility.readWarningMessage(addCustomerPage.customerErrorMessageWE()),testProp.getProperty("customerNameErrorMessageNumbers"));
		
	}
	@Test(priority=2)
	public void verifyCustomerNameWithSpecialCharacters()
	{
		
		//Utility.waitImplementation(driver, addCustomerPage.customerNameWE(), Duration.ofSeconds(Utility.WEBELEMENTWAITTIME));
		addCustomerPage.customerNameWE().sendKeys(testProp.getProperty("customerNameWithSpecialCharacters"));
		Assert.assertEquals(Utility.readWarningMessage(addCustomerPage.customerErrorMessageWE()),testProp.getProperty("customerNameErrorMessageSpecialCharacters"));
		
	}
	@Test(priority=3)
	public void verifyCustomerNameWithoutData()
	{
		//Utility.waitImplementation(driver, addCustomerPage.customerNameWE(), Duration.ofSeconds(Utility.WEBELEMENTWAITTIME));
		addCustomerPage.customerNameWE().sendKeys(Keys.TAB);
		Assert.assertEquals(Utility.readWarningMessage(addCustomerPage.customerErrorMessageWE()),testProp.getProperty("customerNameWithoutData"));
		
	}
	@Test(priority=4)
	public void verifyWithCustomerName()
	{
		//Utility.waitImplementation(driver, addCustomerPage.customerNameWE(), Duration.ofSeconds(Utility.WEBELEMENTWAITTIME));
		addCustomerPage.customerNameWE().sendKeys(prop.getProperty("validCustomerName"));
		Assert.assertEquals(Utility.readWarningMessage(addCustomerPage.customerErrorMessageWE()),"");
		
	}
	@Test(priority=5)
	public void verifyCustomerNameWithSpace()
	{
		//Utility.waitImplementation(driver, addCustomerPage.customerNameWE(), Duration.ofSeconds(Utility.WEBELEMENTWAITTIME));
		addCustomerPage.customerNameWE().sendKeys(" Raghu");//testProp.getProperty("customerNameWithFirstLetterSpace"));
		System.out.println(testProp.getProperty("customerNameWithFirstLetterSpace"));
		Assert.assertEquals(Utility.readWarningMessage(addCustomerPage.customerErrorMessageWE()),testProp.getProperty("customerNameWithFirstLetterBlank"));
		
	}
	@Test(priority=6)
	public void verifyAddressWithoutData() throws Exception
	{
		//Utility.waitImplementation(driver, addCustomerPage.customerNameWE(), Duration.ofSeconds(Utility.WEBELEMENTWAITTIME));
		addCustomerPage.addressFieldWE().sendKeys(Keys.TAB);
		SoftAssert sftAssert=new SoftAssert();
		Thread.sleep(3000);
		sftAssert.assertEquals(Utility.readWarningMessage(addCustomerPage.addressErrorMsg()),testProp.getProperty("AddressFiledBlankMessage"));
		sftAssert.assertAll();
	}
	@Test(priority=7)
	public void verifyAddressFieldWithSpace()
	{
		//Utility.waitImplementation(driver, addCustomerPage.customerNameWE(), Duration.ofSeconds(Utility.WEBELEMENTWAITTIME));
		addCustomerPage.addressFieldWE().sendKeys(" Raghu,#23-17-20");//testProp.getProperty("customerNameWithFirstLetterSpace"));
		SoftAssert sftAssert=new SoftAssert();
		
		sftAssert.assertEquals(Utility.readWarningMessage(addCustomerPage.addressErrorMsg()),testProp.getProperty("AddressFiledFirstLetterSpace"));
		sftAssert.assertAll();
	}
	@Test(priority=8)
	public void verifyCityWithoutData()
	{
		//Utility.waitImplementation(driver, addCustomerPage.cityFieldWE(), Duration.ofSeconds(Utility.WEBELEMENTWAITTIME));
		addCustomerPage.cityFieldWE().sendKeys(Keys.TAB);
		SoftAssert sftAssert=new SoftAssert();
		sftAssert.assertEquals(Utility.readWarningMessage(addCustomerPage.cityFieldErrorWE()),testProp.getProperty("cityBlankMessage"));
		sftAssert.assertAll();
	}
	@Test(priority=9)
	public void verifyCityWithNumericData()
	{
		//Utility.waitImplementation(driver, addCustomerPage.cityFieldWE(), Duration.ofSeconds(Utility.WEBELEMENTWAITTIME));
		addCustomerPage.cityFieldWE().sendKeys(testProp.getProperty("cityWithNumericData"));
		SoftAssert sftAssert=new SoftAssert();
		sftAssert.assertEquals(Utility.readWarningMessage(addCustomerPage.cityFieldErrorWE()),testProp.getProperty("cityErrorMessageNumeric"));
		sftAssert.assertAll();
	}
	@Test(priority=10)
	public void verifyCityWithSpecialCharacter()
	{
		//Utility.waitImplementation(driver, addCustomerPage.cityFieldWE(), Duration.ofSeconds(Utility.WEBELEMENTWAITTIME));
		addCustomerPage.cityFieldWE().sendKeys(testProp.getProperty("cityWithSpecialCharacter"));
		SoftAssert sftAssert=new SoftAssert();
		sftAssert.assertEquals(Utility.readWarningMessage(addCustomerPage.cityFieldErrorWE()),testProp.getProperty("cityErrorMessageSpecial"));
		sftAssert.assertAll();
	}
	@Test(priority=11)
	public void verifyCityWithFirstCharacterSpace()
	{
		//Utility.waitImplementation(driver, addCustomerPage.cityFieldWE(), Duration.ofSeconds(Utility.WEBELEMENTWAITTIME));
		addCustomerPage.cityFieldWE().sendKeys(" RJY");//testProp.getProperty("cityWithFirstCharacterSpace"));
		SoftAssert sftAssert=new SoftAssert();
		sftAssert.assertEquals(Utility.readWarningMessage(addCustomerPage.cityFieldErrorWE()),testProp.getProperty("cityFirstCharacterBlankMsg"));
		sftAssert.assertAll();
	}
	@Test(priority=12)
	public void verifyStateWithoutData()
	{
		//Utility.waitImplementation(driver, addCustomerPage.stateFieldWE(), Duration.ofSeconds(Utility.WEBELEMENTWAITTIME));
		addCustomerPage.cityFieldWE().sendKeys(Keys.TAB);
		SoftAssert sftAssert=new SoftAssert();
		sftAssert.assertEquals(Utility.readWarningMessage(addCustomerPage.stateFieldErrorWE()),testProp.getProperty("stateErrorMessageBlank"));
		sftAssert.assertAll();
	}
	@Test(priority=13)
	public void verifyStateWithNumericData()
	{
		//Utility.waitImplementation(driver, addCustomerPage.stateFieldWE(), Duration.ofSeconds(Utility.WEBELEMENTWAITTIME));
		addCustomerPage.stateFieldWE().sendKeys(testProp.getProperty("stateWithNumericData"));
		SoftAssert sftAssert=new SoftAssert();
		sftAssert.assertEquals(Utility.readWarningMessage(addCustomerPage.stateFieldErrorWE()),testProp.getProperty("stateErrorMessageNumeric"));
		sftAssert.assertAll();
	}
	@Test(priority=14)
	public void verifyStateWithSpecialCharacter()
	{
		//Utility.waitImplementation(driver, addCustomerPage.stateFieldWE(), Duration.ofSeconds(Utility.WEBELEMENTWAITTIME));
		addCustomerPage.stateFieldWE().sendKeys(testProp.getProperty("stateWithSpecialCharacter"));
		SoftAssert sftAssert=new SoftAssert();
		sftAssert.assertEquals(Utility.readWarningMessage(addCustomerPage.stateFieldErrorWE()),testProp.getProperty("stateWithSpecialCharacterWarnMsg"));
		sftAssert.assertAll();
	}
	@Test(priority=15)
	public void verifyStateWithFirstCharacterSpace()
	{
		//Utility.waitImplementation(driver, addCustomerPage.stateFieldWE(), Duration.ofSeconds(Utility.WEBELEMENTWAITTIME));
		addCustomerPage.stateFieldWE().sendKeys(" AP");//testProp.getProperty("stateWithFirstSpace"));
		SoftAssert sftAssert=new SoftAssert();
		sftAssert.assertEquals(Utility.readWarningMessage(addCustomerPage.stateFieldErrorWE()),testProp.getProperty("stateWithFirstSpaceWarnMsg"));
		sftAssert.assertAll();
	}
	@Test(priority=16)
	public void verifyPINWithoutData()
	{
		//Utility.waitImplementation(driver, addCustomerPage.pinnoWE(), Duration.ofSeconds(Utility.WEBELEMENTWAITTIME));
		addCustomerPage.pinnoWE().sendKeys(Keys.TAB);
		SoftAssert sftAssert=new SoftAssert();
		sftAssert.assertEquals(Utility.readWarningMessage(addCustomerPage.pinnoErrorWE()),testProp.getProperty("pinnoblankError"));
		sftAssert.assertAll();
	}
	@Test(priority=17)
	public void verifyPINWithCharacterData()
	{
		//Utility.waitImplementation(driver, addCustomerPage.pinnoWE(), Duration.ofSeconds(Utility.WEBELEMENTWAITTIME));
		addCustomerPage.pinnoWE().sendKeys(testProp.getProperty("pinNoWithCharacters"));
		SoftAssert sftAssert=new SoftAssert();
		sftAssert.assertEquals(Utility.readWarningMessage(addCustomerPage.pinnoErrorWE()),testProp.getProperty("pinNoErrorCharcter"));
		sftAssert.assertAll();
	}
	@Test(priority=18)
	public void verifyPINWithSpecialCharacter()
	{
		//Utility.waitImplementation(driver, addCustomerPage.pinnoWE(), Duration.ofSeconds(Utility.WEBELEMENTWAITTIME));
		addCustomerPage.pinnoWE().sendKeys(testProp.getProperty("pinNoSpecial"));
		SoftAssert sftAssert=new SoftAssert();
		sftAssert.assertEquals(Utility.readWarningMessage(addCustomerPage.pinnoErrorWE()),testProp.getProperty("pinNoErrorSpecial"));
		sftAssert.assertAll();
	}
	@Test(priority=19)
	public void verifyPinWithFirstCharacterSpace()
	{
		//Utility.waitImplementation(driver, addCustomerPage.pinnoWE(), Duration.ofSeconds(Utility.WEBELEMENTWAITTIME));
		addCustomerPage.pinnoWE().sendKeys(" 53310");//testProp.getProperty("pinNoFirstSpace"));
		SoftAssert sftAssert=new SoftAssert();
		sftAssert.assertEquals(Utility.readWarningMessage(addCustomerPage.pinnoErrorWE()),testProp.getProperty("pinNoErrorSpace"));
		sftAssert.assertAll();
	}
	@Test(priority=20)
	public void verifyPinNoWith4()
	{
		//Utility.waitImplementation(driver, addCustomerPage.pinnoWE(), Duration.ofSeconds(Utility.WEBELEMENTWAITTIME));
		addCustomerPage.pinnoWE().sendKeys(" 53310");//testProp.getProperty("pinNoless5"));
		SoftAssert sftAssert=new SoftAssert();
		sftAssert.assertEquals(Utility.readWarningMessage(addCustomerPage.pinnoErrorWE()),testProp.getProperty("pinNoErrorSpace"));
		sftAssert.assertAll();
	}
	@Test(priority=21)
	public void verifyPinNoWithMidSpaces()
	{
		//Utility.waitImplementation(driver, addCustomerPage.pinnoWE(), Duration.ofSeconds(Utility.WEBELEMENTWAITTIME));
		addCustomerPage.pinnoWE().sendKeys(testProp.getProperty("pinNoMidSpace"));
		SoftAssert sftAssert=new SoftAssert();
		sftAssert.assertEquals(Utility.readWarningMessage(addCustomerPage.pinnoErrorWE()),testProp.getProperty("pinNoErrorCharcter"));
		sftAssert.assertAll();
	}
	@Test(priority=22)
	public void verifyTelephoneWithoutData()
	{
		//Utility.waitImplementation(driver, addCustomerPage.telephoneWE(), Duration.ofSeconds(Utility.WEBELEMENTWAITTIME));
		addCustomerPage.telephoneWE().sendKeys(Keys.TAB);
		SoftAssert sftAssert=new SoftAssert();
		sftAssert.assertEquals(Utility.readWarningMessage(addCustomerPage.telephoneErrorMsgWE()),testProp.getProperty("telephoneWithoutDataError"));
		sftAssert.assertAll();
	}
	@Test(priority=23)
	public void verifyTelephoneFirstSpace()
	{
		//Utility.waitImplementation(driver, addCustomerPage.telephoneWE(), Duration.ofSeconds(Utility.WEBELEMENTWAITTIME));
		addCustomerPage.telephoneWE().sendKeys(" 949143200");//testProp.getProperty("telephoneNoFirstBlank"));
		SoftAssert sftAssert=new SoftAssert();
		sftAssert.assertEquals(Utility.readWarningMessage(addCustomerPage.telephoneErrorMsgWE()),testProp.getProperty("telephoneNoFirstBlankError"));
		sftAssert.assertAll();
	}	
	@Test(priority=24)
	public void verifyTelephoneMidSpace()
	{
		//Utility.waitImplementation(driver, addCustomerPage.telephoneWE(), Duration.ofSeconds(Utility.WEBELEMENTWAITTIME));
		addCustomerPage.telephoneWE().sendKeys(testProp.getProperty("telephoneNoMidBlank"));
		SoftAssert sftAssert=new SoftAssert();
		sftAssert.assertEquals(Utility.readWarningMessage(addCustomerPage.telephoneErrorMsgWE()),testProp.getProperty("telephoneWithMidSpacesError"));
		sftAssert.assertAll();
	}
	@Test(priority=25)
	public void verifyTelephoneSpecial()
	{
		//Utility.waitImplementation(driver, addCustomerPage.telephoneWE(), Duration.ofSeconds(Utility.WEBELEMENTWAITTIME));
		addCustomerPage.telephoneWE().sendKeys(testProp.getProperty("telephoneNoSpecial"));
		SoftAssert sftAssert=new SoftAssert();
		sftAssert.assertEquals(Utility.readWarningMessage(addCustomerPage.telephoneErrorMsgWE()),testProp.getProperty("telephoneNoSpecialError"));
		sftAssert.assertAll();
	}
	@Test(priority=26)
	public void verifyEmailAsBlank()
	{
		//Utility.waitImplementation(driver, addCustomerPage.emailidWE(), Duration.ofSeconds(Utility.WEBELEMENTWAITTIME));
		addCustomerPage.emailidWE().sendKeys(Keys.TAB);
		SoftAssert sftAssert=new SoftAssert();
		sftAssert.assertEquals(Utility.readWarningMessage(addCustomerPage.emailidErrorWE()),testProp.getProperty("emailAsBlankErrorMsg"));
		sftAssert.assertAll();
	}
	@Test(priority=27)
	public void verifyEmailInCorrectForm()
	{
		//Utility.waitImplementation(driver, addCustomerPage.emailidWE(), Duration.ofSeconds(Utility.WEBELEMENTWAITTIME));
		addCustomerPage.emailidWE().sendKeys(testProp.getProperty("emailIDInvalidFormat"));
		SoftAssert sftAssert=new SoftAssert();
		sftAssert.assertEquals(Utility.readWarningMessage(addCustomerPage.emailidErrorWE()),testProp.getProperty("emailIDInvalidFormatError"));
		sftAssert.assertAll();
	}
	@Test(priority=28)
	public void verifyEmailIDSpaces()
	{
		//Utility.waitImplementation(driver, addCustomerPage.emailidWE(), Duration.ofSeconds(Utility.WEBELEMENTWAITTIME));
		addCustomerPage.emailidWE().sendKeys(testProp.getProperty("emailIDWithSpace"));
		SoftAssert sftAssert=new SoftAssert();
		sftAssert.assertEquals(Utility.readWarningMessage(addCustomerPage.emailidErrorWE()),"");
		sftAssert.assertAll();
	}
	@Test(priority=29)
	public void verifyCustomerNameText()
	{
		SoftAssert sftAssert=new SoftAssert();
		//Utility.waitImplementation(driver, addCustomerPage.customerNameTextWE(), Duration.ofSeconds(Utility.WEBELEMENTWAITTIME));
		sftAssert.assertEquals(Utility.readWarningMessage(addCustomerPage.customerNameTextWE()),testProp.getProperty("customerNameText"));
		sftAssert.assertEquals(Utility.readWarningMessage(addCustomerPage.GenderTextWE()),testProp.getProperty("GenderTextField"));
		sftAssert.assertEquals(Utility.readWarningMessage(addCustomerPage.DateOfBirthTextWE()),testProp.getProperty("DateOfBirthTextField"));
		sftAssert.assertEquals(Utility.readWarningMessage(addCustomerPage.AddressTextWE()),testProp.getProperty("AddressFieldText"));
		sftAssert.assertEquals(Utility.readWarningMessage(addCustomerPage.CityTextWE()),testProp.getProperty("CityFieldText"));
		sftAssert.assertEquals(Utility.readWarningMessage(addCustomerPage.StateTextWE()),testProp.getProperty("StateFieldText"));
		sftAssert.assertEquals(Utility.readWarningMessage(addCustomerPage.PINTextWE()),testProp.getProperty("PINFieldText"));
		sftAssert.assertEquals(Utility.readWarningMessage(addCustomerPage.TelephoneNumberTextWE()),testProp.getProperty("TelephoneNoText"));
		sftAssert.assertEquals(Utility.readWarningMessage(addCustomerPage.EmailTextWE()),testProp.getProperty("EmailText"));
		sftAssert.assertAll();
	}
	@Test(priority=30)
	public void createuserWithData() throws Exception
	{
		addCustomerPage.customerNameWE().sendKeys(testProp.getProperty("ValidCustomerName"));
		addCustomerPage.dobSelect().sendKeys(testProp.getProperty("Dob"));
		addCustomerPage.addressFieldWE().sendKeys(testProp.getProperty("validAddress"));
		addCustomerPage.cityFieldWE().sendKeys(testProp.getProperty("validCity"));
		addCustomerPage.stateFieldWE().sendKeys(testProp.getProperty("validState"));
		addCustomerPage.pinnoWE().sendKeys(testProp.getProperty("validPIN"));
		addCustomerPage.telephoneWE().sendKeys(testProp.getProperty("validTelephone"));
		addCustomerPage.emailidWE().sendKeys(testProp.getProperty("validEmail"));
		addCustomerPage.passwordWEFun().sendKeys(testProp.getProperty("validpassword"));
		Thread.sleep(5000);
		addCustomerPage.btnSubmitt().click();
		Thread.sleep(5000);
		
	}

}
