package step_definitions;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pages.DemoQaBrowserWindowPage;
import utilities.Driver;
import java.util.ArrayList;
import java.util.List;


public class DemoQaBrowserWindowPageSteps {

    private WebDriver driver = Driver.getDriverInstance();
    private DemoQaBrowserWindowPage demoQaBrowserWindowPage = new DemoQaBrowserWindowPage(driver);
    private String mainWindowGUID;

    @Given("I land on Demo QA Browser Window Page")
    public void i_land_on_demo_qa_browser_window_page() {
        // TODO - read the URL from config files(properties) instead of hard coding
        // TODO - in the PropertiesUtils - create a new method that will return the url of demoqawindowpage
        String url = "https://demoqa.com/browser-windows";
        driver.get(url);
    }
    @Then("I can retrieve the GUID of the current window")
    public void i_can_retrieve_the_guid_of_the_current_window() {
        // to retrieve the current window GUID we will use getWindowHandle() selenium method
        mainWindowGUID = driver.getWindowHandle();
        System.out.println("The main window GUID is: " + mainWindowGUID);
    }

    // OPTION 1
    @When("I click on {string} button")
    public void i_click_on_new_window_button(String buttonName) {
        switch (buttonName){
            case "New Window":
                demoQaBrowserWindowPage.newWindowButton.click();
                break;
            case "New Tab":
                demoQaBrowserWindowPage.newTabButton.click();
                break;
            default:
                System.out.println("There is no such button name");
        }
    }

    // OPTION 2 - By Oleksandr Leshko
//    @When("I click on {string} button")
//    public void i_click_on_button(String buttonName) {
//        demoQaBrowserWindowPage.clickOnButton(buttonName);
//    }

    @Then("a new window is created and I switch to it")
    public void a_new_window_is_created_and_i_switch_to_it() {
        /* In order to retrieve the window handles GUIDs for all windows/tabs we will use getWindowHandles() */
        // 1. Get all window GUIDs
        // 2. Switch to the GUID of the new window
        // 3. Interact with new window DOM

        /* When we retrieve the window handles it gives me back all including the current/main window GUID */
//        Set<String> allWindowGUIDs = driver.getWindowHandles();
//        // For debugging purposes we will print in the console all GUIDs
//        System.out.println("All Window GUIDs: " + allWindowGUIDs);

        // In order to interact with element of the set we will need to iterate over it
        // Option 1

        /*
         *for(String windowGUID : allWindowGUIDs){
         *   // in is recommended to not switch to the already existing GUID
         *   if(!windowGUID.equals(mainWindowGUID)){
         *       driver.switchTo().window(windowGUID);
         *       System.out.println("Switched to the window GUID: " + windowGUID);
         *       break;
         *   }
         * }
         */

        // Option 2
        // I want top find the work around to be able to interact with indices
        List<String> allWindowGUIDList = new ArrayList<>(driver.getWindowHandles());
        System.out.println("All Window GUIDs: " + allWindowGUIDList);

        // before switch to new window check if there is new window created
        int actualWindowCount = allWindowGUIDList.size();
        int expectedWindowCount = 2;
        Assert.assertEquals("Count window verification failed!", expectedWindowCount, actualWindowCount);

        // we have two elements in the list
        // first at index 0 is main window GUID
        // second is the new window GUID
         driver.switchTo().window(allWindowGUIDList.get(1));
    }

    @Then("I can see the content on the new window as {string}")
    public void i_can_see_the_content_on_the_new_window_as(String expectedContentText) {
        String actualContentText = demoQaBrowserWindowPage.contentElementNewWindow.getText();
        Assert.assertEquals("Content verification of new window failed!", expectedContentText, actualContentText);
    }

    @When("I close the new window")
    public void i_close_the_new_window() {
        // driver.quit() vs driver.close()
        // driver.quit() - will terminate all windows and tabs related to the WebDriver instance
        // driver.close() - will terminate only the current window tab
        driver.close();
    }
    @Then("I switch back to main window and the title is {string}")
    public void i_switch_back_to_main_window_and_the_title_is(String expectedTitle) {
        driver.switchTo().window(mainWindowGUID); // go to the initial/first window
        String actualTitle = driver.getTitle();
        System.out.println("Current Page Title: " + actualTitle);
        Assert.assertEquals("Title verification failed", expectedTitle, actualTitle);
    }

}
