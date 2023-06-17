package com.qa.testcases;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.baseclass.BaseClass;
import com.qa.pages.EditCustomerPage;
import com.qa.pages.ManagerHomePage;
import com.qa.pages.NewAccountPage;
import com.qa.utilities.Utility;

public class NewAccountValidations extends BaseClass {
	WebDriver driver;
	
	
	ManagerHomePage managerHomePage;
	NewAccountPage newAccountPage;
	
	NewAccountValidations()
	{
		super();
	}
	
	@BeforeMethod
	public void startTesting()
	{
		
		driver=initializeBrowser(prop.getProperty("browserName"));
		managerHomePage=new ManagerHomePage(driver);
		newAccountPage=managerHomePage.clickOnNewAccountLinkWE();
		/*try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	
	@AfterMethod
	public void tearDown()
	{
		closeBrowser();
	}
	
	@Test(priority=1)
	public void verifyCustomerIdWithoutData()
	{
		Utility.waitImplementation(driver, newAccountPage.customerIdWE(), Duration.ofSeconds(Utility.WEBELEMENTWAITTIME));
		newAccountPage.customerIdWE().sendKeys(Keys.TAB);
		Assert.assertEquals(Utility.readWarningMessage(newAccountPage.customerIdErrorMsgWE()),testProp.getProperty("customerIdBlankError"));
		
	}
	@Test(priority=2)
	public void verifyCustomerIdWithCharactertData()
	{
		Utility.waitImplementation(driver, newAccountPage.customerIdWE(), Duration.ofSeconds(Utility.WEBELEMENTWAITTIME));
		newAccountPage.customerIdWE().sendKeys(testProp.getProperty("customerNameWithCharacters"));
		Assert.assertEquals(Utility.readWarningMessage(newAccountPage.customerIdErrorMsgWE()),testProp.getProperty("customerNameCharacterMsg"));
		
	}
	@Test(priority=3)
	public void verifyCustomerIdWithSpecialCharactertData()
	{
		Utility.waitImplementation(driver, newAccountPage.customerIdWE(), Duration.ofSeconds(Utility.WEBELEMENTWAITTIME));
		newAccountPage.customerIdWE().sendKeys(testProp.getProperty("customerIdSpecialCharacter"));
		Assert.assertEquals(Utility.readWarningMessage(newAccountPage.customerIdErrorMsgWE()),testProp.getProperty("customerIdSpecialCharacterMsg"));
		
	}
	@Test(priority=4)
	public void verifyCustomerIdWithBlanks()
	{
		Utility.waitImplementation(driver, newAccountPage.customerIdWE(), Duration.ofSeconds(Utility.WEBELEMENTWAITTIME));
		newAccountPage.customerIdWE().sendKeys(testProp.getProperty("customerIdWithBlanks"));
		Assert.assertEquals(Utility.readWarningMessage(newAccountPage.customerIdErrorMsgWE()),testProp.getProperty("customerNameCharacterMsg"));
		
	}
	@Test(priority=5)
	public void verifyCustomerIdWithFirstBlanks() throws Exception
	{
		Utility.waitImplementation(driver, newAccountPage.customerIdWE(), Duration.ofSeconds(Utility.WEBELEMENTWAITTIME));
		newAccountPage.customerIdWE().sendKeys(" 123456");//testProp.getProperty(" 123456"));
		Thread.sleep(40);
		Assert.assertEquals(Utility.readWarningMessage(newAccountPage.customerIdErrorMsgWE()),testProp.getProperty("customerIdWithFirstCharacterSpaceMsg"));
		
	}
	@Test(priority=6)
	public void verifyIntialBalanceEmpty() throws Exception
	{
		Utility.waitImplementation(driver, newAccountPage.intialDepositWE(), Duration.ofSeconds(Utility.WEBELEMENTWAITTIME));
		newAccountPage.intialDepositWE().sendKeys(Keys.TAB);//testProp.getProperty(" 123456"));
		Thread.sleep(40);
		Assert.assertEquals(Utility.readWarningMessage(newAccountPage.intialDepositErrorMsgWE()),testProp.getProperty("intialDepositErrorMsgBlank"));
		
	}
	@Test(priority=7)
	public void verifyIntialBalanceWithText()
	{
		Utility.waitImplementation(driver, newAccountPage.intialDepositWE(), Duration.ofSeconds(Utility.WEBELEMENTWAITTIME));
		newAccountPage.intialDepositWE().sendKeys(testProp.getProperty("intialDepositWithText"));
		Assert.assertEquals(Utility.readWarningMessage(newAccountPage.intialDepositErrorMsgWE()),testProp.getProperty("intialDepositWithTextError"));
		
	}
	@Test(priority=8)
	public void verifyIntialBalanceWithSpecialChar()
	{
		Utility.waitImplementation(driver, newAccountPage.intialDepositWE(), Duration.ofSeconds(Utility.WEBELEMENTWAITTIME));
		newAccountPage.intialDepositWE().sendKeys(testProp.getProperty("intialDepositWithSpecialChar"));
		Assert.assertEquals(Utility.readWarningMessage(newAccountPage.intialDepositErrorMsgWE()),testProp.getProperty("intialDepositWithSpecialErrorMsg"));
		
	}
	@Test(priority=9)
	public void verifyIntialBalanceWithMidSpace()
	{
		Utility.waitImplementation(driver, newAccountPage.intialDepositWE(), Duration.ofSeconds(Utility.WEBELEMENTWAITTIME));
		newAccountPage.intialDepositWE().sendKeys(testProp.getProperty("intialDepositWithMidSpace"));
		Assert.assertEquals(Utility.readWarningMessage(newAccountPage.intialDepositErrorMsgWE()),testProp.getProperty("intialDepositWithTextError"));
		
	}
	@Test(priority=10)
	public void verifyIntialBalanceWithFirstSpace()
	{
		Utility.waitImplementation(driver, newAccountPage.intialDepositWE(), Duration.ofSeconds(Utility.WEBELEMENTWAITTIME));
		newAccountPage.intialDepositWE().sendKeys(" 1000");//testProp.getProperty("intialDepositWithMidSpace"));
		Assert.assertEquals(Utility.readWarningMessage(newAccountPage.intialDepositErrorMsgWE()),testProp.getProperty("intialDepositWithFirstSpaceErrorMsg"));
		
	}

}
