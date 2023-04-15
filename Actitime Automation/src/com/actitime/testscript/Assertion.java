package com.actitime.testscript;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Assertion {
	static {
		System.setProperty("webdriver.edge.driver","./driver/msedgedriver.exe");
	}
	@Test
	public void testVerifyTitle()
	{
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.google.com/");
		String expectedTitle = "Google";
		String actualTitle = driver.getTitle();
		if(actualTitle.equals(expectedTitle)) {
			Reporter.log("title is matching so pass", true);
		}
		else {
			Reporter.log("title is not matching so fail", true);
		}
		driver.close();
	}

}
