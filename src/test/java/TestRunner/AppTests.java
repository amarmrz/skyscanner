package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/features/mainFeatures", glue = {"TestSteps/Steps"}, tags = "@regression",
        plugin = {"pretty", "json:cucumber_results/AutoTest_report.json", "html:cucumber_results/AutoTest_report.html"})

public class AppTests {

}
