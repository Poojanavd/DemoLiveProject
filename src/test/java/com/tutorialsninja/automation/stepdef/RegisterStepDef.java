package com.tutorialsninja.automation.stepdef;

import org.junit.Assert;
import org.junit.runner.RunWith;

import com.tutorialsninja.automation.base.Base;
import com.tutorialsninja.automation.framework.Elements;
import com.tutorialsninja.automation.pages.AccountSuccessPage;
import com.tutorialsninja.automation.pages.HeaderPage;
import com.tutorialsninja.automation.pages.RegisterPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
public class RegisterStepDef {

	HeaderPage headerPage = new HeaderPage();
	RegisterPage registerPage = new RegisterPage();
	AccountSuccessPage accountSuccessPage = new AccountSuccessPage();

	@Given("^I launch the application$")
	public void i_launch_the_application() {
		Base.driver.get(Base.reader.getUrl());
	}

	@When("^I provide all the below valid details$")
	public void i_provide_all_the_below_valid_details(DataTable dataTable) {
		RegisterPage.enterAllRegistrationDetails(dataTable, "unique");

	}

	@Then("^I should see that the User Account has successfully created$")
	public void i_should_see_that_the_user_account_has_successfully_created() {
		Assert.assertTrue(Elements.isDisplayed(AccountSuccessPage.successBreadCrumb));

	}

	@And("^I navigate to Account Registration page$")
	public void i_navigate_to_account_registration_page() {
		Elements.click(headerPage.myAccountLink);
		Elements.click(headerPage.register);
	}

	@And("^I select the Privacy Policy$")
	public void i_select_the_privacy_policy() {
		Elements.click(RegisterPage.privacyPolicy);
	}

	@And("^I click on Continue button$")
	public void i_click_on_continue_button() {
		Elements.click(RegisterPage.continueButton);
	}

	@Then("^I should see that the User Account is not created$")
	public void i_should_see_that_the_user_account_is_not_created() {
		Assert.assertTrue(Elements.isDisplayed(RegisterPage.registerBreadcrumb));
	}

	@And("^I should see the error messages informing the user to fill the mandatory fields$")
	public void i_should_see_the_error_messages_informing_the_user_to_fill_the_mandatory_fields() {
		Assert.assertTrue(Elements.isDisplayed(RegisterPage.FirstNameWarning));
		Assert.assertTrue(Elements.isDisplayed(RegisterPage.LastNameWarning));
		Assert.assertTrue(Elements.isDisplayed(RegisterPage.PasswordWarning));
		Assert.assertTrue(Elements.isDisplayed(RegisterPage.EmailWarning));
		Assert.assertTrue(Elements.isDisplayed(RegisterPage.TelephoneWarning));
		Assert.assertTrue(Elements.isDisplayed(RegisterPage.MainWarning));
	}

	@And("^I subscribe to Newsletter$")
	public void i_subscribe_to_Newsletter() {
		Elements.click(RegisterPage.SubscribeButton);
	}

	@When("^I provide the below duplicate details into the fields$")
	public void i_provide_the_below_duplicate_details_into_the_fields(DataTable dataTable) {
		RegisterPage.enterAllRegistrationDetails(dataTable, "duplicate");
	}

	@Then("^I should see the warning message stating that the user is already created$")
	public void i_should_see_the_warning_message_stating_that_the_user_is_already_created() {
		Assert.assertTrue(Elements.VerifyTextEquals(RegisterPage.MainWarning,"Warning: E-Mail Address is already registered!"));
	}

}