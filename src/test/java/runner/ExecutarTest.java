package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/relatorios/cucumber-reports/",
		"json:target/cucumber-reports/cucumber.json",
		"junit:target/cucumber-reports/Cucumber.xml" }, 
		features = "src/test/resources/features", 
		snippets = SnippetType.CAMELCASE, 
		monochrome = true, 
		glue = "", 
		dryRun = false, 
		tags = "@Web")

public class ExecutarTest {

}
