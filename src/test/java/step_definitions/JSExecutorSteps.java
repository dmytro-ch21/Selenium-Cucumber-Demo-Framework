package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import pages.PIMPage;
import utilities.Driver;

public class JSExecutorSteps {

    private WebDriver driver = Driver.getDriverInstance();
    private HomePage homePage = new HomePage(driver);
    private PIMPage pimPage = new PIMPage(driver);

    @When("click on PIM tab with js executor")
    public void click_on_pim_tab_with_js_executor() throws InterruptedException {
        System.out.println("Current URL: " + driver.getCurrentUrl());
        // Regular way of clicking
        // homePage.pimTab.click();
        // Thread.sleep(5000);

        // in case when clicking on a button that we expect to work
        // is not possible with Selenium
        // we will use JSExecutor

        // To execute JS script we will need to create an object
        // here pwe assign the content that driver has to js executor
        // and we downcast the driver for it
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        // Option 1:
//        javascriptExecutor.executeScript("document.getElementById('menu_pim_viewPimModule').click();");
//        Thread.sleep(5000);

        // Option 2
        javascriptExecutor.executeScript("arguments[0].click()", homePage.pimTab);
        Thread.sleep(5000);
    }
    @Then("url ends with {string}")
    public void url_ends_with(String expectedEndpoint) {
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);
        Assert.assertTrue("Endpoint verification failed!", currentUrl.endsWith(expectedEndpoint));
    }

    @Then("scroll to the last element in the page")
    public void scroll_to_the_last_element_in_the_page() throws InterruptedException {
        // scroll to view an element with js executor
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", pimPage.bottomPageLink);
        Thread.sleep(5000);
    }

    @When("click on employee with id {string}")
    public void click_on_employee_with_id(String id) throws InterruptedException {
        WebElement employee = pimPage.returnEmployeeById(id);
        System.out.println("Employee text id: " + employee.getText());
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click()", employee);
        Thread.sleep(5000);
    }

    @When("modify the first name without clicking edit button")
    public void modify_the_first_name_without_clicking_edit_button() throws InterruptedException {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].value='JS Executor'", pimPage.firstNameInputBox);
        Thread.sleep(5000);
    }



}
