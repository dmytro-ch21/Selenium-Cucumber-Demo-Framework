Feature: Browser Windows Handling

  @window-tc1
  Scenario: Get the GUID of main window
    Given I land on Demo QA Browser Windows Page
    Then I can retrieve the GUID of current page
    When I click on "New Tab" button
    Then a new window is created and I switch to it
    And I can see the content as "This is a sample page"
    When I close the new window
    Then I switch to main window and can see the title of the page is "DEMOQA"
