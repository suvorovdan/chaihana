import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by student on 05.11.2018.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources"},
        glue = {"stepdefs"},
        tags = {"@all"},
        plugin = {"io.qameta.allure.cucumber3jvm.AllureCucumber3Jvm"}
)
public class CucumberRunner {
}
