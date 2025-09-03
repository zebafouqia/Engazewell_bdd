
package Driverfactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.Point;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.safari.SafariDriver;


public class DriverFactory {

    public static WebDriver driver;
    private static Logger logger = LogManager.getLogger(DriverFactory.class);

    public static void initializeBrowser(String browserName) {

        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--start-maximized");
            chromeOptions.addArguments("--disable-notifications");
//            chromeOptions.addArguments("--disable-gpu");
//            chromeOptions.addArguments("--disable-extensions");
            chromeOptions.addArguments("--incognito"); // Launch in incognito mode
            // Uncomment if you want headless mode
//             chromeOptions.addArguments("--headless=new");
             chromeOptions.addArguments("window-size=1920,1080"); 
            driver = new ChromeDriver(chromeOptions);
            logger.info("Chrome driver initialized in incognito mode");

        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            logger.info("Firefox driver initialized");

        } else if (browserName.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
            logger.info("Safari driver initialized");

        } else {
            throw new RuntimeException("Browser not supported: " + browserName);
        }

        // Set window position and timeouts
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }


    public static WebDriver getDriver() {
        return driver;
    }
}