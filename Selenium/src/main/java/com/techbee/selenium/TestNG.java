/**
 * Author: Rico-Kali Hayes
 * Date: 08/07/2023
 * Description: Simple Page Object Model design Selenium web application test using TestNG without using
 * Page Factory. 
 * */

package com.techbee.selenium;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

public class TestNG {

	public WebDriver driver;
	private static final Logger log = LogManager.getLogger(WebAutomation.class);
	private static final File f = new File(
			"C:\\workspace\\Techbee\\Techbee\\Selenium\\src\\main\\resources\\data.txt");
	
	
	@Test
	public void main() {
		
		// Locators
		driver.findElement(By.id("gh-ac")).sendKeys("iphone");
		driver.findElement(By.id("gh-btn")).click();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); // scrolls down
		
		// store values into lists
		List<WebElement> titleList = driver.findElements(By.className("s-item__title"));
		List<WebElement> priceList = driver.findElements(By.className("s-item__price"));
		
		// store list data into a text file
		try {
			FileUtils.write(f, "***** Ebay *****", Charset.defaultCharset(), true);
			log.info(titleList.size());
			for (int i = 0; i < titleList.size(); i++) {
				String x = titleList.get(i).getText();
				log.info(x);
				FileUtils.write(f, x + "- ", Charset.defaultCharset(), true);
				String y = priceList.get(i).getText();
				log.info(y);
				FileUtils.write(f, y + "\n", Charset.defaultCharset(), true);
			}
		} catch (IOException i) {
			i.printStackTrace();
		}
		
	}
	
	@BeforeMethod
	public void beforeMethod() {

		EdgeOptions options = new EdgeOptions();
		driver = new EdgeDriver(options);
		//ChromeOptions options = new ChromeOptions();
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\RSquared\\Desktop\\Folders\\Programs\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.ebay.com"); // navigate to web page
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.manage().window().maximize();
		
		
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.quit(); // close the driver and web page
	}	

}
