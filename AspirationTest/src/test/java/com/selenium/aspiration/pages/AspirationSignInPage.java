package com.selenium.aspiration.pages;

import com.selenium.aspiration.tests.AspirationTest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AspirationSignInPage extends AspirationTest {

	public WebDriver driver;
	private static final Logger log = LogManager.getLogger(AspirationSignInPage.class);
	private String email = System.getenv("DUMMYEMAIL");
	private String password = System.getenv("DUMMYPASSWORD");
	
	public AspirationSignInPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.ID, using = "signinEmail")
	WebElement emailField;
	@FindBy(how = How.ID, using = "signinPassword")
	WebElement passwordField;
	@FindBy(how = How.XPATH, using ="//*[@id=\"content-area\"]/div/div/div/div[2]/form/fieldset/div[3]/button/svg")
	WebElement loginButton;

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
