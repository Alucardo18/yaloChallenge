


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "json:target/cucumber.json"},
        features = {"src/test/resources/"},
        glue = {"com.yalo.stepDef"},
        snippets = SnippetType.CAMELCASE
)
public class CucumberRunnerTest {
}
