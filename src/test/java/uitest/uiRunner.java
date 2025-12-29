package uitest;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/ui",
        glue = {"uitest"},
        plugin = {"pretty","summary","json:target/uitest-report.json","html:target/uitest-report.html"},
        monochrome = true
)
public class uiRunner extends AbstractTestNGCucumberTests {
}