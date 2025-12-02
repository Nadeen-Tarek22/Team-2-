package runnerPackage;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features =  "src/main/resources/Features",
        glue = {"StepDefinitions","Hooks"},
        plugin = {"pretty","html:target/html-report",
                "json:target/cucumber-reports/cucumber.json"}
)
public class Testrunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
