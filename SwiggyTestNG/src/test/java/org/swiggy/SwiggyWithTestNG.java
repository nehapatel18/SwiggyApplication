package org.swiggy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SwiggyWithTestNG {
    WebDriver driver = null;


    @Test
    public  void Test1() throws Throwable {
        driver.get("https://www.swiggy.com/");
        Thread.sleep(5000);
        WebElement element=driver.findElement(By.xpath("//a[@class='r2iyh']"));
        element.click();
    }
    @BeforeClass
    public void beforeClassSetup() {
        String chromeDriverPath = "F:\\selenium\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
    }

    @AfterClass
    public void teardown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
