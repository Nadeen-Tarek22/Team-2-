package runnerPackage;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/main/resources/Features",
        glue = {"StepDefinitions"},
        plugin = {"pretty","html:target/html-report.html",
                "html:target/cucumber-reports.json"}
)
public class Runner extends AbstractTestNGCucumberTests{


}
