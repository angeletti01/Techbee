package com.selenium.aspiration.utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Properties {
	public WebDriver driver;
	public final WebElement signInButton = driver.findElement(By.xpath("//*[@id=\\\"__next\\\"]/div/header/ul[2]/li[1]/a"));
	public final WebElement getStartedButton1 = driver.findElement(By.xpath("//*[@id=\\\"6MQ78tLuBbTJg2WaMAVh4f\\\"]"));
	public final WebElement getStartedButton2 = driver.findElement(By.xpath("//*[@id=\\\"bae33ba7-deed-4c5b-a6d3-fc5bf11a8-91d5\\\"]"));
	public final WebElement activateButton = driver.findElement(By.xpath("//*[@id=\\\"__next\\\"]/div/header/ul[3]/li/svg"));
	public final WebElement individualSolutionsLink = driver.findElement(By.xpath("//*[@id=\\\"__next\\\"]/div/footer/div/div/div[3]/div/div[1]/ul/li[2]/a"));
	public final WebElement emailFieldHome = driver.findElement(By.name("email"));
	public void initialize() {
		// AspirationHomePage
		
//				@FindBy(how = How.XPATH, using = "//*[@id=\"__next\"]/div/header/ul[2]/li[1]/a")
//				public static WebElement signInButton; 
//				@FindBy(how = How.XPATH, using = "//*[@id=\"6MQ78tLuBbTJg2WaMAVh4f\"]")
//				public static WebElement getStartedButton1;
//				@FindBy(how = How.XPATH, using = "//*[@id=\"bae33ba7-deed-4c5b-a6d3-fc5bf11a8-91d5\"]")
//				 public static WebElement getStartedButton2;
//				@FindBy(how = How.XPATH, using = "//*[@id=\"__next\"]/div/header/ul[3]/li/svg")
//				 public static WebElement activateButton;
//				@FindBy(how = How.XPATH, using = "//*[@id=\"__next\"]/div/footer/div/div/div[3]/div/div[1]/ul/li[2]/a")
//				 public static WebElement individualSolutionsLink;
//				@FindBy(how = How.NAME, using = "email")
//				 public static WebElement emailFieldHome;
//				// AspirationSignInPage
//				@FindBy(how = How.ID, using = "signinEmail")
//				static public WebElement emailFieldSignIn;	
//				@FindBy(how = How.ID, using = "signinPassword")
//				static public WebElement passwordField;
//				@FindBy(how = How.XPATH, using ="//*[@id=\"content-area\"]/div/div/div/div[2]/form/fieldset/div[3]/button/svg")
//				static public WebElement loginButton;	
//				//AspirationGetAccountPage
//				@FindBy(how = How.XPATH, using ="//*[@id=\"__next\"]/div/div[4]/section[2]/div/div[1]/div[1]/div[2]/div[2]/p[2]")
//				static public WebElement aspirationPYearly; 
//				@FindBy(how = How.XPATH, using = "//*[@id=\"__next\"]/div/div[4]/section[2]/div/div[1]/div[1]/div[2]/div[2]/p[1]")
//				static public WebElement aspirationPMonthly;
//				@FindBy(how = How.XPATH, using = "//*[@id=\"__next\"]/div/div[4]/section[2]/div/div[1]/div[1]/div[1]/div[1]/span")
//				static public WebElement card1;
//				@FindBy(how = How.XPATH, using = "//*[@id=\"__next\"]/div/div[4]/section[2]/div/div[1]/div[1]/div[2]/div[1]/span" )
//				static public WebElement card2;
//				@FindBy(how = How.CLASS_NAME, using = "jahYLK")
//				static public List<WebElement> cards;	
//				@FindBy(how = How.XPATH, using = "//*[@id=\"__next\"]/div/div[4]/section[2]/div/div[1]/ul/li[8]/div[1]/div[2]")
//				static public WebElement aspirationOption1;
//				@FindBy(how = How.CLASS_NAME, using = "Image-sc-it4irs-0")
//				static public WebElement aspirationOptionImage;
//				@FindBy(how = How.XPATH, using = "//*[@id=\"__next\"]/div/div[4]/section[2]/div/div[1]/ul/li[9]/div[1]/div[2]")
//				static public WebElement aspirationOption2;
//				@FindBy(how = How.XPATH, using = "//*[@id=\"__next\"]/div/div[4]/section[2]/div/div[1]/ul/li[10]/div[1]/div[2]")
//				static public WebElement aspirationOption3;
//				@FindBy(how = How.XPATH, using = "//*[@id=\"__next\"]/div/div[4]/section[2]/div/div[1]/ul/li[8]/div[1]/div[3]")
//				static public WebElement aspirationPlusOption1;
//				@FindBy(how = How.CLASS_NAME, using = "Image-sc-it4irs-0")
//				static public WebElement aspirationPlusOptionImage;
//				@FindBy(how = How.XPATH, using = "//*[@id=\"__next\"]/div/div[4]/section[2]/div/div[1]/ul/li[9]/div[1]/div[3]")
//				static public WebElement aspirationPlusOption2;
//				@FindBy(how = How.XPATH, using = "//*[@id=\"__next\"]/div/div[4]/section[2]/div/div[1]/ul/li[10]/div[1]/div[3]")
//				static public WebElement aspirationPlusOption3;
	}
	}
	
