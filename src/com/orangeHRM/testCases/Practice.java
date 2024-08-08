package com.orangeHRM.testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Practice {
	public WebDriver driver;
	
	@BeforeMethod
	public void launch()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pavan\\Downloads\\chromedriver-win64 (8)\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	@AfterMethod
	public void close()
	{
		driver.quit();
	}
	
	
	@Test
	public void TC1() throws InterruptedException
	{
		Thread.sleep(3000);
		WebElement userName = driver.findElement(By.xpath("//div[@class='orangehrm-login-error']//div//p[1]"));
		String usn = userName.getText();
		String[] usn1 = usn.split(":");
		String extractedUsn = usn1[1].trim();
		WebElement password = driver.findElement(By.xpath("//div[@class='orangehrm-login-error']//div//p[2]"));
		String psw = password.getText();
		String[] psw1 = psw.split(":");
		String extractedPsw = psw1[1].trim();
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(extractedUsn);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(extractedPsw);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//i[@class='oxd-icon bi-plus oxd-button-icon']")).click();
		Thread.sleep(3000);
		WebElement drw = driver.findElement(By.xpath("//label[text()='User Role']//parent::div//following::div[1]"));
		drw.click();
		Thread.sleep(3000);
		Select drp = new Select(drw);
		drp.selectByIndex(1);
		Thread.sleep(3000);
		
		}

}
