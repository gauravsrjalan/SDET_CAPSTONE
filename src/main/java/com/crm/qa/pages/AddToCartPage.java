package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class AddToCartPage extends TestBase {

	
	public AddToCartPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='YUhWwv']/a")
	WebElement clickCart;


	public void clickOnAddToCart() {
		clickCart.click();
	}

	

}
