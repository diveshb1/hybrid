package com.test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.listeners.ListnersEx;
import com.pages.DashBoardPage;
import com.pages.LoginPage;
@Listeners(ListnersEx.class)
public class UserTest extends BaseClass {
	public LoginPage lp=null;
    public DashBoardPage dp=null;
	@Test
	public void test01() throws Exception {
		initialization();
		lp=new LoginPage(driver);
		DashBoardPage dp=lp.ValidLogin();
		dp.clickUser();
		
	}
}
