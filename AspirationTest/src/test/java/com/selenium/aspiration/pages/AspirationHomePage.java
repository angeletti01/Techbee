package com.selenium.aspiration.pages;

import com.selenium.aspiration.tests.AspirationTest;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AspirationHomePage extends AspirationTest {
public WebDriver driver;
private static final Logger log = LogManager.getLogger(AspirationHomePage.class);
private String email;

public AspirationHomePage(WebDriver driver) {
	this.driver = driver;
}
@FindBy(how = How.XPATH, using = "//*[@id=\"__next\"]/div/header/ul[2]/li[1]/a")
WebElement signInButton; // getting started button
@FindBy(how = How.XPATH, using = "//*[@id=\"6MQ78tLuBbTJg2WaMAVh4f\"]")
WebElement getStartedButton1;
@FindBy(how = How.XPATH, using = "//*[@id=\"bae33ba7-deed-4c5b-a6d3-fc5bf11a8-91d5\"]")
WebElement getStartedButton2;
@FindBy(how = How.XPATH, using = "//*[@id=\"__next\"]/div/header/ul[3]/li/svg")
WebElement activateButton;
@FindBy(how = How.XPATH, using = "//*[@id=\"__next\"]/div/footer/div/div/div[3]/div/div[1]/ul/li[2]/a")
WebElement individualSolutionsLink;
@FindBy(how = How.NAME, using = "email")
WebElement emailField;

public void clickIndividualSolution() {
	log.info("Inside clickIndividualSolution");	
	individualSolutionsLink.click();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
}
public void clickSignInButton() {
	log.info("Inside clickSignInButton");	
	signInButton.click();	
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
}
public void clickGettingStartedButton() {
	log.info("Inside of clickGettingStartedButton");
	getStartedButton1.click();	
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);		
}
public void clickGettingStartedButton2() {
	log.info("Inside of clickGettingStartedButton2");
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	getStartedButton2.click();	
	log.info(driver.getCurrentUrl());
}

public String getEmail() {
	return email;
}
public void setEmail(String email) {
	emailField.sendKeys(email);
}

}
