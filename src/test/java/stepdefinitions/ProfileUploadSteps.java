package stepdefinitions;
import Driverfactory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.ProfileUploadPage;


public class ProfileUploadSteps {
	private LoginPage loginPage;
	private ProfileUploadPage profileUploadPage;
	
	public ProfileUploadSteps() {
		this.loginPage = new LoginPage(DriverFactory.getDriver());
		this.profileUploadPage = new ProfileUploadPage(DriverFactory.getDriver());
	}
	
	
	

@When("the user clicks on {string} on side navigation bar")
public void the_user_clicks_on_on_side_navigation_bar(String string) {
    // Write code here that turns the phrase above into concrete actions
   // throw new io.cucumber.java.PendingException();
	profileUploadPage.profile();
}

@When("the user clicks on the cloudUoloadIcon")
public void the_user_clicks_on_the_cloud_uoload_icon_aria_label() {
    // Write code here that turns the phrase above into concrete actions
   // throw new io.cucumber.java.PendingException();
	profileUploadPage.uploadCloudIcon();
}

@When("the user clicks on BrowseFiles link")
public void the_user_clicks_on_browse_files_link() {
    // Write code here that turns the phrase above into concrete actions
   // throw new io.cucumber.java.PendingException();
	profileUploadPage.browseFile();
}

@When("the user uploades the file from local and hit open")
public void the_user_uploades_the_file_from_local_and_hit_open() throws Exception {
    // Write code here that turns the phrase above into concrete actions
   // throw new io.cucumber.java.PendingException();
	profileUploadPage.uploadDocumentUsingRobot(); 
}

@When("User clicks on Upload button")
public void user_clicks_on_upload_button() {
    // Write code here that turns the phrase above into concrete actions
   // throw new io.cucumber.java.PendingException();
	profileUploadPage.clickUploadButton();
}

@Then("User can see the success message on screen")
public void user_can_see_the_success_message_on_screen() {
    // Write code here that turns the phrase above into concrete actions
   // throw new io.cucumber.java.PendingException();
}


	

}
