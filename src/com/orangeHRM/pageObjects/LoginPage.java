package com.orangeHRM.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	@FindBy(xpath = "//input[@name='username']")
	private WebElement usernameTF;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordTF;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginbtn;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement EnterUsn()
	{
		return usernameTF;
	}
	
	public WebElement EnterPsw()
	{
		return passwordTF;
	}
	
	public WebElement ClickLogin()
	{
		return loginbtn;
	}

}
