package br.com.selenium.for_beginners.runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import br.com.selenium.for_beginners.enums.Browsers;
import cucumber.api.CucumberOptions;
import br.com.selenium.for_beginners.utils.ErrorLog;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

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

    ErrorLog errorlog = new ErrorLog();
	
	@BeforeClass
	public static void tearUp() {

		try {
		System.out.println("Instancia o Browser Antes dos Testes");
		Browsers.setWebDriver();
		} catch (Exception Ex){
			System.out.println(Ex);
			ErrorLog errorlog = new ErrorLog();
			errorlog.log(Ex);
		}
	}
	
    @After
    public void embedScreenshot(Scenario scenario) {
      try {
        if (!scenario.isFailed()) {
        	if (scenario.isFailed()) {
                final byte[] screenshot = ((TakesScreenshot) Browsers.driver()).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
	            }
	}
    }finally {
	
		/// close the browser.
    	//Browsers.driver().close();
  	}
    }
	
	@AfterClass
    public static void teardown() throws InterruptedException {
        Browsers.quitDriver();
        System.out.println("Roda após os testes!");
    }
}
