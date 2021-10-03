package com.swiggy.steps;

import com.swiggy.pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;


import java.util.Map;

public class loginStepdefs {
    LoginPage loginPage=new LoginPage(Hooks.driver);



    @Then("user enter following details")
    public void userEnterFollowingDetails(DataTable dataTable) {
        Map<String,String> dataMap =dataTable.asMap(String.class,String.class);
        String phonenumber= dataMap.get("login phone number");
        loginPage.setPhoneNumber(phonenumber);


    }

    @And("clicks on login button")
    public void clicksOnLoginButton() {
        loginPage.clickLogin();
    }

    @And("user enter otp")
    public void userEnterOtp(DataTable dataTable) {
        Map<String,String> dataMap =dataTable.asMap(String.class,String.class);
        String Otp= dataMap.get("user enter otp");
        loginPage.userEntersOtp(Otp);
    }

    @Then("clicks on verify otp button")
    public void clicksOnVerifyOtpButton() {
        loginPage.clickVerifyOtp();
    }
}