package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import pages.PIMPage;
import utilities.Driver;

import java.util.Map;

public class PIMPageSteps {

    private HomePage homePage = new HomePage(Driver.getDriverInstance());
    private PIMPage pimPage = new PIMPage(Driver.getDriverInstance());


    @When("user clicks on {string} tab")
    public void user_clicks_on_tab(String tabName) {
        homePage.clickOnTabByName(tabName);
    }
    @When("user types ID as {string} in the Employee Information")
    public void user_types_id_as_in_the_employee_information(String id) {
        pimPage.idInputBox.clear();
        pimPage.idInputBox.sendKeys(id);
    }
    @When("user clicks search button")
    public void user_clicks_search_button() {
        pimPage.searchButton.click();
    }

    @Then("user can see one record in the table with {string}, {string}, {string}, and {string}")
    public void user_can_see_one_record_in_the_table_with_and(String expectedId, String expectedFirstMidName, String expectedLastName, String expectedJobTitle) {
        // verify there is only one record in the table
        int expectedEmployeeCount = 1;
        int actualEmployeeCount = pimPage.tableBodyRows.size();

        Assert.assertEquals("There are more or less than one record in the table!", expectedEmployeeCount, actualEmployeeCount);

        Map<String, String> actualEmployee = pimPage.getEmployeeDataByIndex(1);

        Assert.assertEquals("Id verification failed!", expectedId, actualEmployee.get("id"));
        Assert.assertEquals("First and Mid name verification failed!", expectedFirstMidName, actualEmployee.get("firstAndMidName"));
        Assert.assertEquals("Last Name verification failed!", expectedLastName, actualEmployee.get("lastName"));
        Assert.assertEquals("Job Title verification failed!", expectedJobTitle, actualEmployee.get("jobTitle"));

    }

}
