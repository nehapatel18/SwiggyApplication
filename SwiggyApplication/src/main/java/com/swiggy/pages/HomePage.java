package com.swiggy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends BasePage {

    By btn_login=By.xpath("//a[@class='x4bK8']");
    String HOME_PAGE_URL="https://www.swiggy.com/";
    public  HomePage(WebDriver driver){
        this.driver=driver;
    }

    public  void  navigate(){
        driver.get(HOME_PAGE_URL);
    }
    public  void  clickLoginButton(){
        driver.findElement(btn_login).click();
    }

}