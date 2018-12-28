package br.com.selenium.for_beginners.test.stepsDefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Given;
import static org.junit.Assert.assertTrue;
import br.com.selenium.for_beginners.pages.ConcretePage;

public class exampleSteps {

	private static ConcretePage concrete;

	@Before
	public static void setup() {
		concrete = new ConcretePage();
	}

	// -----------------------------------DADO----------------------------------------------------------
	@Given("^I am on the page$")
	public void im_on_the_page() {
		concrete.visit("Concrete");
	}

	// -----------------------------------QUANDO---------------------------------------------------------
	@When("^I fill in the text field with \"([^\"]*)\"$")
	public void i_fill_in_the_text_field_with(String name) {
		concrete.fillIn(name);
	}

	// -----------------------------------ENTÃO----------------------------------------------------------
	@Then("^I checked if the text \"([^\"]*)\" was successfully validated$")
	public void i_checked_if_the_text_was_successfully_validated(String expected) {
		assertTrue(concrete.verifySearch(expected));
	}
}
