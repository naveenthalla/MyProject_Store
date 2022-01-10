/**
 * 
 */
package com.mystore.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultsPage;

import junit.framework.Assert;

/**
 * @author NaveenGoudThalla
 *
 */
public class OrderPageTest extends BaseClass {
	
	
	IndexPage indexPage;
	SearchResultsPage searchResultsPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}	
	
	@Test(groups="Regression")
	public void verifyTotalPrice() throws Throwable {
		
		indexPage = new IndexPage();
		searchResultsPage=indexPage.searchProduct(prop.getProperty("productSearch"));
		addToCartPage=searchResultsPage.clickOnProduct();
		addToCartPage.enterQuantity("2");
		addToCartPage.seletSize("M");
		addToCartPage.clickOnAddToCart();
		orderPage=addToCartPage.clickOnCheckOut();
		
		Double unitPrice=	orderPage.getUnitPrice();
		
		Double totalPrice=orderPage.getTotalPrice();
		
		Double totalExpectedPrice=(unitPrice*2)+2;
		
		Assert.assertEquals(totalPrice, totalExpectedPrice);
	}

}
