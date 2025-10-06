@ManageJobOpening
Feature: Manage Job Openings
  As a recruiter or hiring manager
  I want to open the Job Opening screen and open the Create New Job Opening form
  So that I can start creating a new job opening

 Background: Login with the application
    Given I open the application
    And I click on Get Started button
    When I login with valid credentials
    Then I should land on a page with URL containing "dashboard/default"

  @job-opening 
  Scenario: Open Create New Job Opening form from side navigation
    Given the user is logged in and on the main/dashboard screen
    When the user clicks on "Job Opening" in the side navigation
    Then the JobOpening screen should be displayed
    And I should see a search bar
    And I should see the AddJobOpening button 
    And I should see a table with columns "Edit", "Job role", "Job ID", "Location", "Primary Skills", "Secondary Skills", "Employment Type", "Status", "Total Openings", "Updated On" and "Updated By" 
    When the user clicks the AddJobOpening button
    Then the CreateNewJobOpening form should open
    And the form should display "Save" and "Cancel" buttons
    
