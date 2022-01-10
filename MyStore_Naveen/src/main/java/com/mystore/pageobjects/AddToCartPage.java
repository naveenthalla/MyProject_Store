package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AddToCartPage extends BaseClass {
	
	@FindBy(id="quantity_wanted")
	WebElement quantity;
	
	@FindBy(name="group_1")
	WebElement size;
	
	@FindBy(xpath="//span[contains(text(),'Add to cart')]")
	WebElement addToCartBtn;
	
	@FindBy(xpath="//header/div[3]/div[1]/div[1]/div[4]/div[1]/div[1]/h2[1]")
	WebElement addToCartMessage;
	
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckOutBtn;
	
	public AddToCartPage() {
		
		PageFactory.initElements(getDriver(), this);
		}
	
	public void enterQuantity(String quantity1) {
		Action.type(quantity, quantity1);

}
	public void seletSize(String size1) {
		Action.selectByVisibleText(size1,size);
	}
	public void clickOnAddToCart() {
		Action.click(getDriver(), addToCartBtn);
		
	}
	public boolean validateAddToCart() {
		
		//It is good idea to add Fluent wait or waits in Page object clasess instead of Tests
		Action.fluentWait(getDriver(), addToCartMessage, 10);
		
		return Action.isDisplayed(getDriver(), addToCartMessage);
	
	}

	public OrderPage clickOnCheckOut() throws Throwable {
		
		Action.fluentWait(getDriver(), proceedToCheckOutBtn, 10);
		Action.JSClick(getDriver(), proceedToCheckOutBtn);
		
		return new OrderPage();
		
	}


}





