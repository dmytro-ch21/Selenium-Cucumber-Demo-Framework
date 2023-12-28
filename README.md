# 📝 Selenium-Cucumber-Framework Documentation

## 🛠 Framework Creation

1. **Create a new project with:**
    - Java as programming language - check version in terminal (should be at least Java 8 and higher) 🌐
        - The newest versions of Selenium support Java 11 and soon will switch to Java 17, so make sure to install the
          needed version
    - Maven - build tool 🛠
    - Git - for Source version control 🔄

2. **Add necessary dependencies** 📦
    - Selenium
    - JUnit 4
    - Cucumber - Java
    - Cucumber - JUnit

3. **Create folder structure** 📁
    - Pages
    - Step_definitions
    - Utilities
    - Runner
    - Resources.features

4. **Start by creating your first Cucumber file** 🥒

5. **Add necessary dependencies (Re-check)** 🔄
    - Cucumber for Java
    - Ensure Gherkin is installed

| Tool     | Intention                            | Version  |
|:---------|:-------------------------------------|----------|
| Java     | Programming Language                 | JDK - 20 |
| Maven    | Build Tool and Dependency Management | 3.9.5    |
| Selenium | UI Test Automation                   | 4.15.0   |
| JUnit    | Test Framework                       | 4.13.2   |
| Cucumber | BDD Framework                        | 7.15.0   |


# 📝 Selenium-Cucumber-Framework Documentation

## 🛠 Framework Creation

1. **Create a new project with:**
    - Java as programming language 🌐
    - Maven as build tool 🛠
    - Git for source version control 🔄

2. **Add necessary dependencies** 📦
    - Selenium, JUnit 4, Cucumber - Java, Cucumber - JUnit

3. **Create folder structure** 📁
    - Pages, Step_definitions, Utilities, Runner, Resources.features

4. **Start by creating your first Cucumber file** 🥒

5. **Add necessary dependencies (Re-check)** 🔄
    - Cucumber for Java
    - Ensure Gherkin is installed

6. **Running your first feature:** 🏃
    - Create a StepDefinition class containing Java methods that define each step from the feature file
      ```java
      // Example of a Step Definition in Java
      @Given("user is on the login page")
      public void userIsOnLoginPage() {
      // code to navigate to login page
      }
      ```
    - Create a TestRunner class connecting feature file steps with Java methods from step definitions
        - TestRunner uses JUnit 4 annotation @RunWith() to run tests with Cucumber.class type
            - Customize binding and framework execution with @CucumberOptions():
                - feature = "path/to/features": provides the path to features of the framework
                - glue = "step definitions location": connects the step definitions with feature files steps
                - dryRun options:
                    - If set to true, it checks if all steps in the feature file are defined but doesn't run test cases
                    - If set to false, it runs the test cases and throws an error if steps aren't defined
                - monochrome = true : makes the console logs more readable
                - plugin = {""}
                  ```java
                  @RunWith(Cucumber.class)
                  @CucumberOptions(
                      features = "src/test/resources/features",
                      glue = "step_definitions",
                      monochrome = true,
                      dryRun = false,
                      tags = ("@runValid and @smoke")
                  )
                  public class TestRunner {
                  // no need to add code here
                  }
                  ```
7. **Cucumber Keywords definitions in feature files** 🗝️
    - **Feature:** Short description of the feature to be tested
        - Examples:
          ```gherkin
          #Example 1: 
          Feature: User Login Functionality
          #Example 2:
          Feature: Reset Password Functionality
          ```  
    - **Scenario:** Brief use case description from a user perspective
        - Examples:
            ```gherkin
          #Example 1: 
          Scenario: Login with valid credentials
          #Example 2:
          Scenario: Login with invalid credentials
          ```
    - **Given, When, Then, And, But, \* Keywords:**
        - **Given** - Preconditions or starting points
            - Examples:
              ```gherkin
              #Example 1:
              Given user navigates to login page
              #Example 2:
              Given admin user lands on the home page
              ```
        - **When** - Main actions performed
            - Examples:
              ```gherkin
              #Example 1:
              When user enters username and password
              #Example 2:
              When user clicks on admin tab
              ```
        - **Then** - Outcome or result of actions, usually at this step you need to perform an assertion
            - Examples:
              ```gherkin
              #Example 1:
              Then user is redirected to the homepage
              #Example 2:
              Then user can see an error message
              ```
        - **And** - Connects multiple steps within Given, When, or Then
            - Used to add more detail or steps without repeating the Given, When, or Then keywords
            - Examples:
              ```gherkin
              #Example: notice how And keyword connects any steps on Given, When, Then
              Scenario: Login with valid credentials
                Given user is on the login page
                And user has a valid account
                When user enters their username
                And user enters their password
                And user clicks on the login button
                Then user is redirected to the dashboard
                And user receives a welcome message
              ```
        - **But** - Describes an exception or a contrasting scenario
            - Example:
              ```gherkin
              #Example: notice how But keyword provides a logical output when the credentials 
              # are about to expire you still can login but a message will be shown
              Scenario: Login with expiring credentials
                Given user is on the login page
                And user has a valid account
                When user enters their username
                And user enters their password
                And user clicks on the login button
                Then user is redirected to the dashboard
                But user can see a warning message to change credentials
              ```
        - **"*"** - Asterisks:
            - The asterisk * is a more generic step keyword that can be used in place of any of the other keywords (
              Given, When, Then, And, But).
            - It is often used when the specific type of step (setup, action, or assertion) is either clear from context
              or not important to the clarity of the scenario.
                - The use of * doesn't imply a technical or undefined behavior; it's more about flexibility in writing
                  the scenario.
                  ```gherkin
                      # Example using steps with keywords:
                          Given I am logged in
                          And I have items in my cart
                          When I go to the checkout page
                          Then I should see the total price
                      # Example using steps with asteriks:
                          * I am logged in
                          * I have items in my cart
                          * I go to the checkout page
                          * I should see the total price
                  ```

### More information about Gherkin syntax can be found here:

[Cucumber - Gherkin Syntax](https://cucumber.io/docs/gherkin/reference/)
