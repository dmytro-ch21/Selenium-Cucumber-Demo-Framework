package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.DemoQaBrowserWindowsPage;
import utilities.Driver;
import utilities.PropertiesUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DemoQaBrowserWindowsPageSteps {

    private WebDriver driver = Driver.getDriverInstance();
    private DemoQaBrowserWindowsPage demoQaBrowserWindowsPage = new DemoQaBrowserWindowsPage(driver);
    private String mainWindowGUID;
    @Given("I land on Demo QA Browser Windows Page")
    public void i_land_on_demo_qa_browser_windows_page() {
        String url = PropertiesUtils.getDemoQaBrowserWindowUrl();
        driver.get(url);
    }
    @When("I can retrieve the GUID of current page")
    public void i_land_on_the_page_i_can_retrieve_the_guid_of_current_page() {
        mainWindowGUID = driver.getWindowHandle();
        System.out.println("Main window GUID: " + mainWindowGUID);
    }

    @When("I click on {string} button")
    public void i_click_on_new_window_button(String buttonName) {

        switch (buttonName.toUpperCase()){
            case "NEW WINDOW":
                demoQaBrowserWindowsPage.newWindowButton.click();
                break;
            case "NEW TAB":
                demoQaBrowserWindowsPage.newTabButton.click();
                break;
            default:
                Assert.fail("Such button doesn't exist!");
        }

    }

    @Then("a new window is created and I switch to it")
    public void a_new_window_is_created() {

        /*
         * to verify that we are on different page we will need to get a point we can rely on:
         * url, title, content
         * for this case lets do url
         *
         * In order to get those properties of the new window we need first to switch to that window
         * Steps to switch:
         * 1. Retrieve all windows handles - all GUIDS
         * 2. Switch to the one that is next to the main one
         * 3. Interact with that window
         * */

        // Retrieving all GUIDS with getWindowHandles() - returns a Set of unique GUIDS
        Set<String> allWindowGUIDS = driver.getWindowHandles();
        System.out.println("All GUIDS: " + allWindowGUIDS);
        System.out.println("Before Switching URL: " + driver.getCurrentUrl());

//        int expectedWindowCount = 2;
//        int actualWindowsCount = allWindowGUIDS.size();
//        Assert.assertEquals("New window creating failed.", expectedWindowCount, actualWindowsCount);

        // Retrieving the current/main window handle to us it in condition to not switch to already current window
//        String currentWindowGUID = driver.getWindowHandle();
//
//        // switching to next window Option 1:
//        for(String windowGUID : allWindowGUIDS){
//            if(!currentWindowGUID.equals(windowGUID)){
//                driver.switchTo().window(windowGUID);
//                break;
//            }
//        }

        // switching to next window Option 2:
        // Since a Set doesn't have indices we cannot switch to an element without iterating over
        // However we can convert the Set to a list and use list index
        List<String> allWindowHandlesGUIDSList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(allWindowHandlesGUIDSList.get(1)); // index one since we have two windows, 0 will be main window and 1 is the new window

        System.out.println("After Switching URL: " + driver.getCurrentUrl());
    }
    @Then("I can see the content as {string}")
    public void i_can_see_the_content_as(String expectedContent) {
        // now we can interact with elements from the new window
        String actualContentFromNewWindow = demoQaBrowserWindowsPage.contentOfNewWindow.getText();
        System.out.println("Content from new window: " + actualContentFromNewWindow);
        Assert.assertEquals("Content verification in the new window failed", expectedContent, actualContentFromNewWindow);
    }

    @When("I close the new window")
    public void i_close_the_new_window() throws InterruptedException {

        // quit() vs close()
        // quit() will terminate all the windows/tabs of the browser instantly
        // close() will terminate only current window/tab
        driver.close();
        //Thread.sleep(5000);

    }
    @Then("I switch to main window and can see the title of the page is {string}")
    public void i_switch_to_main_window_and_can_see_the_title_of_the_page_is(String expectedTitle) {

        // switch to main/initial window
        driver.switchTo().window(mainWindowGUID);

        System.out.println("URL after switch: " + driver.getCurrentUrl());
        System.out.println("Title: " + driver.getTitle());

        Assert.assertEquals("Title verification on main window failed", expectedTitle, driver.getTitle());
    }



}
