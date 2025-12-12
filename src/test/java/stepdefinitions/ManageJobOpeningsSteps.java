package stepdefinitions;

import org.testng.Assert;

import Driverfactory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.ManageJobOpeningsPage;

public class ManageJobOpeningsSteps extends DriverFactory {
	//private ElementUtils utils;
	private LoginPage loginPage;
	private ManageJobOpeningsPage manageJobopeningpage;
	
	
	
	  public ManageJobOpeningsSteps() {
	        this.loginPage = new LoginPage(DriverFactory.getDriver());
	        this.manageJobopeningpage = new ManageJobOpeningsPage(DriverFactory.getDriver());
	    }
	

@When("the user clicks on {string} in the side navigation")
public void the_user_clicks_on_in_the_side_navigation(String string) {
    // Write code here that turns the phrase above into concrete actions
	manageJobopeningpage.clickJobOpening();
}

@Then("the JobOpening screen should be displayed")
public void the_job_opening_screen_should_be_displayed() {
    // Write code here that turns the phrase above into concrete actions
	String currentUrl = manageJobopeningpage.verifyJobOpeningPageIsDisplayed();
	Assert.assertTrue(currentUrl.contains("jobopening"), "Not on Job Openings page");
}

@Then("I should see the AddJobOpening button")
public void i_should_see_the_add_job_opening_button() {
    // Write code here that turns the phrase above into concrete actions
    //throw new io.cucumber.java.PendingException();
	manageJobopeningpage.verifyAddJobOpeningButtonISDisplayed();
	
}

//@Then("I should see a table with columns {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} and {string}")
//public void i_should_see_a_table_with_columns_and(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11) {
//    // Write code here that turns the phrase above into concrete actions
//    //throw new io.cucumber.java.PendingException();
//	 List<String> expectedHeaders = List.of(string, string2, string3, string4, string5, string6,string7,string8,string9,string10,string11);
//	 Assert.assertEquals(manageJobopeningpage.isTableDisplayedWithAllHeaders(), expectedHeaders, "Table headers do not match the expected list.");
//}

@Then("the user clicks the AddJobOpening button")
public void the_user_clicks_the_add_job_opening_button() {
    // Write code here that turns the phrase above into concrete actions
   // throw new io.cucumber.java.PendingException()
	manageJobopeningpage.clickJobOpeningButton();

}

@Then("the CreateNewJobOpening form should open")
public void the_create_new_job_opening_form_should_open() {
    // Write code here that turns the phrase above into concrete actions
   // throw new io.cucumber.java.PendingException();
	manageJobopeningpage.verifyCreateNewJobOpeningFormIsDisplayed();
}

@Then("the form should display {string} and {string} buttons")
public void the_form_should_display_and_buttons(String string, String string2) {
    // Write code here that turns the phrase above into concrete actions
   // throw new io.cucumber.java.PendingException();
	manageJobopeningpage.verifySaveandCancelButtonsAreVisible();
}

@Then("user click on Jobrole field and dorpdown opens")
public void user_click_on_jobrole_field_and_dorpdown_opens() {
    // Write code here that turns the phrase above into concrete actions
   // throw new io.cucumber.java.PendingException();
	manageJobopeningpage.userClicksOnJobRoleFIeld();
}

@Then("user selects the jobrole")
public void user_selects_the_jobrole() {
    // Write code here that turns the phrase above into concrete actions
   // throw new io.cucumber.java.PendingException();
	manageJobopeningpage.selectJobRole("Frontend Lead");
}

@Then("user click on location enter the location name and select the correct location")
public void user_click_on_location_enter_the_location_name_and_select_the_correct_location() {
    // Write code here that turns the phrase above into concrete actions
   // throw new io.cucumber.java.PendingException();
	manageJobopeningpage.selectLocationSuggestion("Hyderabad", "Hyderabad, IN");
}

@Then("user enters minExperience")
public void user_enters_min_experience() {
    // Write code here that turns the phrase above into concrete actions
   // throw new io.cucumber.java.PendingException();
	manageJobopeningpage.enterMinExp("3");
}

@Then("user enters MaxExperience")
public void user_enters_max_experience() {
    // Write code here that turns the phrase above into concrete actions
   // throw new io.cucumber.java.PendingException();
	manageJobopeningpage.enterMaxExp("5");
}
@Then("user enters qualification")
public void user_enters_qualification() {
	manageJobopeningpage.enterQualification();
}
@Then("user double click on shortJD and enters ShortJD by keyboard controlG")
public void user_double_click_on_short_jd_and_enters_short_jd_by_keyboard_control_g() throws InterruptedException {
    // Write code here that turns the phrase above into concrete actions
    //throw new io.cucumber.java.PendingException();
	manageJobopeningpage.enterShortJd();
	
}

@Then("user double clicks on responsibilities and enter responsibilities by keyboard controlG")
public void user_double_clicks_on_responsibilities_and_enter_responsibilities_by_keyboard_control_g() {
    // Write code here that turns the phrase above into concrete actions
   // throw new io.cucumber.java.PendingException();
	manageJobopeningpage.responsibilities();
	
}

@Then("user double clicks on Primary skills and enters primary skills by keyboard controlG")
public void user_double_clicks_on_primary_skills_and_enters_primary_skills_by_keyboard_control_g() {
    // Write code here that turns the phrase above into concrete actions
    //throw new io.cucumber.java.PendingException();
	manageJobopeningpage.primarySkills();
}

@Then("user double clicks on secondary skills and enters secondary skills by keyboard controlG")
public void user_double_clicks_on_secondary_skills_and_enters_secondary_skills_by_keyboard_control_g() {
    // Write code here that turns the phrase above into concrete actions
   // throw new io.cucumber.java.PendingException();
	try {
		manageJobopeningpage.secondarySkills();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

@Then("user clicks on total openings and enter total openings")
public void user_clicks_on_total_openings_and_enter_total_openings() {
    // Write code here that turns the phrase above into concrete actions
    //throw new io.cucumber.java.PendingException();
	manageJobopeningpage.totalJobOpeningsField();
}

@Then("user clicks on employment type and selects employment type")
public void user_clicks_on_employment_type_and_selects_employment_type() {
    // Write code here that turns the phrase above into concrete actions
   // throw new io.cucumber.java.PendingException();
	manageJobopeningpage.selectEmploymentType();
	
}

@Then("user clicks on duration and selects duration")
public void user_clicks_on_duration_and_selects_duration() {
    // Write code here that turns the phrase above into concrete actions
    //throw new io.cucumber.java.PendingException();
	manageJobopeningpage.selectDuration();
}

@Then("user clicks on workmode and selects workmode")
public void user_clicks_on_workmode_and_selects_workmode() {
    // Write code here that turns the phrase above into concrete actions
    //throw new io.cucumber.java.PendingException();
	manageJobopeningpage.selectWorkMode();
}

@Then("user clicks on status and selects status")
public void user_clicks_on_status_and_selects_status() {
    // Write code here that turns the phrase above into concrete actions
   // throw new io.cucumber.java.PendingException();
	manageJobopeningpage.selectStatus();
}

@Then("user clicks on department and enter department")
public void user_clicks_on_department_and_enter_department() {
    // Write code here that turns the phrase above into concrete actions
  //  throw new io.cucumber.java.PendingException();
	manageJobopeningpage.selectDepatment();
	
}

@Then("user clicks on industry type and enter industry")
public void user_clicks_on_industry_type_and_enter_industry() {
    // Write code here that turns the phrase above into concrete actions
   // throw new io.cucumber.java.PendingException();
	manageJobopeningpage.selectIndustryType();
}

@Then("user clicks on tags and enter tags and hit enter")
public void user_clicks_on_tags_and_enter_tags_and_hit_enter() {
    // Write code here that turns the phrase above into concrete actions
   // throw new io.cucumber.java.PendingException();
	manageJobopeningpage.tags();
}

@Then("user clicks on vendors and select")
public void user_clicks_on_vendors_and_select() {
    // Write code here that turns the phrase above into concrete actions
   // throw new io.cucumber.java.PendingException();
	manageJobopeningpage.vendors();
}

@Then("user clicks on client and enter the clint name and select client  from dropdown")
public void user_clicks_on_client_and_enter_the_clint_name_and_select_client_from_dropdown() {
    // Write code here that turns the phrase above into concrete actions
  //  throw new io.cucumber.java.PendingException();
}

@Then("user click on Save")
public void user_click_on_save() {
    // Write code here that turns the phrase above into concrete actions
  //  throw new io.cucumber.java.PendingException();
	manageJobopeningpage.save();
}

@Then("The  new jobopening is created")
public void the_new_jobopening_is_created() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}
}
