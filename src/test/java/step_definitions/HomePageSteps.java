package step_definitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import utilities.Driver;
import utilities.DriverFactory;

import java.util.List;

public class HomePageSteps {

    private HomePage homePage = new HomePage(Driver.getDriverInstance());

    @Then("user is redirected to home page")
    public void user_is_redirected_to_home_page() {
        String actualWelcomeMessage = homePage.welcomeMessage.getText();
        String expectedWelcomeMessage = "Welcome Yoll";
        // we will need to assert actual and expected
        // The testNG structure of assert: Assert.assertEquals(actual, expected, message)
        // In JUnit there are identical hard assert methods
        Assert.assertEquals( "Welcome message verification failed", expectedWelcomeMessage, actualWelcomeMessage);
    }

    @Then("user can see following tabs:")
    public void user_can_see_following_tabs(List<String> eTabs) throws InterruptedException {
        Thread.sleep(5000);

        List<String> expectedTabs = eTabs;
        System.out.println("expectedTabs size: " + expectedTabs.size());
        List<WebElement> actualTabs = homePage.tabs;
        System.out.println("actualTabs size: " + actualTabs.size());

        if(expectedTabs.size() != actualTabs.size()){
            Assert.fail("The actual count of tabs is not matching expected count!");
        }

        for (int i = 0; i < actualTabs.size(); i++) {
            String expectedTab = expectedTabs.get(i);
            String actualTab = actualTabs.get(i).getText();
            Assert.assertEquals("Tab verification failed.", expectedTab, actualTab);
        }
    }


}
