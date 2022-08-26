package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utility.PropertiesUtils;
import com.Utility.ReportUtils;

public class LoginPage {

	
	WebDriver driver=null;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="email")
	private WebElement uname;
	
	@FindBy(id="password")
	private WebElement pass;
	
	@FindBy(xpath="//button")
	private WebElement LoginBtn;
	
	@FindBy(xpath="//a[text()='Register a new membership']")
	WebElement Register;
	   
	
    public  DashBoardPage ValidLogin() throws Exception {
    	//String uname1=PropertiesUtils.ReadProperty("username");
    	//String Pass=PropertiesUtils.ReadProperty("password");
   		uname.sendKeys("kiran@gmail.com");
		pass.sendKeys("123456");
		LoginBtn.click();
		return new DashBoardPage(driver);
	}
	public void InvalidLogin(String username,String Password) {
		uname.sendKeys(username);
		pass.sendKeys(Password);
		LoginBtn.click();	
	}
	public void registeration() {
		Register.click();
	}
	
}
