package com.Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.base.BaseClass;

public class ActionsUtils extends BaseClass {

	public static void  RightClick(WebElement element) {
		
		Actions act=new Actions(driver);
		act.contextClick();
	}
	
	public static void MoveToElements(WebElement element,WebElement element2) {
		
		Actions act=new Actions(driver);
		
		act.moveToElement(element).moveToElement(element2).click().perform();
	}
	public static void main(String[] args) throws Exception {
		initialization();
		driver.navigate().to("https://www.carmax.com/");
		WebElement more =driver.findElement(By.xpath("//span[text()='More']"));
		WebElement info =driver.findElement(By.xpath("//a[text()='FAQ & Support']"));
		
		MoveToElements(more, info);
	}
	
}
