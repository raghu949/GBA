package com.qa.testcases;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.baseclass.BaseClass;
import com.qa.pages.EditCustomerPage;
import com.qa.pages.ManagerHomePage;
import com.qa.utilities.Utility;

public class Experiment extends BaseClass {
	
	WebDriver driver;
	ManagerHomePage managerHomePage;
	EditCustomerPage editCustomerPage;
	
	
	Experiment()
	{
		super();
	}
	
	@BeforeMethod
	public void startTesting()
	{
		
		driver=initializeBrowser(prop.getProperty("browserName"));
		managerHomePage=new ManagerHomePage(driver);
		editCustomerPage=managerHomePage.clickOnEditCustomerLink();
		
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		//wait.until(ExpectedConditions.alertIsPresent());
		/*
		 * Alert alert=driver.switchTo().alert(); alert.dismiss();
		 */
		/*
		 * Set<String> windowHandle = driver.getWindowHandles();
		 * System.out.println(windowHandle.size());
		 * System.out.println(driver.getTitle().toString());
		 */
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
		System.out.println(" I am inner");
		driver.switchTo().frame("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0");
		WebElement eleClose=driver.findElement(By.xpath("//div[@id=\"dismiss-button\"]"));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		System.out.println(driver.findElement(By.xpath("//div[text()=\"Ad\"]")).getText().toString());
		wait.until(ExpectedConditions.elementToBeClickable(eleClose));
		eleClose.click();
		
		/*
		 * Set<String> windowHandle = driver.getWindowHandles();
		 * System.out.println(windowHandle.size());
		 * System.out.println(driver.getTitle().toString());
		 * //Utility.waitImplementation(driver, editCustomerPage.customerIdWE(),
		 * Duration.ofSeconds(Utility.WEBELEMENTWAITTIME)); windowHandle =
		 * driver.getWindowHandles();
		 */
		//System.out.println(driver.getTitle().toString());
		//System.out.println(windowHandle.size());
		//Utility.waitImplementation(driver, editCustomerPage.customerIdWE(), Duration.ofSeconds(Utility.WEBELEMENTWAITTIME));
		//System.out.println(driver.getTitle().toString());
		editCustomerPage.customerIdWE().sendKeys(Keys.TAB);
		
		//Utility.waitImplementationVisible(driver, editCustomerPage.customerErrorMsg(), Duration.ofSeconds(Utility.WEBELEMENTWAITTIME));
		Assert.assertEquals(Utility.readWarningMessage(editCustomerPage.customerErrorMsg()),testProp.getProperty("customerIdBlankError"));
		
	}

}
