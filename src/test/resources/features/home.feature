@All @Home
Feature: Home Page Scenarios

  Scenario Outline: Verify stats section displays correct values
    When Navigate to login page
    And fill email field with "<email>" on login page
    And fill password field with "<password>" on login page
    And click sign in button
    And Navigate to home page
    When user selects "<timeRange>" as the time range
    Then verify "Created Jobs" stat value is "<createdJobs>"
    And verify "Assigned Interviews" stat value is "<assignedInterviews>"
    And verify "Completed Interviews" stat value is "<completedInterviews>"
    And verify "Shortlisted Interviews" stat value is "<shortlistedInterviews>"

    Examples:
      | timeRange   | createdJobs | assignedInterviews | completedInterviews | shortlistedInterviews | email           | password |
      | Last 7 days | 5           | 10                 | 3                   | 2                     | fixed@fixed.com |Mert1994* |
      | Last 30 days| 20          | 30                 | 15                  | 10                    | fixed@fixed.com |Mert1994* |

  Scenario: Verify Create Job button functionality
    When Navigate to home page
    When user clicks on Create Job button
    Then verify Create Job page is displayed

  Scenario: Verify View Interviews button functionality
    When Navigate to home page
    When user clicks on View Interviews button
    Then verify Interviews page is displayed

  Scenario: Verify Start Simulation button functionality
    When Navigate to home page
    When user clicks on Start Simulation button
    Then verify Simulation page is displayed

  Scenario: Verify tutorial modal functionality
    When Navigate to home page
    When user opens the tutorial modal
    Then verify tutorial modal is open
    When user closes the tutorial modal
    Then verify tutorial modal is closed