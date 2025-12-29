package apitest;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/api",
        glue = "apitest",
        plugin = {
                "pretty",
                "summary",
                "html:target/api-report.html",
                "json:target/api-report.json"
        }
)
public class apiRunner extends AbstractTestNGCucumberTests {
}
