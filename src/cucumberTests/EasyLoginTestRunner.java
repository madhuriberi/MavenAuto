package cucumberTests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/featureFiles/EasyLogin.feature",  glue = {"stepDefinition"})

public class EasyLoginTestRunner {
	
}
