@regression
Feature: Browser Windows and Tabs Handling

  # Task
  # Modify this scenario so it can click on the New Tab button within one step
  # There is no need for changes in other steps
  # It should work

  #Solution - 1
  # 1. In order to click on different button from one step we need to parametrize it
  # 2. need to update the step definition glue
  # 3. Locate the new web element
  # 4. Decide what button to click with a control flow statement

  #Solution - 2
  # 1. In order to click on different button from one step we need to parametrize it
  # 2. need to update the step definition glue
  # 3. Locate the new web element
  # 4. Create a reusable method in the page that iterates over the existing buttons and clicks on a one by the text

  @windows
  Scenario: Get the GUID of the main window
    Given I land on Demo QA Browser Window Page
    Then I can retrieve the GUID of the current window
    When I click on "New Tab" button
    Then a new window is created and I switch to it
    And I can see the content on the new window as "This is a sample page"
    When I close the new window
    Then I switch back to main window and the title is "DEMOQA"


