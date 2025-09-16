@JobRoleManagement
Feature: Job Role Management
  As a recruiter, after logging in and navigating to Masters > Job Role,
  I want to be able to manage job openings.

    
    Background: Login with the application
    Given I open the application
    And I click on Get Started button
    When I login with valid credentials
    Then I should land on a page with URL containing "dashboard/default"

  Scenario: Verify navigation to the Job Role screen
    When I click on the Masters menu
    And I click on the "Job Role" option
     Then I should be on the Job Role management screen
    # The step to verify the URL is now part of this step's implementation.
    # The following steps are for content validation as before.
    And I should see a search bar
    And I should see the "+ Add Job Opening" button
    And I should see a table with columns "Edit", "Name", "Organization Name", "Description", "Active", and "Delete"
    And I click on AddjobRole button 
    Then I should see the form CreateNewJobRole
    And I enter the details the JobRole
    And I enter Description
    And I click on save button 
    Then the job role  created success message is displayed 
    