package com.crm.qa.pages;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class SearchResultPage extends TestBase {

	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//div[@id='container']//div[@class='_4rR01T']")
	WebElement clickFirstLink;
	
	@FindBy(xpath = "//div[@id='container']//div[2]/div/ul/li/button")
	WebElement addToCart;
    
	
	public void clickOnFirstLink() {
		clickFirstLink.click();
	}

	public String moveToNewTabAddToCart() {
		String mainWindow = driver.getWindowHandle();
		Set<String> s1 = driver.getWindowHandles();
	    Iterator<String> i1 = s1.iterator();
	    while (i1.hasNext()) {
            String ChildWindow = i1.next();
                if (!mainWindow.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                addToCart.click();
                System.out.println("Child window closed");
            }
        } 
	    return mainWindow;
	}

}
