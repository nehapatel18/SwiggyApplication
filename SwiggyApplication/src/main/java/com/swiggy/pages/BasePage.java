package com.swiggy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    WebDriver driver;

    public void click(By byObject){
        driver.findElement(byObject).click();
    }
    public String getPageTitle(){
        return  driver.getTitle();
    }

    
}
