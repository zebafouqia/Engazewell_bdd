Feature: Welcome screen

  Scenario: Verify welcome message is visible
    Given I open the application
    Then I should see the welcome message "Welcome to"
    And I click on Get Started button