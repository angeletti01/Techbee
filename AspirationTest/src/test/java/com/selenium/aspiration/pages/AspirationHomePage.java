package com.selenium.aspiration.pages;

import com.selenium.aspiration.tests.AspirationTest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AspirationHomePage extends AspirationTest {
public WebDriver driver;
private static final Logger log = LogManager.getLogger(AspirationHomePage.class);

public AspirationHomePage(WebDriver driver) {
	this.driver = driver;
}
@FindBy(how = How.XPATH, using = "/html/body/div[5]/div/div/div/div[2]/a")
WebElement signInButton; // getting started button

}
