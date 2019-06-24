package com.tutorialsninja.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialsninja.automation.base.Base;

public class HeaderPage {
	
	public HeaderPage() {
		PageFactory.initElements(Base.driver, this);
	}

	@FindBy(xpath="//span[text()=\"My Account\"]")
	public static WebElement myAccountLink;
	
	@FindBy(linkText="Register")
	public static WebElement register;
	
	
	
	
}
