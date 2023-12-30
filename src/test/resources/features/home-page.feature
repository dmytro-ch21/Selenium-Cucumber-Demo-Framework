@regression
Feature: Home Page Functionalities

  @tabsVerification
  Scenario: User can see all tabs on home page
    Given user navigates to hrm login page
    When user logs in with username "yoll-student" and password "Bootcamp5#"
    Then user is redirected to home page
    And user can see following tabs:
      | Admin       |
      | PIM         |
      | Leave       |
      | Time        |
      | Recruitment |
      | My Info     |
      | Performance |
      | Dashboard   |
      | Directory   |
      | Maintenance |