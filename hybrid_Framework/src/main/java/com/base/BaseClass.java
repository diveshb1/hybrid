package com.base;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Utility.PropertiesUtils;

public class BaseClass {

	
	public static WebDriver driver=null;
	public static Logger log=Logger.getLogger("BaseClass");
	
	public  static void initialization() throws Exception {
		log.info("Reading property file for browser name");
		String browser=PropertiesUtils.ReadProperty("browser");
		
		log.info("browser found in the file as a"+browser);
		if(browser.equalsIgnoreCase("chrome")) {
			log.info("user launching a chrome browser");
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver=new ChromeDriver();
			log.info("user Launched a chrome browser");
		}
		if(browser.equalsIgnoreCase("firefox")) {
			log.info("user launching a fireFox browser");
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver=new FirefoxDriver();
			log.info("user Launched a fireFox browser");
		}
	   driver.get(PropertiesUtils.ReadProperty("url"));
		log.info("maximizing  browser window");
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	  
	}
	public static void main(String[] args) throws Exception {
		initialization();
	}
}
