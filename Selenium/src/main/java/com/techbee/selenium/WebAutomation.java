package com.techbee.selenium;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

import java.nio.charset.Charset;

import java.time.Duration;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebAutomation {

	private static final Logger log = LogManager.getLogger(WebAutomation.class);
	private static final File f = new File(
			"C:\\workspace\\Techbee\\Techbee\\Selenium\\src\\main\\resources\\data.txt");
	
	public static WebDriver driverInit = initializeChromeDriver();	
	
	public static WebDriver initializeChromeDriver() {
		
		EdgeOptions options = new EdgeOptions();
		WebDriver driver = new EdgeDriver(options);
		//ChromeOptions options = new ChromeOptions();
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\RSquared\\Desktop\\Folders\\Programs\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}	
	
	public static void testEbay(WebDriver driver) {
		log.info("Ebay Test Started......");
		driver.navigate().to("http://www.ebay.com/");
		driver.findElement(By.id("gh-ac")).sendKeys("iphone");
		driver.findElement(By.id("gh-btn")).click();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");	
		List<WebElement> titleList = driver.findElements(By.className("s-item__title"));
		List<WebElement> priceList = driver.findElements(By.className("s-item__price"));

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
	
	public static void testTarget(WebDriver driver) throws InterruptedException{
		log.info("Target Test Started......");		
		driver.navigate().to("http://www.target.com/");	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.findElement(By.id("search")).sendKeys("iphone");
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@id=\"headerPrimary\"]/div[6]/form/button[2]")).click();			
		Thread.sleep(2000); 
		driver.manage().deleteAllCookies();
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");			

		try {
			FileUtils.write(f, "\n", Charset.defaultCharset(), true);
			FileUtils.write(f, "***** Target *****", Charset.defaultCharset(), true);
			FileUtils.write(f, "\n", Charset.defaultCharset(), true);			
			List<WebElement> waitTitle = new WebDriverWait(driver, Duration.ofSeconds(2),Duration.ofSeconds(2)).until(
					ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("a[data-test='product-title']")));		
			List<WebElement> waitPrice = new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions
					.presenceOfAllElementsLocatedBy(By.cssSelector("span[data-test='current-price']")));			
			log.info("Writing to File");

			for (int i = 0; i < waitTitle.size(); i++) {
				log.info(waitTitle.get(i).getText());
				FileUtils.write(f, waitTitle.get(i).getText() + "- ", Charset.defaultCharset(), true);
				log.info(waitPrice.get(i).getText());
				FileUtils.write(f, waitPrice.get(i).getText() + "\n", Charset.defaultCharset(), true);
			}

		} catch (IOException i) {
			i.printStackTrace();
		}
	}

	public static void main(String... args) throws InterruptedException {
		 testEbay(driverInit);		
		 testTarget(driverInit);
		 driverInit.quit();
	}
}