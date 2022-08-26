package com.test;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Utility.ReportUtils;
import com.base.BaseClass;
import com.listeners.ListnersEx;
import com.pages.LoginPage;
@Listeners(ListnersEx.class)
public class LoginTest extends BaseClass {
	public LoginPage lp =null;

	@BeforeMethod
	public void SetUp() throws Exception{
		initialization();
	}
	@AfterMethod
	public void TearDown() {
		driver.close();
	}


	@Test
	public void test01() throws Exception {
		
		lp=new LoginPage(driver);
		lp.ValidLogin();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
	}
	@Test
	public void test02() throws Exception {
		
		lp=new LoginPage(driver);
	    lp.InvalidLogin("effe", "122345");
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
	}
	@Test
	public void test03() throws Exception {
		
		lp=new LoginPage(driver);
		lp.registeration();
	}
}
