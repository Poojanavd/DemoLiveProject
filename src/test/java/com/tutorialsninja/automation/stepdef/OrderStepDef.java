package com.tutorialsninja.automation.stepdef;

import org.junit.runner.RunWith;

import com.tutorialsninja.automation.base.Base;
import com.tutorialsninja.automation.framework.Elements;
import com.tutorialsninja.automation.framework.Waits;
import com.tutorialsninja.automation.pages.CheckoutPage;
import com.tutorialsninja.automation.pages.HeaderPage;
import com.tutorialsninja.automation.pages.LoginPage;
import com.tutorialsninja.automation.pages.OrderSuccessPage;
import com.tutorialsninja.automation.pages.SearchResultsPage;
import com.tutorialsninja.automation.pages.ShoppingCart;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
public class OrderStepDef {

	HeaderPage headerPage = new HeaderPage();
	LoginPage loginPage = new LoginPage();
	SearchResultsPage searchResultsPage = new SearchResultsPage();
	ShoppingCart shoppingCart = new ShoppingCart();
	CheckoutPage checkoutPage = new CheckoutPage();
	OrderSuccessPage ordersuccesspage = new OrderSuccessPage();

	@Given("^I login to the application$")
	public void i_login_to_the_application() {
		HeaderPage.navigateToLoginPage();
		LoginPage.doLogin();
	}

	@When("^I add any product to Bag and checkout$")
	public void i_add_any_product_to_bag_and_checkout() {
		HeaderPage.searchProduct();
		SearchResultsPage.addFirstProducttoCart();
		HeaderPage.navigateToShoppingCart();
		Elements.click(ShoppingCart.checkoutButton);
	}

	@Then("^I should see that the order is placed successfully$")
	public void i_should_see_that_the_order_is_placed_successfully() {
		Waits.waitUntilElementLocated(10, OrderSuccessPage.successBreadcrumb);
		Elements.isDisplayed(OrderSuccessPage.successBreadcrumb);
	}

	@And("^I place an order$")
	public void i_place_an_order() {
		CheckoutPage.placeOrder();
	}

}