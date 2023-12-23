Feature: User Login Process

  Scenario: Login with valid credentials
    Given user navigates to hrm login page
    When user enters username and password
    And user clicks login button
    Then user is redirected to home page