package com.swiggy.steps;

import com.swiggy.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class HomePageStepdefs {
    HomePage homePage=new HomePage(Hooks.driver);

    @Given("user has opend swiggy homepage")
    public void userHasOpendSwiggyHomepage() {
        System.out.println("opening home page");
        homePage.navigate();
    }

    @When("user click the login button")
    public void userClickTheLoginButton() {
    homePage.clickLoginButton();
    }
}
