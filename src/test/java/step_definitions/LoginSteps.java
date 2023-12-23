package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;
import utilities.DriverFactory;

public class LoginSteps {

    private WebDriver driver = DriverFactory.getDriver("CHROME");
    private LoginPage loginPage = new LoginPage(driver);
    private HomePage homePage = new HomePage(driver);

    @Given("user navigates to hrm login page")
    public void user_navigates_to_hrm_login_page() {
        driver.get("http://dev-hrm.yoll.io/index.php/auth/login");
    }
    @When("user enters username and password")
    public void user_enters_username_and_password() {
        loginPage.usernameInputBox.sendKeys("yoll-student");
        loginPage.passwordInputBox.sendKeys("Bootcamp5#");
    }
    @When("user clicks login button")
    public void user_clicks_login_button() {
        loginPage.loginButton.click();
    }

    @Then("user is redirected to home page")
    public void user_is_redirected_to_home_page() {
        String actualWelcomeMessage = homePage.welcomeMessage.getText();
        String expectedWelcomeMessage = "Welcome Yoll";
        // we will need to assert actual and expected
        // The testNG structure of assert: Assert.assertEquals(actual, expected, message)
        // In JUnit there are identical hard assert methods
        Assert.assertEquals( "Welcome message verification failed", expectedWelcomeMessage, actualWelcomeMessage);
    }

    @Then("framework browser quit")
    public void framework_browser_quit() {
        driver.quit();
    }

    @When("user enters invalid username and password")
    public void user_enters_invalid_username_and_password() {
        loginPage.usernameInputBox.sendKeys("invalid");
        loginPage.passwordInputBox.sendKeys("invalid");
    }
    @Then("user can see an error message")
    public void user_can_see_an_error_message() {
        String actualErrorMessage = loginPage.errorMessage.getText();
        String expectedErrorMessage = "Invalid credentials";
        Assert.assertEquals("Error message verification failed", expectedErrorMessage, actualErrorMessage);
    }


}
