package hooks;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import Driverfactory.DriverFactory;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import utilities.ConfigReader;

import java.time.Duration;

public class Hooks extends DriverFactory {
    private static final Logger logger = LogManager.getLogger(Hooks.class);
    private static WebDriver driver;
    private static DriverFactory driverFactory;

    @BeforeAll
    public static void setup() {
        // Load properties
        Properties prop = new ConfigReader().intializeProperties();

        // Launch browser
        initializeBrowser(prop.getProperty("browser"));
        driver = DriverFactory.getDriver();

        // Navigate to application
        driver.get(prop.getProperty("baseUrl"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
//        try {
//        // Login flow
//        driver.findElement(By.xpath("//*[@placeholder='Email Address']")).sendKeys(ReadData.readdata("username"));
//        driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys(ReadData.readdata("userpassword"));
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//button[text()='Sign in']")).click();
//    }catch (Exception e) {
//        logger.warn("Login step skipped or failed: " + e.getMessage());
//    }

    }
}