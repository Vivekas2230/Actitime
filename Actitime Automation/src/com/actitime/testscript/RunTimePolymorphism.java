package com.actitime.testscript;

import org.testng.annotations.Test;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class RunTimePolymorphism {
	static{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
	}
	public static WebDriver driver;
	@Test
	public void testRunTime() {
		System.out.println("enter the browser name");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String browser = sc.nextLine();
		if(browser.equals("chrome")) {
			driver =new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.get("https://www.google.com");
		String title = driver.getTitle();
		System.out.println(title);
	}
}

