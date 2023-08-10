package com.selenium.aspiration.tests;

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
	driver.get("https://www.aspiration.com");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

@AfterMethod
public void afterMethod() {
	driver.quit();
}
}
