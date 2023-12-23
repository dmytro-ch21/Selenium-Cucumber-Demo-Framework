# Selenium-Cucumber-Framework Documentation

## Framework Creation

1. Create a new project with
   - Java as programming language - check version in terminal (should be at least java 8 and higher)
     - The newest versions of selenium support java 11 and soon will switch to java 17 so make sure if that's the case install the needed version
   - Maven - build tool
   - Git - for Source version tool

2. Add necessary dependencies
   - selenium 
   - junit 4
   - cucumber - java
   - cucumber - junit

3. Create folder structure
   - pages
   - step_definitions
   - utilities
   - runner
   - resources.features

4. Start by creating first cucumber file

5. Add necessary dependencies
   - cucumber for java
   - make sure Gherkin is installed along the way
   
6. Running first feature:
   - Create a StepDefinition class that will contain java methods that define each step from feature file
   - Create a TestRunner class that will connect the feature file steps with java methods from step definitions
     - TestRunner will use JUnit 4 annotation @RunWith() to run tests with Cucumber.class type
     - Also, we will need to customize the binding and framework execution with @CucumberOption():
       - Provide feature = "path/to/features"
       - Provide glue = "step definitions location"
       - Provide dryRun:
         - if set ti true it will not run test case but check if all step in feature file are defined
         - if set to false it will run the test cases without checking step def and throw error if not defined
       
7. Cucumber Keywords definitions in feature files
   1. Feature: Should contain a short description about the feature you will test
      - Examples: 
        - Feature: User Login Functionality
        - Feature: Reset Password Functionality
   2. Scenario: Describes shortly a use case from user perspective how feature will be used in real life
       - Examples: 
         - Scenario: Login with valid credentials
         - Scenario: Login with invalid credentials
         
   3. Given, When, Then , And, But, *
   
      - Given - what is starting point of scenario, what is given as a precondition
        - Given user navigates to
        - Given admin user lands on home page
          - If you have more than one given steps it is recommended to use And keyword 
            - Given an admin user
            - And admin user navigates to internal portal
            
      - When - describes the main action/s that you do in the case 
        - When user enters username and password
        - When user clicks on admin tab
          - If you have more than one action add And keyword to connect few actions in the row
            - When user enters username
            - And user enters password
            - And user clicks login
            
      - Then - describes the outcome of the action taken
        - Then user is redirected to the homepage
        - Then user can see a error message
        - Then user is able to submit form
        
      - But keyword is less used but it can implemented as well
        - Given user navigates to login page
        - When user logs in with expired credentials
        - Then user is redirected to home page
        - But user can see an error message to change credentials