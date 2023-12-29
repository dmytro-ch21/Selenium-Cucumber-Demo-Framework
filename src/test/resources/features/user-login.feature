@regression
Feature: User Login Process

  Background: Preliminary Steps
    Given user navigates to hrm login page


  @loginValid @smoke
  Scenario: Login with valid credentials
    When user enters username and password
    And user clicks login button
    Then user is redirected to home page
    * framework browser quit

  @loginInvalid
  Scenario: Login with invalid credentials
    When user enters invalid username and password
    And user clicks login button
    Then user can see an error message
    * framework browser quit

