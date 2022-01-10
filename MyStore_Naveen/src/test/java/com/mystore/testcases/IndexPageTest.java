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

/**
 * @author NaveenGoudThalla
 *
 */
public class IndexPageTest extends BaseClass {
	
	IndexPage indexPage;
	
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
	
	@Test(groups="Smoke")
	
	public void verifyLogo() {
		indexPage = new IndexPage();
		boolean result = indexPage.validateLogo();
		Assert.assertTrue(result);
	}
	@Test(groups="Smoke")
	public void verifyTitle() {
		
		String acttitle=indexPage.getMyStoreTitle();
		Assert.assertEquals(acttitle,"My Store" );
	}

}
