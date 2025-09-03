package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage {
    private  WebDriver driver;
    
    // Locators (update IDs/XPaths as per your app)
    private final By welcomeText = By.xpath("//h5[text()='Welcome to']"); // change to your real locator
    private final By getStartedBtn = By.xpath("//button[text()='Get Started']");
    

    public WelcomePage(WebDriver driver) { this.driver = driver; }

    public boolean getWelcomeMessage() {
    	try {
			Thread.sleep(2000);
			boolean flag=  driver.findElement(welcomeText).isDisplayed();
			System.out.println(flag);
			return flag;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println(" Welcome Not displayed ");
		return false;
		
       
    }
    
    public void clickGetStarted() {
        driver.findElement(getStartedBtn).click();
    }
}
