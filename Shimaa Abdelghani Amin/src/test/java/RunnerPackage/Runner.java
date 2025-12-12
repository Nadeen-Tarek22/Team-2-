package RunnerPackage;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/main/resources/Features",
        glue = "StepDefinitions",
        plugin = {"pretty",
                "html:target/cucumber-reports.json",
                "html:target/cucumber-reports.html"}

)
public class Runner extends AbstractTestNGCucumberTests {
}
