package com.techbee.selenium.testng.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.techbee.selenium.testng.pages.EbayHomePage;

public class EbaySearchTest extends TestBase {

	@Test
	public void init() throws Exception {
		EbayHomePage ebayHome = PageFactory.initElements(driver, EbayHomePage.class);
		ebayHome.setItemSearch("iphone");
		ebayHome.clickSearch();
		Thread.sleep(4000);
		ebayHome.saveToFile();
	}
}
