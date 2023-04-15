package com.actitime.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

public class LoginActiTimewithPropertyFile {
		static {
			System.setProperty("wedriver.edge.driver","./driver/msedgedriver.exe");
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vivekas\\eclipse-workspace\\Automation\\driver\\chromedriver.exe");
		}
		public static void main(String[] args) throws IOException {
			FileInputStream fis=new FileInputStream("./data/Commondata.property");
			Properties p=new Properties();
			p.load(fis);
			String url = p.getProperty("url");
			String un = p.getProperty("username");
			String pwd = p.getProperty("password");
			WebDriver edriver=new EdgeDriver();
			edriver.get(url);
			edriver.findElement(By.xpath("//input[@type='text']")).sendKeys(un);
			edriver.findElement(By.xpath("//input[@type='password']")).sendKeys(pwd);
			edriver.findElement(By.xpath("//div[text()='Login ']")).click();
			Reporter.log("Logged in successfully",true);
			edriver.close();
			WebDriver driver=new ChromeDriver();
			driver.get(url);
		}

}