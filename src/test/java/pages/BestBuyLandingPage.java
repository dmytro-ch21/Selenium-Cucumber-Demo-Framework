package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BestBuyLandingPage {

    public BestBuyLandingPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy( id = "gh-search-input")
    public WebElement searchBox;

    @FindBy(css = "[title='submit search']")
    public WebElement searchIcon;


}
