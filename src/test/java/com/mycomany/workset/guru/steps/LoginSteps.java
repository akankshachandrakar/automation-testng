package com.mycomany.workset.guru.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {
	@Given("^I am on login page$")
	public void i_am_on_login_page() throws Throwable {
		System.out.println("i am in given");
		//throw new PendingException();
	}

	@And("^I enter username and password$")
	public void i_enter_username_and_password() throws Throwable {
		System.out.println("i am in when");
		//throw new PendingException();
	} 

	@Then("^he should homepage should be displayed$")
	public void homepage_should_be_displayed() throws Throwable {
		System.out.println("i am in then");
		//throw new PendingException();
	}

	@When("^I click on sumbit button$")
	public void i_click_on_sumbit_button() throws Throwable {
		System.out.println("i am in and");
		//throw new PendingException();
	}

}
