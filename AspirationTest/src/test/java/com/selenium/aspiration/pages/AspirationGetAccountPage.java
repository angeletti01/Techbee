package com.selenium.aspiration.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.selenium.aspiration.tests.AspirationTest;

public class AspirationGetAccountPage extends AspirationTest{

	public WebDriver driver;
	private static final Logger log = LogManager.getLogger(AspirationGetAccountPage.class);
	private String aspirationPlusYearly = null; // for storing text value from web element
	private String aspirationPlusMonthly = null; // for storing text value from web element
	
	public AspirationGetAccountPage(WebDriver driver) {
		this.driver = driver;
	}
	@FindBy(how = How.XPATH, using ="//*[@id=\"__next\"]/div/div[4]/section[2]/div/div[1]/div[1]/div[2]/div[2]/p[2]")
	WebElement aspirationPYearly; // need to extract text from this source
	@FindBy(how = How.XPATH, using = "//*[@id=\"__next\"]/div/div[4]/section[2]/div/div[1]/div[1]/div[2]/div[2]/p[1]")
	WebElement aspirationPMonthly;
}
