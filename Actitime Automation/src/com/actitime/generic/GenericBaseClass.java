package com.actitime.generic;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class GenericBaseClass{
	static {
		System.setProperty("webdriver.edge.driver", "./driver/msedgedriver.exe");
	}
	public static WebDriver driver;
	@BeforeClass
	public void openBrowser() {
		Reporter.log("openBrowser",true);
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@AfterClass
	public void closeBrowser() {
		Reporter.log("closeBrowser",true);
		driver.close();
	}
	@BeforeMethod
	public void login() throws IOException {
		Reporter.log("login",true);
		driver.get("https://demo.actitime.com/login.do");
		FileLib f = new FileLib();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(f.getExcelData("data", 1, 0));
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(f.getExcelData("data", 1, 1));
		driver.findElement(By.xpath("//div[text() ='Login ']")).click();
	}
	@AfterMethod
	public void logout() 
	{
		Reporter.log("logout",true);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("logoutLink")).click();
	}
}



