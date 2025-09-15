#Feature: Job Role Management
  #As a recruiter
  #I want to manage job roles
  #So that I can effectively handle job openings
#
#Background: Login with the application
    #Given I open the application
    #And I click on Get Started button
    #When I login with valid credentials
    #Then I should land on a page with URL containing "dashboard/default"
  #And I navigate to Masters > Job Role
#
#Scenario: View Job Role management screen
   #Then I should be on the Job Role management screen
    # The step to verify the URL is now part of this step's implementation.
    # The following steps are for content validation as before.
  #And I should see a '+Add Job Opening' button
  #And I should see a table with columns:
    #| Edit    |
    #| Name    |
    #| Organization Name |
    #| Description |
    #| Active  |
    #| Delete  |
#
#Scenario: Create a new job role successfully
  #When I click the '+Add Job Opening' button
  #Then I should see the 'Create New Job Role' form
  #When I fill in:
    #| Job Title   | Senior Developer |
    #| Active      | True             |
    #| Description | Backend development role |
  #And I click the 'Save' button
  #Then I should see a success message "Job role created successfully"
  #And the new job role should appear in the table
#
#Scenario: Use AI to populate description
  #When I click the '+Add Job Opening' button
  #And I press Ctrl+G in the Description field
  #Then the Description field should be auto-populated
  #When I click the 'Save' button
  #Then I should see a success message
#
#Scenario: Edit an existing job role
  #Given there exists a job role "Junior Developer"
  #When I click the Edit icon for "Junior Developer"
  #Then I should see the edit form with pre-filled details
  #When I update the Description to "Updated description"
  #And I click the 'Save' button
  #Then I should see a success message "Job role updated successfully"
  #And the table should show the updated description
#
#Scenario: Deactivate job role using delete icon
  #Given there exists an active job role "Tester"
  #When I click the Delete icon for "Tester"
  #Then I should see a confirmation popup
  #When I confirm the deletion by clicking 'Yes'
  #Then the job role "Tester" should remain in the table with Active status False
  #And I should not see the confirmation popup
#
#Scenario: Cancel job role deletion
  #Given there exists an active job role "Designer"
  #When I click the Delete icon for "Designer"
  #Then I should see a confirmation popup
  #When I cancel the deletion by clicking 'No'
  #Then the job role "Designer" should remain with Active status True
  #And the confirmation popup should close
#
#Scenario: Search for job roles
  #When I enter "Developer" in the search bar
  #And I press the Search button
  #Then I should only see job roles containing "Developer" in their title
#
#Scenario: Attempt to create job role with missing required fields
  #When I click the '+Add Job Opening' button
  #And I leave the Job Title field empty
  #And I click the 'Save' button
  #Then I should see an error message about required fields
  #And the job role should not be created