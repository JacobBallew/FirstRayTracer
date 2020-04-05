package cucumber.testRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = {"src/test/java/cucumber/features"},
        glue = {"cucumber/stepDefinitions"},
        tags = {"@RegularTest"},
        plugin = {"pretty",
                "html:target/GeneratedTestReports/html",
                "json:target/GeneratedTestReports/json/report.json",
                "junit:target/GeneratedTestReports/junit/report.xml"})
public class BasicTest {
}
