package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
Singleton:
There are 3 base rules to create a Singleton Class
1. Private Constructor - to avoid instantiation of this class
2. Private Static Member(Property) - contains the instance of the Driver
3. Static Public Method - will act as a global access point (getter)

Optional:
4. Static Set Up Method - To initialize the browser to a very specific type (setter)
5. Static Clean Up Method - will basically quit the driver
 */
public class Driver {

    private static WebDriver driver;

    private Driver(){}

    public static WebDriver getDriverInstance(){
        if(driver == null){
            driver = new ChromeDriver();
        }
        return driver;
    }

    // Optional methods
    public static void setDriver(WebDriver driverType){
        if(driver != null){
            System.out.println("Overwrite the driver instance.");
        }
        driver = driverType;
    }
    public static void quitDriver(){
        if(driver == null){
            System.out.println("The driver is already closed");
        }
        driver.quit();
    }
}
