package ai.iamneo.testing.Testing_Selenium_TestNg;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class App 
{

    public static void main( String[] args ) throws MalformedURLException, IOException
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");
		
        WebDriver driver = new Base().initializeBrowser(
			new RemoteWebDriver(new URL("http://34.145.178.102:443"), capabilities)
		);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.gillette.co.in");

        Actions action = new Actions(driver);
		WebElement productsMenu = driver.findElement(By.xpath("//*[@id=\"headerMenu\"]/div/nav/div/div[2]/button/span"));
		action.moveToElement(productsMenu).build().perform();
		
		WebElement brandsSubMenu = driver.findElement(By.xpath("//*[@id=\"headerMenu\"]/div/nav/div/div[2]/div/div/div/div/div[1]/div[1]/a[3]"));
		brandsSubMenu.click();

		WebElement explore = driver.findElement(By.xpath("//*[@id=\"main-banner\"]/div/div[2]/div/a"));
		explore.click();

		driver.quit();
    }  
}
