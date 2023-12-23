package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

    /**
     * The method takes a string as @param
     * It will decide what type of driver to create
     * @return WebDriver
     * */
    public static WebDriver getDriver(String browserType){
        switch (browserType.toUpperCase()){
            case "FIREFOX" : return new FirefoxDriver();
            case "SAFARI" : return new SafariDriver();
            case "EDGE" : return new EdgeDriver();
            default: return new ChromeDriver();
        }
    }

}
