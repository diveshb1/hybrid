package com.Utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;

public class ScreenShotUtils extends BaseClass {

	
	public static String GetScreenShot(String name) throws Exception {
		
		TakesScreenshot tc=(TakesScreenshot)driver;
		File src=tc.getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"/ScreenShot/"+name+".jpg";
		File dest=new File(path);
		
		FileUtils.copyFile(src, dest);
		
		return path;
	}
	
	public static void scrollForElement(WebElement element) {
		//typecasting
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public static void main(String[] args) throws Exception {
		
		initialization();
		driver.navigate().to("https://www.carmax.com/");
	 WebElement shopCar	=driver.findElement(By.xpath("//a[text()='Acura MDX' ]"));
	 scrollForElement(shopCar);
	
	}
}
