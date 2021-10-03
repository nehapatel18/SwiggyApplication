package com.swiggy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    By txt_phone_number = By.xpath("//*[@id=\"mobile\"]");
    By btn_login = By.xpath("//a[@class='a-ayg']");
    By txt_otp=By.xpath("//*[@id=\"otp\"]");
    By btn_verify_otp=By.xpath("//a[@class='a-ayg']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setPhoneNumber(String phonenumber) {
        driver.findElement(txt_phone_number).sendKeys(phonenumber);

    }


    public void clickLogin() {
        driver.findElement(btn_login).click();
    }




    public void userEntersOtp(String Otp) {
        driver.findElement(txt_otp).sendKeys(Otp);
    }

    public void clickVerifyOtp() {
        driver.findElement(btn_verify_otp).click();
    }
}