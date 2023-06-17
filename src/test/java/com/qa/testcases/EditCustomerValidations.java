package com.qa.testcases;

import java.time.Duration;

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
import com.qa.pages.EditCustomerPage;
import com.qa.pages.ManagerHomePage;
import com.qa.utilities.Utility;

public class EditCustomerValidations extends BaseClass {
	
	WebDriver driver;
	ManagerHomePage managerHomePage;
	EditCustomerPage editCustomerPage;
	
	EditCustomerValidations()
	{
		super();
	}
	
	@BeforeMethod
	public void startTesting()
	{
		
		driver=initializeBrowser(prop.getProperty("browserName"));
		managerHomePage=new ManagerHomePage(driver);
		editCustomerPage=managerHomePage.clickOnEditCustomerLink();
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
	public void verifyCustomerIdWithoutData()
	{
		//Utility.waitImplementation(driver, editCustomerPage.customerIdWE(), Duration.ofSeconds(Utility.WEBELEMENTWAITTIME));
		editCustomerPage.customerIdWE().sendKeys(Keys.TAB);
		Utility.waitImplementationVisible(driver, editCustomerPage.customerErrorMsg(), Duration.ofSeconds(Utility.WEBELEMENTWAITTIME));
		Assert.assertEquals(Utility.readWarningMessage(editCustomerPage.customerErrorMsg()),testProp.getProperty("customerIdBlankError"));
		
	}
	@Test(priority=2)
	public void verifyCustomerIdWithCharacters()
	{
		
		//Utility.waitImplementation(driver, editCustomerPage.customerIdWE(), Duration.ofSeconds(Utility.WEBELEMENTWAITTIME));
		editCustomerPage.customerIdWE().sendKeys(testProp.getProperty("customerNameWithCharacters"));
		Assert.assertEquals(Utility.readWarningMessage(editCustomerPage.customerErrorMsg()),testProp.getProperty("customerNameCharacterMsg"));
		
	}
	@Test(priority=3)
	public void verifyCustomerIdWithSpecialCharacters()
	{
		
		//Utility.waitImplementation(driver, editCustomerPage.customerIdWE(), Duration.ofSeconds(Utility.WEBELEMENTWAITTIME));
		editCustomerPage.customerIdWE().sendKeys(testProp.getProperty("customerIdSpecialCharacter"));
		Assert.assertEquals(Utility.readWarningMessage(editCustomerPage.customerErrorMsg()),testProp.getProperty("customerIdSpecialCharacterMsg"));
		
	}

	@Test(priority=4)
	public void verifyCustomerIdWithOnlyCharacters()
	{
		
		//Utility.waitImplementation(driver, editCustomerPage.customerIdWE(), Duration.ofSeconds(Utility.WEBELEMENTWAITTIME));
		editCustomerPage.customerIdWE().sendKeys(testProp.getProperty("customerNameWithOnlyCharacters"));
		Assert.assertEquals(Utility.readWarningMessage(editCustomerPage.customerErrorMsg()),testProp.getProperty("customerNameCharacterMsg"));
		
	}
	@Test(priority=5)
	public void verifyWithValidCustomerId()
	{
		//Utility.waitImplementation(driver, editCustomerPage.customerIdWE(), Duration.ofSeconds(Utility.WEBELEMENTWAITTIME));
		editCustomerPage.customerIdWE().sendKeys(prop.getProperty("validCustomerId"));
		editCustomerPage.clickOnAccountSubmittBtn();
		Assert.assertEquals("Connection failed: Access denied for user 'root'@'localhost' (using password: NO)","Edit Customer");
		
	}
	
}
