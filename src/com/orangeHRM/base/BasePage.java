package com.orangeHRM.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.orangeHRM.pageObjects.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage extends readProperty implements ApplicationConstants
{
	public WebDriver driver;
	public LoginPage lp;
	
	@BeforeClass
	public void LaunchBrowser() throws Exception
	{
		System.setProperty(chrome_Key, chrome_Value);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(readProperty1());
	}
	
	@BeforeMethod
	public void Login() throws InterruptedException
	{
		lp = new LoginPage(driver);
		
		lp.EnterUsn().sendKeys(usn);
		Thread.sleep(3000);
		lp.EnterPsw().sendKeys(psw);
		Thread.sleep(3000);
		lp.ClickLogin().click();
		Thread.sleep(3000);
	}

	@AfterMethod
	public void Logout()
	{
		
	}
	
	@AfterClass
	public void CloseBrowser()
	{
		driver.quit();
	}
	
}
