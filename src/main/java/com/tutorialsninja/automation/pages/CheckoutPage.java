package com.tutorialsninja.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialsninja.automation.base.Base;
import com.tutorialsninja.automation.framework.Elements;

public class CheckoutPage {
	
	Elements elements = new Elements();
	
	public CheckoutPage() {
		PageFactory.initElements(Base.driver, this);
	}

	@FindBy(id = "button-payment-address")
	public static WebElement continueBillingDetailsButton;
	
	@FindBy(id="button-shipping-address")
	public static WebElement continueDeliveryDetailsButton;
	
	@FindBy(id="button-shipping-method")
	public static WebElement continueDeliveryMethodButton;
	
	@FindBy(xpath="//input[@name='agree']")
	public static WebElement termsConditonsCheckbox;
	
	@FindBy(id="button-payment-method")
	public static WebElement continuepaymentMethodButton;
	
	@FindBy(id="button-confirm")
	public static WebElement confirmButton;
	
	
	public static void placeOrder() {
		Elements.click(continueBillingDetailsButton);
		Elements.click(continueDeliveryDetailsButton);
		Elements.click(continueDeliveryMethodButton);
		Elements.click(termsConditonsCheckbox);
		Elements.click(continuepaymentMethodButton);
		Elements.click(confirmButton);
		
	}
}
