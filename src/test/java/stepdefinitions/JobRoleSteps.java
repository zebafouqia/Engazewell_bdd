package stepdefinitions;

import Driverfactory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.JobRolePage;
import pages.LoginPage;

import java.util.List;

public class JobRoleSteps {
    private JobRolePage jobRolePage;
    private LoginPage loginPage;

    // Use a constructor to initialize the page objects
    public JobRoleSteps() {
        this.loginPage = new LoginPage(DriverFactory.getDriver());
        this.jobRolePage = new JobRolePage(DriverFactory.getDriver());
    }

    @When("I click on the Masters menu")
    public void i_click_on_the_menu() {
        jobRolePage.clickMenu();
    }

    @And("I click on the {string} option")
    public void i_click_on_the_option(String optionName) {
        jobRolePage.clickSubMenuOption(optionName);
    }

    @Then("I should be on the Job Role management screen")
    public void i_should_be_on_the_job_role_management_screen() {
    	// Assert that the current URL contains the expected path
        Assert.assertTrue(jobRolePage.isOnJobRoleScreen(), "Failed to navigate to the Job Role management screen. URL is incorrect.");
    }

    @And("I should see a search bar")
    public void i_should_see_a_search_bar() {
        Assert.assertTrue(jobRolePage.isSearchBarVisible(), "Search bar is not visible.");
    }

    @And("I should see the {string} button")
    public void i_should_see_the_button(String buttonText) {
        Assert.assertTrue(jobRolePage.isAddJobOpeningButtonVisible(buttonText), "'" + buttonText + "' button is not visible.");
    }

    @And("I should see a table with columns {string}, {string}, {string}, {string}, {string}, and {string}")
    public void i_should_see_a_table_with_columns(String col1, String col2, String col3, String col4, String col5, String col6) {
        List<String> expectedHeaders = List.of(col1, col2, col3, col4, col5, col6);
      //  Assert.assertEquals(jobRolePage.getTableHeaders(), expectedHeaders, "Table headers do not match the expected list.");
    }
    

@Then("I click on AddjobRole button")
public void i_click_on_addjob_role_button() {
    // Write code here that turns the phrase above into concrete actions
   // throw new io.cucumber.java.PendingException();
	jobRolePage.clickOnAddJobRoleButton();
	
}

@Then("I should see the form CreateNewJobRole")
public void i_should_see_the_form_create_new_job_role() {
    // Write code here that turns the phrase above into concrete actions
  //  throw new io.cucumber.java.PendingException();
	boolean flag = jobRolePage.createNewJobRoleFormIsDisplayed();
	Assert.assertEquals(true, flag, "form is not displayed");
}

@Then("I enter the details the JobRole")
public void i_enter_the_details_the_job_role() throws InterruptedException {
    // Write code here that turns the phrase above into concrete actions
    //throw new io.cucumber.java.PendingException();
	jobRolePage.enterJobRole();
}

@Then("I enter Description")
public void i_enter_description() throws InterruptedException {
    // Write code here that turns the phrase above into concrete actions
    //throw new io.cucumber.java.PendingException();
	jobRolePage.generateDescriptionWithShortcut();
	
}

@Then("I see the success pop up displays for jobRole")
public void i_see_the_success_pop_up_displays_for_jobRole() {
	//jobRolePage.isDescriptionGeneratedSuccessfully();
}
@Then("I click on save button")
public void i_click_on_save_button() throws InterruptedException {
    // Write code here that turns the phrase above into concrete actions
    //throw new io.cucumber.java.PendingException();
	jobRolePage.clickSave();
}

@Then("the job role  created success message is displayed")
public void the_job_role_created_success_message_is_displayed() {
    // Write code here that turns the phrase above into concrete actions
   // throw new io.cucumber.java.PendingException();
	jobRolePage.jobRoleCreatedSuccessPopup();
}



}