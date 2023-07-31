package com.techbee.selenium;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebAutomation {

	private static final Logger log = LogManager.getLogger(WebAutomation.class);
	private static final File f = new File(
			"C:\\\\Users\\\\RSquared\\\\Desktop\\\\Folders\\\\Work Folder\\\\Techbee Solutions\\\\Assignments\\\\Week 4\\\\savetext.txt");
	public static WebDriver driver1 = initializeChromeDriver();
	public static WebDriver driver2 = initializeChromeDriver();

	public static WebDriver initializeChromeDriver() {
		// Configure Chrome options if needed (e.g., headless mode)
		ChromeOptions options = new ChromeOptions();
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}

	public static void writeToFile(String text) throws IOException {
		FileUtils.write(f, text, Charset.defaultCharset(), true);
	}

	public static void testEbay(WebDriver driver) {
		log.info("Ebay Test Started......");
		driver.navigate().to("http://www.ebay.com/");
		driver.findElement(By.id("gh-ac")).sendKeys("iphone");
		driver.findElement(By.id("gh-btn")).click();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		List<WebElement> titleList = driver.findElements(By.className("s-item__title"));
		List<WebElement> priceList = driver.findElements(By.className("s-item__price"));

		try {
			FileUtils.write(f, "***** Ebay *****", Charset.defaultCharset(), true);
			log.info(titleList.size());
			for (int i = 0; i < titleList.size(); i++) {
				String x = titleList.get(i).getText();
				log.info(x);
				FileUtils.write(f, x + "\n", Charset.defaultCharset(), true);
				Thread.sleep(200);
				String y = priceList.get(i).getText();
				log.info(y);
				FileUtils.write(f, y + "\n", Charset.defaultCharset(), true);
			}
		} catch (IOException | InterruptedException i) {
			i.printStackTrace();
		}
	}

	public static void testTarget(WebDriver driver) {
		log.info("Target Test Started......");
		driver.navigate().to("http://www.target.com/");
		driver.findElement(By.id("search")).sendKeys("iphone");
		driver.findElement(By.xpath("//*[@id=\"headerPrimary\"]/div[6]/form/button[2]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

		List<WebElement> titleList2 = driver.findElements(By.className("styles__StyledRowWrapper-sc-z8946b-1"));
		List<WebElement> priceList2 = driver.findElements(By.className("current-price"));
		try {
			FileUtils.write(f, "***** Target *****", Charset.defaultCharset(), true);
			log.info(priceList2.size());
			for (int i = 0; i < titleList2.size(); i++) {
				String x2 = titleList2.get(i).getText();
				log.info(x2);
				FileUtils.write(f, x2 + "\n", Charset.defaultCharset(), true);
				Thread.sleep(200);
				String y2 = priceList2.get(i).getText();
				log.info(y2);
				FileUtils.write(f, y2 + "\n", Charset.defaultCharset(), true);
			}

		} catch (IOException | IndexOutOfBoundsException | InterruptedException i) {
			i.printStackTrace();
		}
	}

	public static void main(String... args) throws IOException {
		testEbay(driver1);
		driver1.close();
		testTarget(driver2);
		driver2.close();
	}
}