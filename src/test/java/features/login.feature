Feature: Login

  Scenario: Valid login redirects to home
    Given I open the application
    And I click on Get Started button
    When I login with valid credentials
    Then I should land on a page with URL containing "dashboard/default"