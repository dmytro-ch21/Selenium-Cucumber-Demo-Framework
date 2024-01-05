package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.BestBuyLandingPage;
import utilities.Driver;
import utilities.DriverFactory;

public class BestBuySearchSteps {

    private WebDriver driver = Driver.getDriverInstance();
    private BestBuyLandingPage bestBuyLandingPage = new BestBuyLandingPage(driver);

    @Given("user lands on best buy")
    public void user_lands_on_best_buy() {
        driver.get("https://www.bestbuy.com/");
    }

    @When("user enters {string} in search box")
    public void user_enters_text_in_search_box(String text) {
        bestBuyLandingPage.searchBox.sendKeys(text);
        bestBuyLandingPage.searchIcon.click();
    }

}
