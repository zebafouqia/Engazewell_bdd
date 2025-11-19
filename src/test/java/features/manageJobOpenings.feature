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
  Scenario: Create New Job Opening
    When the user clicks on "Job Opening" in the side navigation
    Then the JobOpening screen should be displayed
    #And I should see a search bar
    And I should see the AddJobOpening button 
  # And I should see a table with columns "Edit", "Job role", "Job ID", "Location", "Primary Skills", "Secondary Skills", "Employment Type", "Status", "Total Openings", "Updated On" and "Updated By" 
    And the user clicks the AddJobOpening button
    Then the CreateNewJobOpening form should open
    And the form should display "Save" and "Cancel" buttons
    And user click on Jobrole field and dorpdown opens 
    And user selects the jobrole
    And user click on location enter the location name and select the correct location 
    And user enters minExperience 
    And user enters MaxExperience
    And user enters qualification
    And user double click on shortJD and enters ShortJD by keyboard controlG
    And user double clicks on responsibilities and enter responsibilities by keyboard controlG
    And user double clicks on Primary skills and enters primary skills by keyboard controlG
    And user double clicks on secondary skills and enters secondary skills by keyboard controlG
    And user clicks on total openings and enter total openings 
    And user clicks on employment type and selects employment type
    And user clicks on duration and selects duration 
    And user clicks on workmode and selects workmode 
    And user clicks on status and selects status 
    And user clicks on department and enter department
    And user clicks on industry type and enter industry 
    And user clicks on tags and enter tags and hit enter 
    And user clicks on vendors and select
    #And user clicks on client and enter the clint name and select client  from dropdown 
    And user click on Save
    #Then The  new jobopening is created  
    
    
    
    
