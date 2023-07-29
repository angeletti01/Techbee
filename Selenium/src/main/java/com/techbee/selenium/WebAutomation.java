package com.techbee.selenium;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebAutomation {
	
	private static final Logger log = LogManager.getLogger(WebAutomation.class);
	
	public static WebDriver driver = new ChromeDriver();
	 ChromeOptions options = new ChromeOptions();

	
	public static void main(String... args) throws IOException {

		log.info("Program Starting");
		
		// Puts an Implicit wait, Will wait for 10 seconds before throwing exception
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Launch website
		driver.navigate().to("http://www.ebay.com/");
				
		// Maximize the browser
		driver.manage().window().maximize();
		
		// Enter value Iphone in Search Field
		driver.findElement(By.id("gh-ac")).sendKeys("iphone");
				
		// Click on Submit Button
		driver.findElement(By.id("gh-btn")).click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		// identify element by Xpath
		//WebElement t = driver.findElement(By.cssSelector("#item46cd015ddf > div > div.s-item__info.clearfix > a > div"));
		//WebElement p = driver.findElement(By.cssSelector("#item46cd015ddf > div > div.s-item__info.clearfix > div.s-item__details.clearfix > div:nth-child(1) > span"));
		
		//List<WebElement> titleList = driver.findElements(By.cssSelector("#item46cd015ddf > div > div.s-item__info.clearfix > a > div"));
		//List<WebElement> priceList = driver.findElements(By.cssSelector("#item46cd015ddf > div > div.s-item__info.clearfix > div.s-item__details.clearfix > div:nth-child(1) > span"));
		
		List<WebElement> titleList = driver.findElements(By.className("s-item__title"));
		List<WebElement> priceList = driver.findElements(By.className("s-item__price"));
		
		// obtain text
		//String title = t.getText();
		//String price = p.getText();
		
		//Write text to File
		File f = new File("C:\\Users\\RSquared\\Desktop\\Folders\\Work Folder\\Techbee Solutions\\Assignments\\Week 4\\savetext.txt");
		try {
		for(int i =0; i<titleList.size();i++) {
			String x = titleList.get(i).getText();
			FileUtils.write(f, x, true);
			FileUtils.write(f, "\n", true);
			String y = priceList.get(i).getText();
			FileUtils.write(f, y, true);
			FileUtils.write(f, "\n", true);
		}
		}
		catch(IOException i) {
			i.printStackTrace();
		}
		finally {
			driver.close();
		}
			
		}
//		
}
