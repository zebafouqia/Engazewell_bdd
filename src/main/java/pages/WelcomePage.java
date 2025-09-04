package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WelcomePage {
    private WebDriver driver;
    private WebDriverWait wait;
    
    // Locators
    private final By welcomeText = By.xpath("//h5[text()='Welcome to']");
    private final By getStartedBtn = By.xpath("//button[text()='Get Started']");
    

    public WelcomePage(WebDriver driver) { 
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public boolean isWelcomeMessageDisplayed() {
        try {
            WebElement welcomeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeText));
            return welcomeElement.isDisplayed();
        } catch (Exception e) {
            System.out.println("Welcome message not displayed: " + e.getMessage());
            return false;
        }
    }
    
    public String getWelcomeMessageText() {
        try {
            WebElement welcomeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeText));
            return welcomeElement.getText();
        } catch (Exception e) {
            System.out.println("Could not get welcome message text: " + e.getMessage());
            return "";
        }
    }
    
    public void clickGetStarted() {
        try {
            WebElement getStartedElement = wait.until(ExpectedConditions.elementToBeClickable(getStartedBtn));
            getStartedElement.click();
        } catch (Exception e) {
            System.out.println("Could not click Get Started button: " + e.getMessage());
            throw new RuntimeException("Get Started button not clickable: " + e.getMessage());
        }
    }
    
    public boolean isGetStartedButtonDisplayed() {
        try {
            WebElement buttonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(getStartedBtn));
            return buttonElement.isDisplayed();
        } catch (Exception e) {
            System.out.println("Get Started button not displayed: " + e.getMessage());
            return false;
        }
    }
}