package cucumber.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		plugin = { "pretty", "html:target/cucumber-html-report" }
		,features="Feature/Exemplo.feature"
		,glue={"cucumber.stepDefinition"}
		)
public class ExemploTest {

}
