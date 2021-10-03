package com.swiggy.steps;

import com.swiggy.pages.SeleniumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {
    public static WebDriver driver=null;
    @Before
    public  void  beforeTest(){
        driver = new SeleniumDriver().getDriver();
        driver.manage().window().maximize();

    }
    @After
    public  void  afterTest(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();

    }
}
