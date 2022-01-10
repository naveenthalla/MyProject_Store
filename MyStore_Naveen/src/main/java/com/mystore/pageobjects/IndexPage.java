package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass{
	
	@FindBy(xpath ="//a[@class=\"login\"]")
	WebElement signInbtn;
	
	@FindBy(xpath ="//img[@class='logo img-responsive']")
	WebElement myStoreLogo;
	
	@FindBy(xpath="//input[@id='search_query_top']")
	WebElement searchProductBox;
	
	@FindBy(name = "submit_search")
	WebElement searchButton;
	

	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public LoginPage clickOnSignIn() {
		Action.fluentWait(getDriver(),signInbtn,10);
		Action.click(getDriver(),signInbtn);
		return new LoginPage();
		
	}
	public boolean validateLogo() {
		return Action.isDisplayed(getDriver(),myStoreLogo);
	}
	public String getMyStoreTitle() {
		String myStoreTitle=getDriver().getTitle();
		return myStoreTitle;
		
	}
	public SearchResultsPage searchProduct(String productName) {
		Action.type(searchProductBox, productName);
		Action.click(getDriver(), searchButton);
		return new SearchResultsPage();
		
	}
	
	
	
	
	
}
 