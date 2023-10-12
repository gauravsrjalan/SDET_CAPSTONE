package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.*;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.SearchResultPage;
import com.crm.qa.pages.AddToCartPage;
import com.crm.qa.pages.CartPage;
public class SearchItem extends TestBase {

	HomePage homepage;
	SearchResultPage searchresult;
	AddToCartPage itemaddpage;
	CartPage cartpage; 
	protected static Properties properties;
	
	public SearchItem() {
		super();
		try {
			properties = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com/crm/qa/config/config.properties");
			properties.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("file not found");
		} catch (IOException e) {
			System.out.println("io exception");

		}
	}

	@BeforeMethod
	@BeforeSuite(alwaysRun = true)
	public void setUp() {
		initializaton();
		homepage = new HomePage();
		searchresult = new SearchResultPage();
		itemaddpage = new AddToCartPage();
		cartpage = new CartPage();
	}

	@Test()
	public void verifyItemAddedToTheCart() {
		homepage.closeLoginPopUp();
		boolean flag = homepage.isLogoDisplayed();
		// AssertJUnit.assertTrue(flag);
		Assert.assertEquals(true, flag);
		homepage.enterSearchTest(properties.getProperty("search"));
		homepage.clickSearch();
		searchresult.clickOnFirstLink();
		String mainWindow = searchresult.moveToNewTabAddToCart();
		itemaddpage.clickOnAddToCart();
		String text = cartpage.getItemText();
		boolean bool = text.contains(properties.getProperty("search"));
		Assert.assertEquals(true, bool);
		cartpage.navigateToMainWindow(mainWindow);
	}	
	
	

	@AfterMethod
	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		// FormatResult();
		tearDownMain();
	}

}
