package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DemoQaBrowserWindowPage {

    private WebDriver driver;

    public DemoQaBrowserWindowPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "windowButton")
    public WebElement newWindowButton;

    @FindBy(id = "tabButton")
    public WebElement newTabButton;

    @FindBy(id = "sampleHeading")
    public WebElement contentElementNewWindow;

    @FindBy(xpath = "//*[@id = 'browserWindows']//button")
    public List<WebElement> buttonsOnHopePage;


    /* Solution 2 - By Oleksandr Leshko */
    public void clickOnButton(String buttonName) {
        for (WebElement button : buttonsOnHopePage) {
            if (button.getText().equals(buttonName)) {
                button.click();
            }

        }

    }


}
