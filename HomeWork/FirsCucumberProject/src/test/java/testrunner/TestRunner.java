package testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features", // путь к папке с фичами
        glue = "java/steps", // путь к пакетам со степ-дефинициями
        plugin = {"pretty", "html:target/cucumber-report.html"} // плагины для отчетов
)
public class TestRunner {
}
