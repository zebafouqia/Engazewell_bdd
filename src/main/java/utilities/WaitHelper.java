package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Properties;

public class WaitHelper {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public WaitHelper(WebDriver driver) {
        this.driver = driver;

        // Load properties from ConfigReader
        ConfigReader configReader = new ConfigReader();
        Properties prop = configReader.intializeProperties();

        // Get wait times from properties file
        int implicitWait = Integer.parseInt(prop.getProperty("implicitWait"));
        int explicitWait = Integer.parseInt(prop.getProperty("explicitWait"));

        // Apply waits
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWait));
    }

    public WebElement waitForElementVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForElementClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
