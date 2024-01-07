package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import pages.PIMPage;
import pages.PersonalDetailsPage;
import utilities.Driver;

public class JSExecutorSteps {

    private WebDriver driver = Driver.getDriverInstance();
    private HomePage homePage = new HomePage(driver);
    private PIMPage pimPage = new PIMPage(driver);
    private PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage(driver);

    @When("click on PIM tab with js executor")
    public void user_clicks_on_pim_tab_with_js_executor() throws InterruptedException {
        // Regular way
        // homePage.clickOnTabByName("PIM");

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        // option 1 - sending the element locator
//        javascriptExecutor.executeScript("document.getElementById('menu_pim_viewPimModule').click()");
//        Thread.sleep(5000);

        // option 2 - sending the element as argument
        javascriptExecutor.executeScript("arguments[0].click()", homePage.pimTab);
        Thread.sleep(5000);
    }

    @Then("url ends with {string}")
    public void url_ends_with(String expectedEndpoint) {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.endsWith(expectedEndpoint));
    }


    @When("scroll to the last element on the web page")
    public void scroll_to_the_last_element_on_the_web_page() throws InterruptedException {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", pimPage.orangeHRMLink);
        Thread.sleep(5000);
    }

    @When("click on employee with id {string}")
    public void click_on_employee_with_id(String id) throws InterruptedException {
        WebElement employee = pimPage.locateEmployeeById(id);
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click()", employee);
        Thread.sleep(5000);
    }
    @When("modify first name without while input is disabled")
    public void modify_first_name_without_while_input_is_disabled() throws InterruptedException {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].value='JS Executor'", personalDetailsPage.nameInputBox);
        Thread.sleep(5000);
    }





}
