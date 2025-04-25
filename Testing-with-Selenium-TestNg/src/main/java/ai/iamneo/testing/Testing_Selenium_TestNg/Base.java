package ai.iamneo.testing.Testing_Selenium_TestNg;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

public class Base {
		
	WebDriver driver;
	
	public WebDriver initializeBrowser(RemoteWebDriver remoteDriver) throws IOException {
		driver = remoteDriver;
		WebDriverListener listener = new EventHandler();
		WebDriver decoratedDriver = new EventFiringDecorator(listener).decorate(driver);
		return decoratedDriver;
	}
}