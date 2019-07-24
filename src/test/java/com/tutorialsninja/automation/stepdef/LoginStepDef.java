package com.tutorialsninja.automation.stepdef;

import org.junit.Assert;
import org.junit.runner.RunWith;

import com.tutorialsninja.automation.framework.Elements;
import com.tutorialsninja.automation.pages.ForgotPasswordPage;
import com.tutorialsninja.automation.pages.HeaderPage;
import com.tutorialsninja.automation.pages.LoginPage;
import com.tutorialsninja.automation.pages.MyAccountPage;
import com.tutorialsninja.automation.pages.RegisterPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
public class LoginStepDef {

	HeaderPage headerPage = new HeaderPage();
	MyAccountPage myaccountPage = new MyAccountPage();
	LoginPage loginPage = new LoginPage();
	RegisterPage registerPage = new RegisterPage();
	ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();

	@When("^I login to the application using Username \"([^\"]*)\" and Password \"([^\"]*)\"$")
	public void i_login_to_the_application_using_username_something_and_password_something(String email,
			String password) {
		LoginPage.doLogin(email, password);
	}

	@Then("^I should see that the User is able to successfully login$")
	public void i_should_see_that_the_user_is_able_to_successfully_login() {
		Assert.assertTrue(Elements.isDisplayed(MyAccountPage.registerAffiliateAccount));
	}

	@And("^I navigate to Account Login page$")
	public void i_navigate_to_account_login_page() {
		Elements.click(HeaderPage.myAccountLink);
		Elements.click(HeaderPage.login);
	}

	@Then("^I should see an error message informing the User about invalid credentials$")
	public void i_should_see_an_error_message_informing_the_user_about_invalid_credentials() {
		Assert.assertTrue(Elements.VerifyTextEquals(LoginPage.loginPageMainWarning,
				"Warning: No match for E-Mail Address and/or Password."));
	}

	@When("^I reset the forgotten password for \"([^\"]*)\"$")
	public void i_reset_the_forgotten_password_for_something(String email) {
		Elements.click(LoginPage.loginForgottonPassword);
		Assert.assertTrue(Elements.isDisplayed(ForgotPasswordPage.BreadcrumbForgotPasswword));
		Elements.TypeText(ForgotPasswordPage.emailid, email);
		Elements.click(ForgotPasswordPage.continueButton);
	}

	@Then("^I should see a message informing that the password reset details have been sent to the email address$")
	public void i_should_see_a_message_informing_that_the_password_reset_details_have_been_sent_to_the_email_address() {
		Assert.assertTrue(Elements.VerifyTextEquals(LoginPage.forgotPasswordSuccess, "An email with a confirmation link has been sent your email address."));
	}

}