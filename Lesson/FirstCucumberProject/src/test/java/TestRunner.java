import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "ilcarro/steps",
        plugin = {"pretty", "html:out/cucumber-reports"}
)
public class TestRunner {
}
