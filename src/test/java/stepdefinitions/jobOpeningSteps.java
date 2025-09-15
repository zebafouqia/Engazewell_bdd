//package stepdefinitions;
//
//import org.testng.Assert;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//public class jobOpeningSteps {
//
//	
//	
//
//@Then("I navigate to Masters > Job Role")
//public void i_navigate_to_masters_job_role() {
//    // Write code here that turns the phrase above into concrete actions
//  //  throw new io.cucumber.java.PendingException();
//	
//	
//}
//
//@Then("I should be on the Job Role management screen")
//public void i_should_be_on_the_job_role_management_screen() {
//	// Assert that the current URL contains the expected path
//    Assert.assertTrue(jobOpeningPage.isOnJobRoleScreen(), "Failed to navigate to the Job Role management screen. URL is incorrect.");
//}
//
//@Then("I should see a {string} button")
//public void i_should_see_a_button(String string) {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}
//
//@Then("I should see a table with columns:")
//public void i_should_see_a_table_with_columns(io.cucumber.datatable.DataTable dataTable) {
//    // Write code here that turns the phrase above into concrete actions
//    // For automatic transformation, change DataTable to one of
//    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
//    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
//    // Double, Byte, Short, Long, BigInteger or BigDecimal.
//    //
//    // For other transformations you can register a DataTableType.
//    throw new io.cucumber.java.PendingException();
//}
//
//@When("I click the {string} button")
//public void i_click_the_button(String string) {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}
//
//@Then("I should see the {string} form")
//public void i_should_see_the_form(String string) {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}
//
//@When("I fill in:")
//public void i_fill_in(io.cucumber.datatable.DataTable dataTable) {
//    // Write code here that turns the phrase above into concrete actions
//    // For automatic transformation, change DataTable to one of
//    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
//    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
//    // Double, Byte, Short, Long, BigInteger or BigDecimal.
//    //
//    // For other transformations you can register a DataTableType.
//    throw new io.cucumber.java.PendingException();
//}
//
//@Then("I should see a success message {string}")
//public void i_should_see_a_success_message(String string) {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}
//
//@Then("the new job role should appear in the table")
//public void the_new_job_role_should_appear_in_the_table() {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}
//
//@When("I press Ctrl+G in the Description field")
//public void i_press_ctrl_g_in_the_description_field() {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}
//
//@Then("the Description field should be auto-populated")
//public void the_description_field_should_be_auto_populated() {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}
//
//@Then("I should see a success message")
//public void i_should_see_a_success_message() {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}
//
//@Given("there exists a job role {string}")
//public void there_exists_a_job_role(String string) {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}
//
//@When("I click the Edit icon for {string}")
//public void i_click_the_edit_icon_for(String string) {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}
//
//@Then("I should see the edit form with pre-filled details")
//public void i_should_see_the_edit_form_with_pre_filled_details() {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}
//
//@When("I update the Description to {string}")
//public void i_update_the_description_to(String string) {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}
//
//@Then("the table should show the updated description")
//public void the_table_should_show_the_updated_description() {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}
//
//@Given("there exists an active job role {string}")
//public void there_exists_an_active_job_role(String string) {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}
//
//@When("I click the Delete icon for {string}")
//public void i_click_the_delete_icon_for(String string) {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}
//
//@Then("I should see a confirmation popup")
//public void i_should_see_a_confirmation_popup() {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}
//
//@When("I confirm the deletion by clicking {string}")
//public void i_confirm_the_deletion_by_clicking(String string) {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}
//
//@Then("the job role {string} should remain in the table with Active status False")
//public void the_job_role_should_remain_in_the_table_with_active_status_false(String string) {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}
//
//@Then("I should not see the confirmation popup")
//public void i_should_not_see_the_confirmation_popup() {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}
//
//@When("I cancel the deletion by clicking {string}")
//public void i_cancel_the_deletion_by_clicking(String string) {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}
//
//@Then("the job role {string} should remain with Active status True")
//public void the_job_role_should_remain_with_active_status_true(String string) {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}
//
//@Then("the confirmation popup should close")
//public void the_confirmation_popup_should_close() {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}
//
//@When("I enter {string} in the search bar")
//public void i_enter_in_the_search_bar(String string) {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}
//
//@When("I press the Search button")
//public void i_press_the_search_button() {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}
//
//@Then("I should only see job roles containing {string} in their title")
//public void i_should_only_see_job_roles_containing_in_their_title(String string) {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}
//
//@When("I leave the Job Title field empty")
//public void i_leave_the_job_title_field_empty() {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}
//
//@Then("I should see an error message about required fields")
//public void i_should_see_an_error_message_about_required_fields() {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}
//
//@Then("the job role should not be created")
//public void the_job_role_should_not_be_created() {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}
//}
