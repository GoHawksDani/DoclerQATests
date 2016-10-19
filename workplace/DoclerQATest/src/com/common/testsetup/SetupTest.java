package com.common.testsetup;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.pack.common.pageobjects.GeneralObjects;

public class SetupTest {

	public static WebDriver driver;
	
	@BeforeClass
	public static void setupTest() {
		System.setProperty("webdriver.gecko.driver", "lib\\geckodriver.exe");
		driver =  new FirefoxDriver();		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		GeneralObjects.navigateToSite(driver, "http://uitest.duodecadits.com/");
	}
	
	@AfterClass
	public static void tearDownTest() {
		driver.manage().deleteAllCookies();
		driver.close();
		driver.quit();
	}
}
