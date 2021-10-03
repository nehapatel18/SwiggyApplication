package org.swiggy;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SwiggyWithTestNG3 {
    WebDriver driver = null;
    By by_link_Sing_up = By.xpath("//a[@class='r2iyh']");
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

    @DataProvider(name = "SingupUsers")
    public Object[][] dpMethod() {
        return new Object[][]{{"phonenuber1", "name1", "email1", "pass1"}, {"phonenuber2", "name2", "email2", "pass2"}};
    }

    @Test
    public void openSwiggy() throws Throwable {
        driver.get("https://www.swiggy.com/");
        Thread.sleep(5000);
        WebElement element = driver.findElement(by_link_Sing_up);
        element.click();
    }

    @Test(dependsOnMethods = "openSwiggy", dataProvider = "SingupUsers")
    public void SingupSwiggy(String _phonenuber, String _name, String _email, String _password) throws Throwable {

        Thread.sleep(5000);

        WebElement Phonenumber = driver.findElement(by_txt_Phone_number);
        WebElement Name = driver.findElement(by_txt_Name);
        WebElement Email = driver.findElement(by_txt_Email);
        WebElement Password = driver.findElement(by_txt_Password);
        WebElement continueButton = driver.findElement(by_continue_Button);


        Phonenumber.clear();
        Name.clear();
        Email.clear();
        Password.clear();
        Phonenumber.sendKeys(_phonenuber);
        Name.sendKeys(_name);
        Email.sendKeys(_email);
        Password.sendKeys(_password);
        continueButton.click();
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}





