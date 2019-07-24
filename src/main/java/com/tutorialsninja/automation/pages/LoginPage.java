package com.tutorialsninja.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialsninja.automation.base.Base;
import com.tutorialsninja.automation.framework.Elements;

public class LoginPage {

	public LoginPage() {
		PageFactory.initElements(Base.driver, this);
	}

	@FindBy(id = "input-email")
	public static WebElement emailField;

	@FindBy(id = "input-password")
	public static WebElement passwordField;

	@FindBy(xpath = "//input[@class='btn btn-primary']")
	public static WebElement loginButton;

	@FindBy(css = "div[class$='alert-dismissible']")
	public static WebElement loginPageMainWarning;

	@FindBy(linkText = "Forgotten Password")
	public static WebElement loginForgottonPassword;
	
	@FindBy(css="div[class$='alert-dismissible']")
	public static WebElement forgotPasswordSuccess;

	public static void doLogin(String email, String password) {
		Elements.TypeText(LoginPage.emailField, email);
		Elements.TypeText(LoginPage.passwordField, password);
		Elements.click(LoginPage.loginButton);
	}
}
