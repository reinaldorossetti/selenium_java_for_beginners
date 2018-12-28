package br.com.selenium.for_beginners.test.stepsDefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import br.com.selenium.for_beginners.enums.Browsers;
import br.com.selenium.for_beginners.utils.AllureHelper;
import cucumber.api.java.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @After
    public void afterEachScenario(Scenario scenario) {
	//if (scenario.isFailed()) {
	final byte[] screenshot = ((TakesScreenshot) Browsers.driver()).getScreenshotAs(OutputType.BYTES);
	scenario.embed(screenshot, "image/png", "click here!");
	//}
        AllureHelper.saveScreenshootOfScenario(scenario);
        Browsers.quitDriver();
    }
}
