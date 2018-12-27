package br.com.selenium.for_beginners.enums;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import br.com.selenium.for_beginners.utils.DriverFactory;
import br.com.selenium.for_beginners.utils.HandleProperties;

public enum Browsers {

	IE_WINDOWS("webdriver.ie.driver", "\\IEDriverServer.exe"),
	MOZILLA_WINDOWS("webdriver.gecko.driver", "\\geckodriver.exe"),
	CHROME_WINDOWS("webdriver.chrome.driver", "\\chromedriver.exe"),
	EDGE_WINDOWS("webdriver.edge.driver", "\\MicrosoftWebDriver.exe"),
	CHROME_MAC("webdriver.chrome.driver", "/chromedriver");

	public static WebDriver webDriver;
	private String browserType;
	private String executable;

	Browsers(String browserType, String executable) {
		this.browserType = browserType;
		this.executable = executable;
	}

	public String getBrowserType() {
		return browserType;
	}

	public String getExecutable() {
		return executable;
	}

	public static void showAvaliableBrowsersOptions() {
		for (Browsers browsers : Browsers.values()) {
			System.out.println("======= ".concat(browsers.name()));
		}
	}

	public WebDriver createDriverInstance() {
		try {
			System.out.println(browserType);
			switch (browserType) {
			case "webdriver.ie.driver":
				return new InternetExplorerDriver();
			case "webdriver.gecko.driver":
				return new FirefoxDriver();
			case "webdriver.chrome.driver":
			       ChromeOptions options = new ChromeOptions();
			       options.addArguments("--start-fullscreen", "--disable-gpu");
			       return new ChromeDriver(options);
			case "webdriver.edge.driver":
				return new EdgeDriver();
			default:
				return null;
		}} catch(Exception ex) {
			System.out.println(ex);
		}
		return null;
	}

	public static void setWebDriver() {
		
		System.out.println(System.getProperty("browser"));
		webDriver = DriverFactory.createDriver(System.getProperty("browser"));

  	}

	public static void quitDriver() {
		webDriver.quit();
		webDriver = null;
	}
}
