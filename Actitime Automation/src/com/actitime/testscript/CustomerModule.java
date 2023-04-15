package com.actitime.testscript;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.Reporter;
import org.testng.annotations.Listeners;

import com.actitime.generic.BaseClass;

@Listeners(com.actitime.generic.ListenerImplementation.class)
public class CustomerModule extends BaseClass
{
	@Test(priority=1,invocationCount=2)
	public void editCustomer() {
		Reporter.log("editeCustomer",true);
	}
	@Test
	public void registerCustomer() {
		Reporter.log("registerCustomer",true);
	}
	@Test
	public void deleteCustomer() {
		Reporter.log("deleteCustomer",true);
	}
	@Test(priority=1,invocationCount=1,dependsOnMethods="modifyCustomer")
	public void createCustomer() {
		Reporter.log("createCustomer",true);
	}
	@Test(priority=3)
	public void modifyCustomer() {
		Reporter.log("modifyCustomer",true);
	}
	@Test(priority=2,enabled=true)
	public void modifyTask() {
		Reporter.log("ModifyTask",true);
		//AssertJUnit.fail("Testcasesfailed");
	}
}

