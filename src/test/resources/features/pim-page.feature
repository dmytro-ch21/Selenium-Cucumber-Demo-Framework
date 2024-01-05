Feature: Personal Information Management Functionality
  As an Admin I am able to search for an employee on the PIM(Personal Information Management) page

  @searchById
  Scenario: User can search an employee by their ID
    Given user navigates to hrm login page
    And user logs in with username "yoll-student" and password "Bootcamp5#"
    Then user is redirected to home page
    When user clicks on "PIM" tab
    And user types ID as "13654" in the Employee Information
    And user clicks search button
    Then user can see one record in the table with "13654", "Test", "automation", and "SDET"