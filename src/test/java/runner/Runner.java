package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/com/academy/techcenture/features/login.feature"},
        glue = {"com/academy/techcenture/stepDefinitions","Hooks"}
        // tags = {"@regression"}
)

public class Runner {



}

