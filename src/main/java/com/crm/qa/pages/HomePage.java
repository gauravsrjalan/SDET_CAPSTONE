package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='fbDBuK _3CYmv5']/div/span")
	WebElement closeLoginPopUp;

	@FindBy(xpath = "//div//a/img[@class='aqQN50']")
	WebElement logo;

	@FindBy(xpath = "//input[@name='q']")
	WebElement search;

	@FindBy(xpath = "//div/button/*[local-name()='svg']")
	WebElement clickSearch;

	@FindBy(xpath = "//div[@id='container']//div[@class='_4rR01T']")
	WebElement clickFirstLink;

	@FindBy(xpath = "//div[@id='container']//div[2]/div/ul/li/button")
	WebElement addToCart;

	public void closeLoginPopUp() {
		closeLoginPopUp.click();
	}

	public boolean isLogoDisplayed() {
		return logo.isDisplayed();
	}

	public void enterSearchTest(String searchText) {
		search.sendKeys(searchText);
	}

	public void clickSearch() {
		clickSearch.click();
	}

}
