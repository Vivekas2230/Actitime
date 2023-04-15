package com.actitime.generic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	static {
		System.setProperty("wedriver.chrome.driver","./driver/chromedriver.exe");
	}
	
	public WebDriver driver;

	@BeforeClass
	public void openBrowser()
	{
		Reporter.log("Opening Browser", true);
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(co);
		driver.get("https://demo.actitime.com/login.do");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	@AfterClass
	public void closeBrowser()
	{
		Reporter.log("Closing Browser", true);
		driver.close();
	}
	@BeforeMethod
	public void login() 
	{
		Reporter.log("Login", true);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("manager");
		driver.findElement(By.xpath("//div[text()='Login ']")).click();
	}
	@AfterMethod
	public void logout()
	{
		Reporter.log("Logout", true);
		driver.findElement(By.className("logout")).click();
	}
}
