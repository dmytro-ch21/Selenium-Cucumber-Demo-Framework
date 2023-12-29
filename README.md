# 📝 Selenium-Cucumber-Demo-Framework Documentation

| Tool     | Intention                            |  Version   |                          Docs                           |
|:---------|:-------------------------------------|:----------:|:-------------------------------------------------------:|
| Java     | Programming Language                 |  JDK - 20  |   [JDK20](https://docs.oracle.com/en/java/javase/20/)   |
| Maven    | Build Tool and Dependency Management |   3.9.5    |  [Maven 3](https://maven.apache.org/guides/index.html)  |
| Selenium | UI Test Automation                   |   4.15.0   |  [Selenium 4](https://www.selenium.dev/documentation/)  |
| JUnit    | Test Framework                       |   4.13.2   |          [JUnit 4](https://junit.org/junit4/)           |
| Cucumber | BDD Framework                        |   7.15.0   |    [Cucumber 7](https://cucumber.io/docs/cucumber/)     |

## 🛠 Framework Creation

1. **Create a new project with:**
    - Java as programming language 🌐
    - Maven as build tool 🛠
    - Git for source version control 🔄

2. **Add necessary dependencies** 📦
    - Selenium, JUnit 4, Cucumber - Java, Cucumber - JUnit

3. **Create folder structure** 📁
    - Pages, Step_definitions, Utilities, Runner, Resources.features
    - ```text
         test
         ├── java
         │   ├── pages
         │   ├── runner
         │   ├── step_definitions
         │   └── utilities
         └── resources
            └── features
      ```

4. **Start by creating your first Cucumber file** 🥒
    - feature-name.feature
    - make sure the file extension is `.feature`

5. **Add necessary plugins** 🔄
    - Cucumber for Java
    - Ensure Gherkin is installed

6. **Running your first feature:** 🏃
    - I. Create a StepDefinition class containing Java methods that define each step from the feature file
      ```java
      package step_definitions;
      public class LoginSteps(){
          // Example of a Step Definition in Java
          @Given("user is on the login page")
          public void userIsOnLoginPage() {
             // code to navigate to login page
          }
      }
      ```
    - II. Create a TestRunner class connecting feature file steps with Java methods from step definitions
        - TestRunner uses JUnit 4 annotation @RunWith() to run tests with Cucumber.class type
            - Customize binding and framework execution with @CucumberOptions():
                - `feature = "path/to/features"`: provides the path to features of the framework
                - `glue = "step definitions location"`: connects the step definitions with feature files steps
                - `dryRun = true/false` options:
                    - If set to true, it checks if all steps in the feature file are defined but doesn't run test cases
                    - If set to false, it runs the test cases and throws an error if steps aren't defined
                - `monochrome = true` : makes the console logs more readable
                - `plugin = {""}`
                - `tags = "@smoke"`
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
    - **`Feature`:** _Short description of the feature to be tested_
        - Examples:
          ```gherkin
          #Example 1: 
          Feature: User Login Functionality
          #Example 2:
          Feature: Reset Password Functionality
          ```  
    - **`Scenario`:** _Brief use case description from a user perspective_
        - Examples:
            ```gherkin
          #Example 1: 
          Scenario: Login with valid credentials
          #Example 2:
          Scenario: Login with invalid credentials
          ```
    - **Given, When, Then, And, But, \* Keywords:**
        - **`Given`** - _Preconditions or starting points_
            - Examples:
              ```gherkin
              #Example 1:
              Given user navigates to login page
              #Example 2:
              Given admin user lands on the home page
              ```
        - **`When`** - _Main actions performed_
            - Examples:
              ```gherkin
              #Example 1:
              When user enters username and password
              #Example 2:
              When user clicks on admin tab
              ```
        - **`Then`** - _Outcome or result of actions, usually at this step you need to perform an assertion_
            - Examples:
              ```gherkin
              #Example 1:
              Then user is redirected to the homepage
              #Example 2:
              Then user can see an error message
              ```
        - **`And`** - _Connects multiple steps within Given, When, or Then_
            - _Used to add more detail or steps without repeating the Given, When, or Then keywords_
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
        - **`But`** - _Describes an exception or a contrasting scenario_
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
        - **`*`** - _Asterisks:_
            - _The asterisk * is a more generic step keyword that can be used in place of any of the other keywords (
              Given, When, Then, And, But)._
            - _It is often used when the specific type of step (setup, action, or assertion) is either clear from
              context
              or not important to the clarity of the scenario._
            - _The use of * doesn't imply a technical or undefined behavior; it's more about flexibility in writing
              the scenario._
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

> ### More information about Gherkin syntax can be found here:
> [Cucumber - Gherkin Syntax](https://cucumber.io/docs/gherkin/reference/)

>## Framework Definition:
>- In IT world a framework term is used widely.
>- A framework in the IT world is a set of pre-written code, tools, and guidelines that are used to build a software.
>
>- Alternative:
>  - Wer need a bookshelf.
>    - First way is to go and do all by yourself from scratch: forest.
>    - Second way, you can go to IKEA and get a flat box with materials and a manual how to build it.

## Meeting for Defining Acceptance Criteria
1. Sprint Planning Meeting - PO, Dev Team, SM
2. Grooming/Backlog Refinement Sessions - PO, Dev Team, SM
3. Three Amigos - A representative from Business(PO), Development(AO, TEch Lead or Sr. Dev), and Testing(Test Lead/Manager, Sr. QA/SDET)

**ATDD** - Acceptance Test Driven Development - Guides the idea of defining a user story with AT(acceptance tests) so everyone involved can understand clearly what is needed to be done
- Then Developers and Testers start to work on parallel

**BDD** - Behavior Driven Development - It by default inherits ATDD and focuses on defining AT with BDD approach that describes user behavior and expected output.

### ATDD vs BDD

#### ATDD Approach
User Story: "As a user, I want to reset my password so that I can access my account if I forget my password."
**Acceptance Criteria**:
- The user should be able to request a password reset from the login page.
- The system should send a password reset link to the user's registered email address.
- The password reset link should expire after 24 hours.
- The user must be able to set a new password using the reset link.

#### BDD Approach
User Story: "As a user, I want to reset my password so that I can access my account if I forget my password."
**Acceptance Criteria**:
- **Scenario 1**: Requesting a password reset
    - **Given** I am on the login page
    - **When** I click on "Forgot Password"
    - **Then** I should be prompted to enter my registered email address
- **Scenario 2**: Receiving a password reset email
    - **Given** I have requested a password reset
    - **When** I enter my registered email address
    - **Then** I should receive a password reset email within 5 minutes
- **Scenario 3**: Resetting the password using the link
    - **Given** I have received a password reset email
    - **When** I click on the reset link in the email
    - **And** I enter a new password
    - **Then** my password should be updated, and I should be redirected to the login page