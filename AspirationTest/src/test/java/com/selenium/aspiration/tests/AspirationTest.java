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
	@Ignore
	public void testGettingStarted() {
		AspirationHomePage aspHome = PageFactory.initElements(driver, AspirationHomePage.class);
		String email = System.getenv("DUMMYEMAIL");
		aspHome.clickGettingStartedButton();
		aspHome.setEmail(email);
		aspHome.clickGettingStartedButton2();		
	}
	
	@Test
	public void testProductPrices() {
		
	}
	
}
