package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class CartPage extends TestBase {

	public CartPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='container']//div[@class='_2nQDXZ']/div//a")
	WebElement itemText;

	public String getItemText() {
		return itemText.getText();
	}

	public void navigateToMainWindow(String mainWindow) {
		driver.close();
		driver.switchTo().window(mainWindow);
	}

}
