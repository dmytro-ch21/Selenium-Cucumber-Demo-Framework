package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import pages.LoginPage;
import utilities.Driver;
import utilities.DriverFactory;

import java.util.List;

public class LoginSteps {

    private WebDriver driver = Driver.getDriverInstance();
    private LoginPage loginPage = new LoginPage(driver);
    private HomePage homePage = new HomePage(driver);

    @Given("user navigates to hrm login page")
    public void user_navigates_to_hrm_login_page() {
        driver.get("http://dev-hrm.yoll.io/index.php/auth/login");
    }

    @When("user clicks login button")
    public void user_clicks_login_button() {
        loginPage.loginButton.click();
    }

    @Then("framework browser quit")
    public void framework_browser_quit() {
        Driver.quitDriver();
    }

    @When("user logs in with username {string} and password {string}")
    public void user_enters_username_and_password(String username, String password) {
            loginPage.login(username, password);
    }

    @Then("user can see error message {string}")
    public void user_can_see_error_message(String expectedErrorMessage) {
        String actualErrorMessage = loginPage.errorMessage.getText();
        Assert.assertEquals("Error message verification failed", expectedErrorMessage, actualErrorMessage);
    }


}
