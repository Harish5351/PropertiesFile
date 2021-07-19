package test.java.TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions
        (
                features = "src/test/Features/calculator.feature",
                glue = "StepDefinition",
                dryRun = false,
                monochrome = true,
                plugin = {"pretty","html:test-output"}
        )

public class CalculatorTest
{

}
