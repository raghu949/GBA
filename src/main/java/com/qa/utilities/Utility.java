package com.qa.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {
	
	public static final int IMPLICIT_WAIT_TIME=20;
	public static final int Page_Load_TIMEOUT=15;
	public static final int WEBELEMENTWAITTIME=30;
	
	public static void waitImplementation(WebDriver driver,WebElement ele, Duration waitTime)
	{
		WebDriverWait wait=new WebDriverWait(driver,waitTime);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		
	}
	public static String readWarningMessage(WebElement ele)
	{
		String strErrorMessage=ele.getText();
		return strErrorMessage;
	}
	public static void waitImplementationVisible(WebDriver driver,WebElement ele, Duration waitTime)
	{
		WebDriverWait wait=new WebDriverWait(driver,waitTime);
		wait.until(ExpectedConditions.visibilityOf(ele));
		
	}
	public static void closeAd(WebDriver driver)
	{
		
		driver.switchTo().frame("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0");
		WebElement eleClose=driver.findElement(By.xpath("//div[@id=\"dismiss-button\"]"));
	}
}
