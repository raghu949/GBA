package com.qa.testcases;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.baseclass.BaseClass;
import com.qa.pages.EditAccountPage;
import com.qa.pages.EditCustomerPage;
import com.qa.pages.ManagerHomePage;
import com.qa.pages.NewAccountPage;
import com.qa.utilities.Utility;

public class EditAccountValidations extends BaseClass {
	WebDriver driver;
	
	
	ManagerHomePage managerHomePage;
	EditAccountPage editAccountPage;
	
	EditAccountValidations()
	{
		super();
	}
	
	@BeforeMethod
	public void startTesting()
	{
		
		driver=initializeBrowser(prop.getProperty("browserName"));
		managerHomePage=new ManagerHomePage(driver);
		editAccountPage=managerHomePage.cliclOnEditAccountLink();
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
	public void verifyAccountNoWithoutData()
	{
		Utility.waitImplementation(driver, editAccountPage.accountNoFun(), Duration.ofSeconds(Utility.WEBELEMENTWAITTIME));
		editAccountPage.accountNoFun().sendKeys(Keys.TAB);
		Assert.assertEquals(Utility.readWarningMessage(editAccountPage.accountNoErrorMsg()),testProp.getProperty("accountNoBlankMsg"));
		
	}
	@Test(priority=2)
	public void verifyAccountNoWithCharactertData()
	{
		Utility.waitImplementation(driver, editAccountPage.accountNoFun(), Duration.ofSeconds(Utility.WEBELEMENTWAITTIME));
		editAccountPage.accountNoFun().sendKeys(testProp.getProperty("accountNoWithCharacters"));
		Assert.assertEquals(Utility.readWarningMessage(editAccountPage.accountNoErrorMsg()),testProp.getProperty("accountNoCharactersError"));
		
	}
	@Test(priority=3)
	public void verifyCustomerIdWithSpecialCharactertData()
	{
		Utility.waitImplementation(driver, editAccountPage.accountNoFun(), Duration.ofSeconds(Utility.WEBELEMENTWAITTIME));
		editAccountPage.accountNoFun().sendKeys(testProp.getProperty("accountNoWithSpecialCharacter"));
		Assert.assertEquals(Utility.readWarningMessage(editAccountPage.accountNoErrorMsg()),testProp.getProperty("accountNoSpecialCharacterMsg"));
		
	}
	@Test(priority=4)
	public void verifyCustomerIdWithBlanks()
	{
		Utility.waitImplementation(driver, editAccountPage.accountNoFun(), Duration.ofSeconds(Utility.WEBELEMENTWAITTIME));
		editAccountPage.accountNoFun().sendKeys(testProp.getProperty("accountNoWithBlanks"));
		Assert.assertEquals(Utility.readWarningMessage(editAccountPage.accountNoErrorMsg()),testProp.getProperty("accountNoCharactersError"));
		
	}
	@Test(priority=5)
	public void verifyAccountNoWithFirstBlanks() throws Exception
	{
		Utility.waitImplementation(driver, editAccountPage.accountNoFun(), Duration.ofSeconds(Utility.WEBELEMENTWAITTIME));
		editAccountPage.accountNoFun().sendKeys(" 123456");//testProp.getProperty(" 123456"));
		Thread.sleep(40);
		Assert.assertEquals(Utility.readWarningMessage(editAccountPage.accountNoErrorMsg()),"");//testProp.getProperty("customerIdWithFirstCharacterSpaceMsg"));
		
	}
	

}
