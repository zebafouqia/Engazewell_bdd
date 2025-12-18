@SchedulePanelInterview
Feature: Schedule Aspira Interview 
  As a recruiter or hiring manager
  I want schedule a panel interview for candidate on a perticular job role 

 Background: Login with the application
    Given I open the application
    And I click on Get Started button
    When I login with valid credentials
    Then I should land on a page with URL containing "dashboard/default"
    @panelInterview
    Scenario: Schedule a Aspira Interview 
    When User clicks on schedule interview  on side navigation bar1
    And User clicks on create interview button1
    And User clicks on job opening dropdown and selectes a job opening1
    And User clicks on loaction dropdown and selects a location1 
    And User clicks on candidate email field and enters a candidate email1
    And User clicks on Aspira option 
    And User clicks on Date field and selectes date1
    And User clicks on startTime field and eslects start time1 
   # And User clicks on EndTime field and selects end Time 
    #And User clicks on attendee field and selects email 
    #And User  selects  interview round1 
    #And User clicks on Provider and selects thr provider1 
    And User clicks on Next button1
    And User clicks on Attach file and attaches two files1 
   And Uer clicks on confirm&send button1 
  #  Then The interview will be created1 
    
   