package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.WaitHelper;

public class LoginPage {
    private WebDriver driver;
    private WaitHelper wait;
    
    private final By username = By.xpath("//input[@name='email']");   
    private final By password = By.xpath("//input[@name='password']");
    private final By loginBtn = By.xpath("//button[text()='Login']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitHelper(driver); // uses timeout from config.properties
    }

   
    public void login(String user, String pass)  {
    	try {
			Thread.sleep(2000);
			driver.findElement(username).sendKeys(user);
	        Thread.sleep(2000);
	        driver.findElement(password).sendKeys(pass);
	        driver.findElement(loginBtn).click();
	        Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
}
 