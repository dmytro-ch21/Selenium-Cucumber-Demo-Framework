Feature: User Login Process

  @loginValid @smoke
  Scenario: Login with valid credentials
    Given user navigates to hrm login page
    When user enters username and password
    And user clicks login button
    Then user is redirected to home page
    * framework browser quit

  @loginInvalid @smoke
  Scenario: Login with invalid credentials
    Given user navigates to hrm login page
    When user enters invalid username and password
    And user clicks login button
    Then user can see an error message
    * framework browser quit

