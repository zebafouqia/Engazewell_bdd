package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Properties;

import org.testng.Assert;

import Driverfactory.DriverFactory;
import pages.LoginPage;
import utilities.ConfigReader;

public class LoginSteps extends DriverFactory{
	
	Properties prop = new ConfigReader().intializeProperties();
	
	@Given("I open the application")
	public void i_open_the_application() {
	    }
	    
    @When("I login with valid credentials")
    public void i_login_with_valid_credentials() {
    	String user = prop.getProperty("username");
    	String pass = prop.getProperty("password");

        new LoginPage(DriverFactory.getDriver()).login(user, pass);
    }

    @Then("I should land on a page with URL containing {string}")
    public void i_should_land_on_a_page_with_url_containing(String part) {
        String current = DriverFactory.getDriver().getCurrentUrl();
        Assert.assertTrue(current.contains(part), 
            "Expected URL to contain: " + part + " but was: " + current);
    }
}


