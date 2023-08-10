package com.selenium.aspiration.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.selenium.aspiration.pages.AspirationHomePage;

public class AspirationTest extends TestBase{

	@Test
	public void testViewProducts() {
		AspirationHomePage aspHome = PageFactory.initElements(driver, AspirationHomePage.class);
		aspHome.clickIndividualSolution();
	}
	
}
