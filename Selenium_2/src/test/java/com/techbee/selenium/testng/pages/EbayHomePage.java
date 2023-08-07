package com.techbee.selenium.testng.pages;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.techbee.selenium.testng.tests.EbaySearchTest;

public class EbayHomePage extends EbaySearchTest {
	
	public WebDriver driver;
	private static final Logger log = LogManager.getLogger(EbayHomePage.class);
	private static final File f = new File("C:\\workspace\\Techbee\\Techbee\\Selenium_2\\src\\test\\resources\\data.txt");
	private String itemSearch = null;

	public EbayHomePage(WebDriver driver) {
		super();
		this.driver = driver;		
	}

	@FindBy(how = How.ID, using = "gh-ac")
	WebElement searchField;
	@FindBy(how = How.ID, using = "gh-btn")
	WebElement submitButton;
	@FindBy(how = How.CLASS_NAME, using = "s-item__title")
	List<WebElement> itemTitle;
	@FindBy(how = How.CLASS_NAME, using = "s-item__price")
	List<WebElement> itemPrice;

	public void clickSearch() {
		submitButton.click();
	}

	public void saveToFile() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); // scrolls down

		// store values into lists
		List<WebElement> titleList = itemTitle;
		List<WebElement> priceList = itemPrice;

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

	public String getItemSearch() {
		return itemSearch;
	}

	public void setItemSearch(String itemSearch) {
		searchField.sendKeys(itemSearch);
	}

}
