package org.swiggy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class SwiggyWithTestNG2 {
    WebDriver driver = null;
    By by_link_Sing_up = By.xpath ("//a[@class='r2iyh']");
    By by_txt_Phone_number = By.id("mobile");
    By by_txt_Name = By.id("name");
    By by_txt_Email = By.id("email");
    By by_txt_Password = By.id("password");
    By by_continue_Button = By.xpath("//a[@class='a-ayg']");



    @BeforeClass
    public void beforeClassSetup() {

        String chromeDriverPath = "F:\\selenium1\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
    }
    @Test
    public  void openSwiggy() throws Throwable {
        driver.get("https://www.swiggy.com/");
        Thread.sleep(5000);
        WebElement element=driver.findElement (by_link_Sing_up);
        element.click();
    }

    @Test (dependsOnMethods = "openSwiggy")
    public void SingupSwiggy() throws Throwable {

        Thread.sleep(5000);
        WebElement Phonenumber=driver.findElement(by_txt_Phone_number);
        WebElement Name=driver.findElement(by_txt_Name);
        WebElement Email=driver.findElement(by_txt_Email);
        WebElement Password=driver.findElement(by_txt_Password);
        WebElement continueButton=driver.findElement(by_continue_Button);



        Phonenumber.sendKeys("1234567890");
        Name.sendKeys("neha patel");
        Email.sendKeys("nehapatel18@gmail.com");
        Password.sendKeys("123@abc");
        continueButton.click();
    }


    @AfterClass
    public void teardown() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}




