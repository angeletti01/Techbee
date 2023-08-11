package com.selenium.aspiration.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
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
	private List<String> products = new ArrayList<>(); // store the products
	private List<Boolean> aspPlus = new ArrayList<>();
	private List<Boolean> asp = new ArrayList<>();
	
	public AspirationGetAccountPage(WebDriver driver) {
		this.driver = driver;
		
	}
	@FindBy(how = How.XPATH, using ="//*[@id=\"__next\"]/div/div[4]/section[2]/div/div[1]/div[1]/div[2]/div[2]/p[2]")
	WebElement aspirationPYearly; // need to extract text from this source
	@FindBy(how = How.XPATH, using = "//*[@id=\"__next\"]/div/div[4]/section[2]/div/div[1]/div[1]/div[2]/div[2]/p[1]")
	WebElement aspirationPMonthly;
	@FindBy(how = How.XPATH, using = "//*[@id=\"__next\"]/div/div[4]/section[2]/div/div[1]/div[1]/div[1]/div[1]/span")
	WebElement card1;
	@FindBy(how = How.XPATH, using = "//*[@id=\"__next\"]/div/div[4]/section[2]/div/div[1]/div[1]/div[2]/div[1]/span" )
	WebElement card2;
	@FindBy(how = How.CLASS_NAME, using = "jahYLK")
	List<WebElement> cards;
	
	
	public void viewProducts() {
		log.info("Inside viewProducts");
		int index = 0;
		for(WebElement e:cards) {			
			log.info("Product: "+(index)+"-"+e.getText());
			products.add(e.getText());
			index++;
		}
		this.setProducts(products);		
	}
	
	public void storeProducts() {
		log.info("Inside storeProducts");
		log.info(cards.size()); // display the number of products
		log.info("Credit Card 1: "+card1.getText());
		log.info("Credit Card 2: "+card2.getText());
		this.products.add(card1.getText());
		this.products.add(card2.getText());
		log.info("List of Products: "+products);
	}
	
	public void storeCosts() {
		log.info("Inside storeCosts");
		log.info("AspirationPlus Annual Cost per Month: "+aspirationPYearly.getText());
		log.info("AspirationPlus Monthly Cost: " +aspirationPMonthly.getText());
		this.setAspirationPlusMonthly(aspirationPMonthly.getText());
		this.setAspirationPlusYearly(aspirationPMonthly.getText());
	}
	@FindBy(how = How.XPATH, using = "//*[@id=\"__next\"]/div/div[4]/section[2]/div/div[1]/ul/li[8]/div[1]/div[2]")
	WebElement aspirationOption1;
	@FindBy(how = How.CLASS_NAME, using = "Image-sc-it4irs-0")
	WebElement aspirationOptionImage;
	@FindBy(how = How.XPATH, using = "//*[@id=\"__next\"]/div/div[4]/section[2]/div/div[1]/ul/li[9]/div[1]/div[2]")
	WebElement aspirationOption2;
	@FindBy(how = How.XPATH, using = "//*[@id=\"__next\"]/div/div[4]/section[2]/div/div[1]/ul/li[10]/div[1]/div[2]")
	WebElement aspirationOption3;
	@FindBy(how = How.XPATH, using = "//*[@id=\"__next\"]/div/div[4]/section[2]/div/div[1]/ul/li[8]/div[1]/div[3]")
	WebElement aspirationPlusOption1;
	@FindBy(how = How.CLASS_NAME, using = "Image-sc-it4irs-0")
	WebElement aspirationPlusOptionImage;
	@FindBy(how = How.XPATH, using = "//*[@id=\"__next\"]/div/div[4]/section[2]/div/div[1]/ul/li[9]/div[1]/div[3]")
	WebElement aspirationPlusOption2;
//	@FindBy(how = How.XPATH, using = "Image-sc-it4irs-0")
//	WebElement aspirationPlusOption2Image;
	@FindBy(how = How.XPATH, using = "//*[@id=\"__next\"]/div/div[4]/section[2]/div/div[1]/ul/li[10]/div[1]/div[3]")
	WebElement aspirationPlusOption3;
//	@FindBy(how = How.XPATH, using = "//*[@id=\"__next\"]/div/div[4]/section[2]/div/div[1]/ul/li[10]/div[1]/div[3]/img")
//	WebElement aspirationPlusOption3Image;
	public void isOptionChecked() {
		log.info("Inside isOptionChecked");
		
		try {
		boolean aspirationPlusVisible = aspirationPlusOption1.findElement(By.className("Image-sc-it4irs-0")).isDisplayed();		
		this.setAspPlus(aspirationPlusVisible);
		log.info(aspirationPlusVisible);	
		}catch(NoSuchElementException e) {
			log.info("No Element Found");
			this.setAsp(false);
		}
		try {
			boolean aspirationVisible = aspirationOption1.findElement(By.className("Image-sc-it4irs-0")).isDisplayed();			
			this.setAsp(aspirationVisible);
			log.info(aspirationVisible);		
		}catch(NoSuchElementException e) {
			log.info("No Element Found");
			this.setAsp(false);
		}
		try {
			boolean aspirationPlusVisible = aspirationPlusOption2.findElement(By.className("Image-sc-it4irs-0")).isDisplayed();		
			this.setAspPlus(aspirationPlusVisible);
			log.info(aspirationPlusVisible);	
			}catch(NoSuchElementException e) {
				log.info("No Element Found");
				this.setAsp(false);
			}
			try {
				boolean aspirationVisible = aspirationOption2.findElement(By.className("Image-sc-it4irs-0")).isDisplayed();			
				this.setAsp(aspirationVisible);
				log.info(aspirationVisible);		
			}catch(NoSuchElementException e) {
				log.info("No Element Found");
				this.setAsp(false);
			}
			try {
				boolean aspirationPlusVisible = aspirationPlusOption3.findElement(By.className("Image-sc-it4irs-0")).isDisplayed();		
				this.setAspPlus(aspirationPlusVisible);
				log.info(aspirationPlusVisible);	
				}catch(NoSuchElementException e) {
					log.info("No Element Found");
					this.setAsp(false);
				}
				try {
					boolean aspirationVisible = aspirationOption3.findElement(By.className("Image-sc-it4irs-0")).isDisplayed();			
					this.setAsp(aspirationVisible);
					log.info(aspirationVisible);		
				}catch(NoSuchElementException e) {
					log.info("No Element Found");
					this.setAsp(false);
				}
		
	}
	
	public String getAspirationPlusYearly() {
		return aspirationPYearly.getText();
	}
	public void setAspirationPlusYearly(String aspirationPlusYearly) {
		this.aspirationPlusYearly = aspirationPlusYearly;
	}
	public String getAspirationPlusMonthly() {
		return aspirationPMonthly.getText();
	}
	public void setAspirationPlusMonthly(String aspirationPlusMonthly) {
		this.aspirationPlusMonthly = aspirationPlusMonthly;
	}
	public List<String> getProducts() {
		return products;
	}
	public void setProducts(List<String> products) {
		this.products = products;
	}

	public List<Boolean> getAspPlus() {
		return aspPlus;
	}

	public void setAspPlus(Boolean aspPlus) {
		this.aspPlus.add(aspPlus);
	}

	public List<Boolean> getAsp() {
		return asp;
	}

	public void setAsp(Boolean asp) {
		this.asp.add(asp);
	}	
	
	
}
