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
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

/**
 * @author NaveenGoudThalla
 *
 */
	public class LoginPageTest extends BaseClass {
		
		IndexPage indexPage;
		LoginPage loginPage;
		HomePage homePage;

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
	
	@Test(groups= {"Smoke","Sanity"})
	public void loginTest() {
		
		indexPage=new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		homePage =loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		String actualURL=homePage.getCurrentURL();
		String expectedURL="http://automationpractice.com/index.php?controller=my-account";
		Assert.assertEquals(actualURL, expectedURL);
		
	}
	
	
}
