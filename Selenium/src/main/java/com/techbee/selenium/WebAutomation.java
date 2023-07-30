package com.techbee.selenium;

import java.io.File;
import java.io.IOException;
import java.net.SocketException;
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
				
		List<WebElement> titleList = driver.findElements(By.className("s-item__title"));
		List<WebElement> priceList = driver.findElements(By.className("s-item__price"));		
		
		//Write text to File
		File f = new File("C:\\Users\\RSquared\\Desktop\\Folders\\Work Folder\\Techbee Solutions\\Assignments\\Week 4\\savetext.txt");
		log.info("File Created");
		try {
			
		for(int i =0; i<titleList.size();i++) {
			String x = titleList.get(i).getText();
			log.info(x);
			FileUtils.write(f, x,true);
			FileUtils.write(f, "\n", true);			
			String y = priceList.get(i).getText();
			log.info(y);
			FileUtils.write(f, y, true);
			log.info("\n");
			FileUtils.write(f, "\n", true);
		}
		}
		catch(IOException i) {
			i.printStackTrace();
		}		
		driver.close();
		driver.quit(); 
	
		}
//		
}
