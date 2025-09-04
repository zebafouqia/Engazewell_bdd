package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.WelcomePage;
import Driverfactory.DriverFactory;
import utilities.ConfigReader;
import java.util.Properties;

public class WelcomeSteps {
    
    private WelcomePage welcomePage;
    private Properties prop;
    
    public WelcomeSteps() {
        this.welcomePage = new WelcomePage(DriverFactory.getDriver());
        this.prop = new ConfigReader().intializeProperties();
    }
    
    @Then("I should see the welcome message {string}")
    public void i_should_see_the_welcome_message(String expectedMessage) {
        // Wait for and verify the welcome message is displayed
        boolean isDisplayed = welcomePage.isWelcomeMessageDisplayed();
        Assert.assertTrue(isDisplayed, "Welcome message should be displayed");
        
        // Also verify the text content if needed
        String actualText = welcomePage.getWelcomeMessageText();
        Assert.assertTrue(actualText.contains(expectedMessage), 
            "Expected welcome message to contain: " + expectedMessage + " but was: " + actualText);
    }
    
    @And("I click on Get Started button")
    public void i_click_on_get_started_button() {
        welcomePage.clickGetStarted();
    }
}