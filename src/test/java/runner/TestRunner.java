package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        // first we need to teach our framework where all the features will be located
        features = "src/test/resources/features",
        // then we have to connect the feature steps with step definitions
        // for this we will use "glue" to provide the location to step definitions
        // to provide location of steps we start wil by default "src/test/java"
        glue = "step_definitions"
)
public class TestRunner {
    // no code need inside of this class!
}
