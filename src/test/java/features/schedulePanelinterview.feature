@SchedulePanelInterview
Feature: Schedule Panel Interview 
  As a recruiter or hiring manager
  I want schedule a panel interview for candidate on a perticular job role 

 Background: Login with the application
    Given I open the application
    And I click on Get Started button
    When I login with valid credentials
    Then I should land on a page with URL containing "dashboard/default"
    @panelInterview
    Scenario: Schedule a panel Interview 
    When User clicks on schedule interview  on side navigation bar 
    And User clicks on create interview button
    And User clicks on job opening dropdown and selectes a job opening
    And User clicks on loaction dropdown and selects a location 
    And User clicks on candidate email field and enters a candidate en=mail and clicks  the correct email 
    And User clicks on panel option 
    And User clicks on Date field and selectes date 
    And User clicks on startTime field and eslects start time 
   # And User clicks on EndTime field and selects end Time 
    And User clicks on attendee field and selects email 
    And User  selects  interview round 
    And User clicks on Provider and selects thr provider 
    And User clicks on Next button 
    And User clicks on Attach file and attaches two files 
   And Uer clicks on confirm&send button 
  #  Then The interview will be created 
    
   