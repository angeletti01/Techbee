package com.techbee.selenium.testng.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

public class TestBase {

	public static WebDriver driver = null;

	@BeforeSuite
	public void initialize() {
		EdgeOptions options = new EdgeOptions();
		driver = new EdgeDriver(options);
		driver.get("https://www.ebay.com"); // navigate to web page
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.quit(); // close the driver and web page
	}
}
