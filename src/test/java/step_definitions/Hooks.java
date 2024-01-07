package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.Driver;
import utilities.DriverFactory;
import utilities.PropertiesUtils;

import java.time.Duration;

public class Hooks {

    @Before
    public void setUp(){
        Driver.setDriver(DriverFactory.getDriver(PropertiesUtils.getBrowserType()));
        Driver.getDriverInstance().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @After
    public void tearDown(){
        Driver.quitDriver();
    }

}
