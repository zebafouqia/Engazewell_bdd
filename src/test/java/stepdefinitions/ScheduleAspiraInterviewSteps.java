package stepdefinitions;

import Driverfactory.DriverFactory;

//package com.yourcompany.steps;

//import com.yourcompany.pages.ScheduleInterviewPage;
import io.cucumber.java.en.*;
import io.cucumber.messages.types.Hook;
import pages.LoginPage;
import pages.ScheduleAspiraInterviewPage;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.nio.file.Paths;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;

public class ScheduleAspiraInterviewSteps {
	private LoginPage loginPage;
    private  WebDriver driver ;
    private  ScheduleAspiraInterviewPage page;

    public ScheduleAspiraInterviewSteps() {
        // initialize driver from your test context (replace with your DI / hooks)
       // this.driver = Hook.getDriver();   // replace Hook.getDriver() with your driver provider
    	 this.loginPage = new LoginPage(DriverFactory.getDriver());
        this.page = new ScheduleAspiraInterviewPage(DriverFactory.getDriver());
    }

    @When("User clicks on schedule interview  on side navigation bar1")
    public void user_clicks_on_schedule_interview_on_side_navigation_bar1(){
        // specifically for schedule interview
        page.goToScheduleInterview();
    }

    @When("User clicks on create interview button1")
    public void user_clicks_on_create_interview_button1() {
//        if (btnText.equalsIgnoreCase("create interview") || btnText.equalsIgnoreCase("Create Interview")) {
//            page.clickCreateInterview();
//        } else {
//            throw new IllegalArgumentException("Unsupported button: " + btnText);
//        }
    	page.clickCreateInterview();
    	
    }

    @When("User clicks on job opening dropdown and selectes a job opening1")
    public void user_clicks_on_job_opening_dropdiwn_and_selectes_a_job_opening1() {
        // supply a job name relevant to your test environment
        page.selectJobOpening("Frontend Lead");
    }

    @When("User clicks on loaction dropdown and selects a location1")
    public void userclicks_on_loaction_dropdown_and_selects_a_location1() {
        page.selectLocation("Hyderabad");
    }

    @When("User clicks on candidate email field and enters a candidate email1")
    public void user_clicks_on_candidate_email_field_and_enters_candidate_email1() throws InterruptedException {
        // use email existing in test data
        page.chooseCandidateByEmail("fouqia.zeba@walkingtree.tech");
    }

    @When("User clicks on Aspira option")
    public void user_clicks_on_Aspira_option() {
        page.chooseAspiraOption();
    }

    @When("User clicks on Date field and selectes date1")
    public void user_clicks_on_date_field_and_selectes_date1() throws InterruptedException {
    	ScheduleAspiraInterviewPage.ScheduleDateTime dt = ScheduleAspiraInterviewPage.generateValidInterviewDateTime(ZoneId.systemDefault());
        page.setDate(dt.date);
        Thread.sleep(2000);
        // store dt somewhere if needed
    }

    @When("User clicks on startTime field and eslects start time1")
    public void user_clicks_on_startTime_field_and_eslects_start_time1() throws InterruptedException {
    	ScheduleAspiraInterviewPage.ScheduleDateTime dt = ScheduleAspiraInterviewPage.generateValidInterviewDateTime(ZoneId.systemDefault());
//        page.setStartTime(dt.start);
    	page.setInterviewTimes();
        
        Thread.sleep(2000);
    }

    @When("User clicks on EndTime field and selects end Time1")
    public void user_clicks_on_EndTime_field_and_selects_end_Time1() throws InterruptedException {
    	ScheduleAspiraInterviewPage.ScheduleDateTime dt = ScheduleAspiraInterviewPage.generateValidInterviewDateTime(ZoneId.systemDefault());
       // page.setEndTime(dt.end);
        Thread.sleep(2000);
    }

    @When("User clicks on attendee field and selects email1")
    public void user_clicks_on_attendee_field_and_selects_email1() {
        page.addAttendeeEmail("fouqia.zeba+wttpanel@walkingtree.tech");
    }

    @When("User  selects  interview round1")
    public void user_selects_interview_round1() {
        page.selectInterviewRound("Level 1 (L1)");
    }

    @When("User clicks on Provider and selects thr provider1")
    public void user_clicks_on_Provider_and_selects_thr_provider1() {
        page.selectProvider("Google Meeting");
    }

    @When("User clicks on Next button1")
    public void user_clicks_on_Next_button1() {
        page.clickNext();
    }

    @When("User clicks on Attach file and attaches two files1")
    public void user_clicks_on_Attach_file_and_attaches_two_files1() {
        // Provide absolute paths for the two files in your local machine/CI workspace
        // Example: build from project root
        String root = System.getProperty("user.dir");
        String folder = Paths.get(root, "src", "test", "resources", "testfiles").toString();

        List<String> files = Arrays.asList(
                Paths.get(folder, "Document1.pdf").toString(),
                Paths.get(folder, "Document2.pdf").toString()
        );

        page.attachFiles(files);
    }

    @When("Uer clicks on confirm&send button1")
    public void user_clicks_on_confirm_send_button1() throws InterruptedException {
        page.confirmAndSend();
        Thread.sleep(3000);
    }

    @Then("The interview will be created1")
    public void the_interview_will_be_created() {
        boolean created = page.isInterviewCreated();
        Assert.assertTrue("Interview was not created or success message not shown", created);
    }
}

