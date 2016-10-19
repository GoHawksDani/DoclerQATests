package com.pack.common.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageObjects {  
	
	private static WebElement element = null;
		
	 public static WebElement homeBtn(WebDriver driver){		 
		    element = driver.findElement(By.id("home"));		 
		    return element;		 
	 }	
	 
	 public static WebElement testingLogo(WebDriver driver){		 
		    element = driver.findElement(By.id("site"));		 
		    return element;		 
	 }
	  
	 public static WebElement homeHeader(WebDriver driver){
		 	WebElement mainContainer = driver.findElement(By.className("ui-test"));
		    WebElement homeHeader = mainContainer.findElement(By.tagName("h1"));
			return homeHeader;		 		 
	 }
	 
	 public static boolean verifyHomeHeaderText(WebDriver driver) {
		 	String expectedHomeHeaderText = "Welcome to the Docler Holding QA Department";
		 	String currentHomeHeader = homeHeader(driver).getText().toString();
			return currentHomeHeader.contains(expectedHomeHeaderText);
	 }
	 
	 public static WebElement homeParagraph(WebDriver driver){		 
		 	WebElement mainContainer = driver.findElement(By.className("ui-test"));
		 	WebElement homeParagraph = mainContainer.findElement(By.tagName("p"));		 
		    return homeParagraph;
	 }
	 
	 public static boolean verifyHomeParagraphText(WebDriver driver) {
		 	String expectedHomeParagraphText = "This site is dedicated to perform some exercises and demonstrate automated web testing.";
		 	String currentHomeParagraphText = homeParagraph(driver).getText().toString();
			return currentHomeParagraphText.contains(expectedHomeParagraphText);
	 }
	 
	 public static boolean verifyHomeUrl(WebDriver driver) {
			String currentURL = driver.getCurrentUrl();
			String homeURL ="http://uitest.duodecadits.com/";
			return currentURL.contains(homeURL);
	 }
	 
	 public static void waitUntilCompanyLogoAppears(WebDriver driver){
		 WebDriverWait wait = new WebDriverWait(driver, 15);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dh_logo")));		 
	 }
	 
	 public static void waitUntilHomeHeaderAppears(WebDriver driver){
		 WebDriverWait wait = new WebDriverWait(driver, 15);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Welcome to the Docler')")));		 
	 }
	 
	 public static boolean verifyHomeBtnActive(WebDriver driver) {
			return GeneralObjects.currentActiveBtnId(driver).contains("home");
	 }
	 

}
