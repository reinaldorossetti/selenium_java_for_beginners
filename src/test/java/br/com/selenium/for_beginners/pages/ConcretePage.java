package br.com.selenium.for_beginners.pages;

import org.openqa.selenium.By;
import br.com.selenium.for_beginners.utils.Page;
import br.com.selenium.for_beginners.utils.HandleProperties;

public class ConcretePage extends Page {

	private static final By INPUT_SEARCH = By.cssSelector("form input[type=text][placeholder*='usca']");
	private static final By BUTTON_SEARCH = By.cssSelector("span[class='icon-search']");

	public void visit(String url) {
		String urlConcrete = System.getProperty("urlConcrete") != null ? System.getProperty("urlConcrete")
				: HandleProperties.getValue("url_concrete");
		openUrl(urlConcrete);
		isUrlContainsValue(url);
	}

	public void fillIn(String text) {
		isElementAttachedToHtml(INPUT_SEARCH);
		fillInput(text, INPUT_SEARCH);
		click(BUTTON_SEARCH);
	}

	public boolean verifySearch(String message) {
		System.out.println(message);
		By MESSAGE = By.xpath("//div[contains(.,'" + message + "')]");
		return isElementAttachedToHtml(MESSAGE);
	}
}
