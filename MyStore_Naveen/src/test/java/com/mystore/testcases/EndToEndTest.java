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
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderConfirmationPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.OrderSummaryPage;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.SearchResultsPage;
import com.mystore.pageobjects.ShippingPage;

import junit.framework.Assert;

/**
 * @author NaveenGoudThalla
 *
 */
public class EndToEndTest extends BaseClass{
	
	IndexPage indexPage;
	SearchResultsPage searchResultsPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	LoginPage loginPage;
	AddressPage addressPage;
	ShippingPage shippingPage;
	PaymentPage paymentPage;
	OrderSummaryPage orderSummary;
	OrderConfirmationPage orderConfirmationPage;
	
	
//	@BeforeMethod
//	public void setup() {
//		launchApp();
//	}
	@Parameters("browser")
	
//	@BeforeMethod
//	public void setup(String browser) {
//		launchApp(browser);
//	}
//	

	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}	
	
	@Test(groups="Regression")
	public void endToEndTest() throws Throwable {
		
		indexPage = new IndexPage();
		searchResultsPage=indexPage.searchProduct(prop.getProperty("productSearch"));
		addToCartPage=searchResultsPage.clickOnProduct();
		addToCartPage.enterQuantity("2");
		addToCartPage.seletSize("M");
		addToCartPage.clickOnAddToCart();
		orderPage=addToCartPage.clickOnCheckOut();
		loginPage=orderPage.clickOnCheckOut();
		addressPage=loginPage.login1(prop.getProperty("username"),prop.getProperty("password"));
		shippingPage=	addressPage.clickOnCheckOut();
		shippingPage.checkTheTerms();
		paymentPage=shippingPage.clickOnProceedToCheckOut();
		orderSummary=paymentPage.clickOnPaymentMethod();
		orderConfirmationPage=orderSummary.clickOnConfirmOrderBtn();
		String actualMessage=orderConfirmationPage.validateConfirmMessage();
		String expectedMessage="Your order on My Store is complete.";
		Assert.assertEquals(actualMessage, expectedMessage);
		
		
		
	}

}
