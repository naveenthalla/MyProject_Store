/**
 * 
 */
package com.mystore.testcases;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultsPage;

/**
 * @author NaveenGoudThalla
 *
 */
public class AddToCartPageTest extends BaseClass{
	
	IndexPage indexPage;
	SearchResultsPage searchResultsPage;
	AddToCartPage addToCartPage;
	
//	@BeforeMethod
//	public void setup() {
//		launchApp();
//	}
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}	
	
	@Test(groups={"Regression","Sanity"})
	public void addToTestCart() {
		
		indexPage=new IndexPage();
		searchResultsPage=indexPage.searchProduct(prop.getProperty("productSearch"));
		addToCartPage=searchResultsPage.clickOnProduct();
		addToCartPage.enterQuantity("2");
		addToCartPage.seletSize("M");
		addToCartPage.clickOnAddToCart();
		boolean result=addToCartPage.validateAddToCart();
		Assert.assertTrue(result);
		
		
		
	}
	
	
	
	

}
