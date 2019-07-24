package com.tutorialsninja.automation.stepdef;

import org.junit.runner.RunWith;

import com.tutorialsninja.automation.framework.Elements;
import com.tutorialsninja.automation.pages.HeaderPage;
import com.tutorialsninja.automation.pages.SearchResultsPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import org.junit.Assert;

@RunWith(Cucumber.class)
public class SearchStepDef {

	HeaderPage headerPage = new HeaderPage();
	SearchResultsPage searchResultsPage = new SearchResultsPage();

	@When("^I search for a product \"([^\"]*)\"$")
	public void i_search_for_a_product_something(String product) {
		Elements.TypeText(HeaderPage.searchboxField, product);
		Elements.click(HeaderPage.searchboxsubmit);
	}

	@Then("^I should see the product in the search results$")
	public void i_should_see_the_product_in_the_search_results() {
		Assert.assertTrue(Elements.isDisplayed(SearchResultsPage.samsungSyncMasterSearchResuls));
	}
	
	 @Then("^I should see the page displaying the message \"([^\"]*)\"$")
	    public void i_should_see_the_page_displaying_the_message_something(String message){
	   Assert.assertTrue(Elements.VerifyTextEquals(SearchResultsPage.noResultsMessage, message));
	    }

}