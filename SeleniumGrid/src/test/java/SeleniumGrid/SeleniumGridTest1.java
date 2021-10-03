package SeleniumGrid;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class SeleniumGridTest1 {
    public static  void main (String[] args) throws Throwable{
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setBrowserName("chrome");
        caps.setPlatform(Platform.WINDOWS);
        URL url = new URL("http://192.168.1.7:4444/wd/hub");
        WebDriver driver = new RemoteWebDriver(url,caps);
        driver.quit();

    }

}
