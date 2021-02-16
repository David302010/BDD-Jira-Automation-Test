package jiraTest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"})


/*@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},
        tags = {"@Login"})*/


/*@CucumberOptions(
        plugin = { "pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json"
        },
        features = {"src/test/resources/jiraTest/Features"},
        glue = {"jiraTest/stepDefs"}
)*/
public class RunCucumberTest {

}
