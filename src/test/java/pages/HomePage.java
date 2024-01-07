package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "welcome")
    public WebElement welcomeMessage;

    @FindBy(xpath = "//div[@class='menu']//b")
    public List<WebElement> tabs;

    @FindBy(id  = "menu_pim_viewPimModule")
    public WebElement pimTab;


    public void clickOnTabByName(String tabName){
        for(WebElement tab: tabs){
            if(tabName.equalsIgnoreCase(tab.getText())){
                tab.click();
                break;
            }
        }
    }


}
