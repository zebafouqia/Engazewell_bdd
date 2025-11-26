@UploadProfile
Feature: upload Profile
  As a recruiter or hiring manager
  I want to upload a new profile 
  So that I can start hiring process

Background: Login with the application
    Given I open the application
    And I click on Get Started button
    When I login with valid credentials
    Then I should land on a page with URL containing "dashboard/default"
    
 @UploadNewPeofile
 Scenario: Upload a new Profile
 When the user clicks on "Profile" on side navigation bar
 And the user clicks on the cloudUoloadIcon
 And the user clicks on BrowseFiles link
 And the user uploades the file from local and hit open 
 And User clicks on Upload button
 Then User can see the success message on screen 
 
 
 
  
    