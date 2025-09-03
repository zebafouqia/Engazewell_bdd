package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.WelcomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Properties;

import org.testng.Assert;

import Driverfactory.DriverFactory;
import pages.LoginPage;
import utilities.ConfigReader;

public class WelcomeSteps extends DriverFactory{
	WelcomePage welcomePage = new WelcomePage(DriverFactory.getDriver());
	Properties prop = new ConfigReader().intializeProperties();
	
	@Then("I should see the welcome message {string}")
    public void i_should_see_the_welcome_message(String expected) {
       // boolean flag = new WelcomePage(DriverFactory.getDriver()).getWelcomeMessage();
       // Assert.assertEquals(actual.trim(), expected);
		welcomePage.getWelcomeMessage();
    }
    
    @And("I click on Get Started button")
    public void i_click_on_get_started_button() {
        welcomePage.clickGetStarted();
    }
}






