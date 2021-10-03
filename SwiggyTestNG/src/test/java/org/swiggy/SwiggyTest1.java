package org.swiggy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwiggyTest1 {
    static WebDriver driver = null;

    public static void init() {
        String chromeDriverPath = "F:\\selenium\\chromedriver_win32\\chromedriver.exe";

        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

    }
    public static void test1() {
        driver.get("https://www.swiggy.com/");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public static void test2() {
        driver.get("https://www.amazon.in/ap/register?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3F_encoding%3DUTF8%26ref_%3Dnav_newcust&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    private static void closeBrowser() {
        driver.quit();
    }

    private static void createChromeDriver() {
        driver = new ChromeDriver();
    }



    public static void main(String[] args) {
        init();


        createChromeDriver();

        //driver.close();
        test1();
        test2();
        closeBrowser();

    }

}
