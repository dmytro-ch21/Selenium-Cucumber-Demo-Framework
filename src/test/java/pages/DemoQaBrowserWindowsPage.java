package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoQaBrowserWindowsPage {

    private WebDriver driver;
    public DemoQaBrowserWindowsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "tabButton") public WebElement newTabButton;
    @FindBy(id = "windowButton") public WebElement newWindowButton;
    @FindBy(id = "messageWindowButton") public WebElement messageWindowButton;
    @FindBy(id = "sampleHeading") public WebElement contentOfNewWindow;
    @FindBy(tagName = "body") public WebElement newWindowMessageParagraph;

}
