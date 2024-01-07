Feature: Java Script Executor

  Background:
    Given user navigates to hrm login page
    And user logs in with username "yoll-student" and password "Bootcamp5#"

  @js-tc1
  Example: Click with JSExecutor on PIM tab
    When click on PIM tab with js executor
    Then url ends with "viewEmployeeList"

  @js-tc2
  Example: Scroll to the element view
    When click on PIM tab with js executor
    And scroll to the last element on the web page

  @js-tc3
  Example: Interact with disabled input box
    When click on PIM tab with js executor
    And click on employee with id "13743"
    And modify first name without while input is disabled


