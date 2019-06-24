package com.tutorialsninja.automation.stepdef;

import org.junit.runner.RunWith;

import com.tutorialsninja.automation.base.Base;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
public class RegisterStepDef {

    @Given("^I launch the application$")
    public void i_launch_the_application(){
      Base.driver.get(Base.reader.getUrl());
    }

    @When("^I provide all the below valid details$")
    public void i_provide_all_the_below_valid_details(DataTable dataTable){
        
    }

    @Then("^I should see that the User Account has successfully created$")
    public void i_should_see_that_the_user_account_has_successfully_created() {
        
    }

    @And("^I navigate to Account Registration page$")
    public void i_navigate_to_account_registration_page(){
       
    }

    @And("^I select the Privacy Policy$")
    public void i_select_the_privacy_policy() {
       
    }

    @And("^I click on Continue button$")
    public void i_click_on_continue_button() {
        
    }

}