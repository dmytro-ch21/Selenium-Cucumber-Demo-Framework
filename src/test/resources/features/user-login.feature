@regression
Feature: User Login Process

  Background: Preliminary Steps
    Given user navigates to hrm login page

  @loginValid @smoke
  Scenario: Login with valid credentials
    When user logs in with username "yoll-student" and password "Bootcamp5#"
    Then user is redirected to home page


  @examplesTable
  Scenario Outline: Login with invalid credentials <test_point>
    When user logs in with username "<username>" and password "<password>"
    Then user can see error message "<errorMessage>"
    * framework browser quit
    Examples:
      | test_point          | username | password | errorMessage             |
      | when both invalid   | invalid  | invalid  | Invalid credentials      |
      | when username empty |          | invalid  | Username cannot be empty |
      | when password empty | invalid  |          | Password cannot be empty |


#  @run
#  Scenario: Test parameters with different data types
#   # * test with boolean true
#    * test with double 20.99
#    * test with int 25
#    * test with string "hello"
#    * framework browser quit







