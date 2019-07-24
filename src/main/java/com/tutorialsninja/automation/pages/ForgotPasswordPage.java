package com.tutorialsninja.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialsninja.automation.base.Base;

public class ForgotPasswordPage {
	public ForgotPasswordPage() {
		PageFactory.initElements(Base.driver, this);
	}
	
	@FindBy(xpath="//ul[@class='breadcrumb']//a[contains(text(),'Forgotten Password')]")
	public static WebElement BreadcrumbForgotPasswword;
	
	@FindBy(id="input-email")
	public static WebElement emailid;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	public static WebElement continueButton;
	
	
}
