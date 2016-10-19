package com.pack.common.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ErrorPageObjects {

	private static WebElement element = null;
	
	 public static String errorText(WebDriver driver){		 
		 	WebElement errorHeader = driver.findElement(By.tagName("h1"));
		    String errorText = errorHeader.getText();	 
		    return errorText;
	 }
	 
	 public static WebElement errorBtn(WebDriver driver){		 
		    element = driver.findElement(By.id("error"));		 
		    return element;		 
	 }
	 
	 public static void waitUntilErrorTextAppears(WebDriver driver){
		 WebDriverWait wait = new WebDriverWait(driver, 15);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'404 Error')]")));		 
	 }
	 
	 public static boolean verifyErrorText(WebDriver driver) {
		 	return errorText(driver).contains("404 Error");
	 }
	 
	 public static boolean verifyErrorUrl(WebDriver driver) {
			String currentURL = driver.getCurrentUrl();
			String errorURL ="http://uitest.duodecadits.com/error";
			return currentURL.contains(errorURL);
	 }
	 
	 public static void navigateToErrorPage(WebDriver driver){
	     if (!verifyErrorUrl(driver)){
	    	 errorBtn(driver).click();
	    	 waitUntilErrorTextAppears(driver);
	     } else {
	    	 waitUntilErrorTextAppears(driver);
	     }
	 }
}
