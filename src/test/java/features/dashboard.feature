Feature: Dashboard Statistics

Background: Login with the application
    Given I open the application
    And I click on Get Started button
    When I login with valid credentials
    Then I should land on a page with URL containing "dashboard/default"

  #Scenario: Verify dashboard statistics after successful login
    #When I navigate to the dashboard page
    #Then I should see the dashboard statistics with the following values:
      #| Total Profiles           | 46  |
      #| Resumes Uploaded (Today) | 0   |

  Scenario: Verify dashboard statistics cards are displayed
    Given I am logged into the application
    When I navigate to the dashboard page
    Then I should see the following statistics cards:
      | Total Profiles           |
      | Resumes Uploaded (Today) |
      #| Subscription Usage       |
      #| Upload Summary           |

  #Scenario: Verify subscription usage table
    #Given I am logged into the application
    #When I navigate to the dashboard page
    #Then I should see the subscription usage table with headers:
      #| Name              | Quota | Used | Remaining |
    #And the subscription usage should contain:
      #| Profile Usage     | 10000 | 333  | 4/27      |
      #| Recruiter Usage   | 20    | 18   | 5         |
      #| Vendor Usage      | 20    | 3    | 17        |

  #Scenario: Verify upload summary section
    #Given I am logged into the application
    #When I navigate to the dashboard page
    #Then I should see the upload summary section
    #And I should see "Today" in the upload summary