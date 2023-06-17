package com.qa.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.pages.IndexPage;
import com.qa.utilities.Utility;

public class BaseClass {
	
	public WebDriver driver;
	public Properties prop;
	public Properties testProp;
	
	public BaseClass()
	{
		prop=new Properties();
		testProp=new Properties();
		File propFile =new File(System.getProperty("user.dir")+"//src//main//java//com//qa//impdata//ImpData.properties");
		File testFile=new File(System.getProperty("user.dir")+"//src//main//java//com//qa//testdata//testData.properties");
		try {
		FileInputStream fis=new FileInputStream(propFile);
		FileInputStream testFis=new FileInputStream(testFile);
		prop.load(fis);
		testProp.load(testFis);
		}catch(Exception e){e.printStackTrace();}
	}
	public WebDriver initializeBrowser(String browserName)
	{
		
		if(browserName.equalsIgnoreCase("Chrome"))
			driver=new ChromeDriver();
			else if(browserName.equalsIgnoreCase("Edge"))
			driver=new EdgeDriver();
			else if(browserName.equalsIgnoreCase("Safari"))
				driver=new SafariDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utility.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utility.Page_Load_TIMEOUT));
		
		driver.get(prop.getProperty("url"));
		System.out.println("Open App Successfully");
		logintoApplication();
		
		System.out.println("Login as Manager Successfully");
		return driver;
			
	}
	public void logintoApplication()
	{
		IndexPage indexPage=new IndexPage(driver);
		Utility.waitImplementationVisible(driver, indexPage.loginUidFun(), Duration.ofSeconds(Utility.WEBELEMENTWAITTIME));
		indexPage.loginUidFun().sendKeys(prop.getProperty("LoginUserId"));
		Utility.waitImplementationVisible(driver, indexPage.passwordFun(), Duration.ofSeconds(Utility.WEBELEMENTWAITTIME));
		indexPage.passwordFun().sendKeys(prop.getProperty("LoginPassword"));
		Utility.waitImplementation(driver, indexPage.btnLoginFun(), Duration.ofSeconds(Utility.WEBELEMENTWAITTIME));
		indexPage.btnLoginFun().click();
		
	}
	public void closeBrowser()
	{
		driver.quit();
	}

}
