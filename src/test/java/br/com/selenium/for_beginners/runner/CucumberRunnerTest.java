package br.com.selenium.for_beginners.runner;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;
import br.com.selenium.for_beginners.enums.Browsers;
import org.junit.runner.RunWith;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(jsonReport = "target/cucumber.json",
        retryCount = 2,
        detailedReport = true,
        detailedAggregatedReport = false,
        overviewReport = true,
        //coverageReport = true,
        jsonUsageReport = "target/cucumber-usage.json",
        usageReport = true,
        toPDF = true,
        excludeCoverageTags = {"@flaky" },
        includeCoverageTags = {"@passed" },
        outputFolder = "target")
@CucumberOptions(plugin = { "html:target/cucumber-html-report",
        "json:target/cucumber.json", "pretty:target/cucumber-pretty.txt",
        "usage:target/cucumber-usage.json", "junit:target/cucumber-results.xml" },
        features = { "src/resources/" },
        glue = { "br/com/selenium/for_beginners/test/stepsDefinitions" },
        tags = {"~@notImplemented"})


public class CucumberRunnerTest {

	@BeforeClass
	public static void tearUp() {
		Browsers.setWebDriver();
	}
}
