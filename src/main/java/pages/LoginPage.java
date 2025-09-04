package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;
    
    private final By username = By.xpath("//input[@name='email']");   
    private final By password = By.xpath("//input[@name='password']");
    private final By loginBtn = By.xpath("//button[text()='Login']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void login(String user, String pass) {
        try {
            // Enter username
            WebElement usernameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(username));
            usernameElement.clear();
            usernameElement.sendKeys(user);
            
            // Enter password
            WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(password));
            passwordElement.clear();
            passwordElement.sendKeys(pass);
            
            // Click login button
            WebElement loginButtonElement = wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
            loginButtonElement.click();
            
        } catch (Exception e) {
            System.out.println("Login failed: " + e.getMessage());
            throw new RuntimeException("Login process failed: " + e.getMessage());
        }
    }
}