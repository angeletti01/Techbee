package com.selenium.aspiration.utility;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
public static WebDriver driver = null;
private static final Logger log = LogManager.getLogger(TestBase.class);
@BeforeMethod
public void initialize() {
	log.info("Test Case Started, Initializing Test");
	EdgeOptions options = new EdgeOptions();
	driver = new EdgeDriver(options);
	driver.get("https://www.aspiration.com");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
}

@AfterMethod
public void afterMethod() {
	log.info("Test Case Complete, Quitting Driver");
	driver.quit();
}
}
