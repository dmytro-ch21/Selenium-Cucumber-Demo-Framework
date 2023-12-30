@regression
Feature: User Login Process

  Background: Preliminary Steps
    Given user navigates to hrm login page

  @loginValid @smoke
  Scenario: Login with valid credentials
    When user logs in username "yoll-student" and password "Bootcamp5#"
    Then user is redirected to home page
    * framework browser quit

  @loginInvalid
  Scenario: Login with invalid credentials
    When user logs in username "invalid" and password "invalid"
    Then user can see error message "Invalid credentials"
    * framework browser quit

  @emptyUsername
  Scenario: Login with invalid credentials when username empty
    When user logs in username "" and password "invalid"
    Then user can see error message "Username cannot be empty"
    * framework browser quit

  @emptyPassword
  Scenario: Login with invalid credentials when password empty
    When user logs in username "invalid" and password ""
    Then user can see error message "Password cannot be empty"
    * framework browser quit

  @run @wip
  Scenario: Test parameters with different data types
   # * test with boolean true
    * test with double 20.99
    * test with int 25
    * test with string "hello"
    * framework browser quit