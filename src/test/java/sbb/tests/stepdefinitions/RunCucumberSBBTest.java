package sbb.tests.stepdefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "pretty",
        // Where to find the cucumber feature files with scenarios to test
        features = "src/test/java/sbb/tests/features")
public class RunCucumberSBBTest {

}