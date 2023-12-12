package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)


@CucumberOptions(
        features = "Automationscenarios",//feature file path
        glue="Stepdefnition",//Implementation file path
        tags="@herokuapp",
      	plugin = {"pretty","html:target/Automationreports.html"}
        
        )
public class Testrunner extends AbstractTestNGCucumberTests {



}
