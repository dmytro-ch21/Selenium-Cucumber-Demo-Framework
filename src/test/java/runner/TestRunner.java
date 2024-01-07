package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "step_definitions",
        dryRun = false,
        tags = "@js-tc3",
        monochrome = true,
        plugin = {"pretty", "html:target/html-reports/cucumber-reports.html" }
)
public class TestRunner {
    // no code need inside of this class!
}
