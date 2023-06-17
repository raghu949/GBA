package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {
	
	WebDriver driver;
	
	@FindBy(name="uid")
	private WebElement loginUidWE;
	@FindBy(name="password")
	private WebElement passwordWE;
	@FindBy(name="btnLogin")
	private WebElement btnLoginWE;
	
	public IndexPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement loginUidFun()
	{
		return loginUidWE;
	}
	public WebElement passwordFun()
	{
		return passwordWE;
	}
	public WebElement btnLoginFun()
	{
		return btnLoginWE;
	}
}
