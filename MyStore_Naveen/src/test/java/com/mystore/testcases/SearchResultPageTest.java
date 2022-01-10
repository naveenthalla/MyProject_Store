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
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultsPage;

/**
 * @author NaveenGoudThalla
 *
 */
public class SearchResultPageTest extends BaseClass{
	
	IndexPage indexPage;
	SearchResultsPage searchResultsPage;
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}	
	
	@Test
	public void productAvialabilityTest() {
		
		indexPage= new IndexPage();
		searchResultsPage=indexPage.searchProduct(prop.getProperty("productSearch"));
		boolean result=searchResultsPage.isProductAvailable();
		Assert.assertTrue(result);
		
		
	}
	
	

}
