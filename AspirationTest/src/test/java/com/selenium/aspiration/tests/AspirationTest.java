package com.selenium.aspiration.tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.selenium.aspiration.pages.AspirationGetAccountPage;
import com.selenium.aspiration.pages.AspirationHomePage;

public class AspirationTest extends TestBase{

	@Test	
	@Ignore
	public void testViewProducts() {
		AspirationHomePage aspHome = PageFactory.initElements(driver, AspirationHomePage.class);
		AspirationGetAccountPage aspAcct = PageFactory.initElements(driver, AspirationGetAccountPage.class);
		
		aspHome.clickIndividualSolution();	
		aspAcct.viewProducts();
		Assert.assertEquals(aspAcct.getProducts().size()-1, 2); // check the number of products in page				
	}
	
	@Test	
	@Ignore
	public void testSignIn() {
		AspirationHomePage aspHome = PageFactory.initElements(driver, AspirationHomePage.class);		
		aspHome.clickSignInButton();		
	}
	
	@Test
	
	public void testGettingStarted() {
		AspirationHomePage aspHome = PageFactory.initElements(driver, AspirationHomePage.class);
		String email = System.getenv("DUMMYEMAIL");
		aspHome.clickGettingStartedButton();
		aspHome.setEmail(email);
		aspHome.clickGettingStartedButton2();		
	}
	
	@Test
	@Ignore
	public void testProductPrices() {
	AspirationHomePage aspHome = PageFactory.initElements(driver, AspirationHomePage.class);
	AspirationGetAccountPage agap = PageFactory.initElements(driver, AspirationGetAccountPage.class);
	aspHome.clickIndividualSolution();	
	agap.storeCosts();
	Assert.assertEquals(agap.getAspirationPlusMonthly(), "$7.99/mo");
	Assert.assertEquals(agap.getAspirationPlusYearly(), "$5.99/mo if you pay annually");
	}
	
	@Test
	@Ignore
	public void testIsOptionsChecked() {
		AspirationGetAccountPage agap = PageFactory.initElements(driver, AspirationGetAccountPage.class);
		AspirationHomePage aspHome = PageFactory.initElements(driver, AspirationHomePage.class);
		aspHome.clickIndividualSolution();
		agap.isOptionChecked();		
		
		// check 8th option
		Assert.assertEquals(agap.getAspPlus().get(0), true);
		Assert.assertEquals(agap.getAsp().get(0), false);
		// check 9th option
		Assert.assertEquals(agap.getAspPlus().get(1), true);
		Assert.assertEquals(agap.getAsp().get(1), false);
		// check 10th option
		Assert.assertEquals(agap.getAspPlus().get(2), true);
		Assert.assertEquals(agap.getAsp().get(2), false);
		
	}
	
}
