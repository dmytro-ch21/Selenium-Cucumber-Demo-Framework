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
     