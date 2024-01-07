package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PIMPage {

    private WebDriver driver;

    public PIMPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(id = "empsearch_id")
    public WebElement idInputBox;

    @FindBy(id = "searchBtn")
    public WebElement searchButton;

    @FindBy(xpath = "//table[@id='resultTable']/tbody/tr")
    public List<WebElement> tableBodyRows;

    @FindBy(id = "footer")
    public WebElement bottomPageLink;

    @FindBy(id = "personal_txtEmpFirstName")
    public WebElement firstNameInputBox;

    public Map<String, String> getEmployeeDataByIndex(int index){

        String xpath = "//table[@id='resultTable']/tbody/tr["+index+"]";

        String employeeId = driver.findElement(By.xpath(xpath + "/td[2]")).getText();
        String employeeFirstAndMiddleName = driver.findElement(By.xpath(xpath + "/td[3]")).getText();
        String employeeLastName= driver.findElement(By.xpath(xpath + "/td[4]")).getText();
        String employeeJobTitle = driver.findElement(By.xpath(xpath + "/td[5]")).getText();

        Map<String, String> employee = new HashMap<>();
        employee.put("id", employeeId);
        employee.put("firstAndMidName", employeeFirstAndMiddleName);
        employee.put("lastName", employeeLastName);
        employee.put("jobTitle", employeeJobTitle);

        return employee;
    }

    public WebElement returnEmployeeById(String id){
        String xpath = "//*[text() = '"+id+"']";
        return driver.findElement(By.xpath(xpath));
    }



}
