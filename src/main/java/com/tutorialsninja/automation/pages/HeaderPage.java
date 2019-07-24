package com.tutorialsninja.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialsninja.automation.base.Base;
import com.tutorialsninja.automation.framework.Browser;
import com.tutorialsninja.automation.framework.Elements;

public class HeaderPage {
	
	Browser browser = new Browser();
	
	public HeaderPage() {
		PageFactory.initElements(Base.driver, this);
	}

	@FindBy(xpath="//span[text()=\"My Account\"]")
	public static WebElement myAccountLink;
	
	@FindBy(linkText="Register")
	public static WebElement register;
	
	@FindBy(linkText="Login")
	public static WebElement login;
	
	@FindBy(name="search")
	public static WebElement searchboxField;
	
	@FindBy(css="button[class$='btn-lg']")
	public static WebElement searchboxsubmit;
	
	
	@FindBy(xpath="//span[contains(text(),'Shopping Cart')]")
	public static WebElement shoppingCart;
	
	public static void navigateToLoginPage() {
		Browser.openApplication();
    	Elements.click(myAccountLink);
    	Elements.click(login);
	}
	
	public static void searchProduct() {
		Elements.TypeText(searchboxField,Base.reader.getProduct());
    	Elements.click(searchboxsubmit);
	}
	
	public static void navigateToShoppingCart() {
		Elements.click(HeaderPage.shoppingCart);
	}
	
	
}
