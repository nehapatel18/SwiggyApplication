package SeleniumGrid;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumDriver {
    WebDriver driver = null;
    static final String browserType = "REMOTE";

    public WebDriver getDriver() {
        if (driver == null) {
            try {
                setupDriver();
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
        return driver;
    }

    public void setupDriver() throws  Throwable{
        String browserType = Configuration.getProperty("browserType");
        switch (browserType) {
            case "CHROME":
                System.out.println("RUNNING CHROME BROWSER");
                driver = setupChromeDriver();
            case "FIREFOX":
                System.out.println("RUNNING FIREFOX BROWSER");
                break;
            case "REMOTE":
                System.out.println("RUNNING REMOTE BROWSER");
                setupRemoteWebdriver();
        }

    }
    private void setupRemoteWebdriver() {
        URL url = null;
        try {
            url = new URL("http://192.168.1.8:4444/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setBrowserName("chrome");
        caps.setPlatform(Platform.WINDOWS);
        driver = new RemoteWebDriver(url,caps);
    }

     public WebDriver setupChromeDriver(){
         String projectFolderPath=System.getProperty("user.dir");
         String chromeDriverPath = projectFolderPath + "/src/test/resources/drivers/chromedriver.exe";
         System.setProperty("webdriver.chrome.driver",chromeDriverPath);
         return new ChromeDriver();

     }

}
