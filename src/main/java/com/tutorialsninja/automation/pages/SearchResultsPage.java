package com.tutorialsninja.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialsninja.automation.base.Base;
import com.tutorialsninja.automation.framework.Elements;

public class SearchResultsPage {
	public SearchResultsPage() {
		PageFactory.initElements(Base.driver, this);
	}

	@FindBy(linkText = "Samsung SyncMaster 941BW")
	public static WebElement samsungSyncMasterSearchResuls;

	@FindBy(css = "input[id='button-search']+h2+p")
	public static WebElement noResultsMessage;
	
	@FindBy(xpath="//span[contains(text(),'Add to Cart')]")
	public static WebElement FirstAddtoCart;
	
	public static void addFirstProducttoCart() {
		Elements.click(FirstAddtoCart);
	}
}
