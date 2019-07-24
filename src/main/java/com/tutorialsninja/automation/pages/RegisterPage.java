package com.tutorialsninja.automation.pages;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialsninja.automation.base.Base;
import com.tutorialsninja.automation.framework.Elements;

import cucumber.api.DataTable;

public class RegisterPage {

	public RegisterPage() {
		PageFactory.initElements(Base.driver, this);
	}

	@FindBy(id = "input-firstname")
	public static WebElement firstName;

	@FindBy(id = "input-lastname")
	public static WebElement lastName;

	@FindBy(id = "input-email")
	public static WebElement email;

	@FindBy(id = "input-telephone")
	public static WebElement telephone;

	@FindBy(id = "input-password")
	public static WebElement password;

	@FindBy(id = "input-confirm")
	public static WebElement confirmPassword;
	
	@FindBy(name="agree")
	public static WebElement privacyPolicy;
	
	@FindBy(xpath="//input[@value=\"Continue\"]")
	public static WebElement continueButton;
	
	@FindBy(linkText = "Register")
	public static WebElement registerBreadcrumb;
	
	@FindBy(css="input[id='input-firstname']+div")
	public static WebElement FirstNameWarning;
	
	@FindBy(css="input[id='input-lastname']+div")
	public static WebElement LastNameWarning;
	
	@FindBy(css="input[id='input-email']+div")
	public static WebElement EmailWarning;
	
	@FindBy(css="input[id='input-telephone']+div")
	public static WebElement TelephoneWarning;
	
	@FindBy(css="input[id='input-password']+div")
	public static WebElement PasswordWarning;
	
	@FindBy(css="div[class$='alert-dismissible']")
	public static WebElement MainWarning;
	
	@FindBy(css="input[name='newsletter'][value='1']")
	public static WebElement SubscribeButton;

	public static void enterAllRegistrationDetails(DataTable dataTable,String detailType) {
		Map<String, String> map = dataTable.asMap(String.class, String.class);

		Elements.TypeText(RegisterPage.firstName, map.get("FirstName"));
		Elements.TypeText(RegisterPage.lastName, map.get("LastName"));
		Elements.TypeText(RegisterPage.telephone, map.get("Telephone"));
		Elements.TypeText(RegisterPage.password, map.get("Password"));
		Elements.TypeText(RegisterPage.confirmPassword, map.get("Password"));
		
		if(detailType.equalsIgnoreCase("duplicate"))
			Elements.TypeText(RegisterPage.email, map.get("Email"));
		else
			Elements.TypeText(RegisterPage.email, System.currentTimeMillis()+map.get("Email"));
		
	}

}
