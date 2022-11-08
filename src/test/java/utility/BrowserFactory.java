package utility;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	
	public static WebDriver startApplication(WebDriver driver,String browserName, String appURL) 
	{
		if(browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browserName.equals("FireFox")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/selenium-firefox-driver-4.6.0");
			driver = new FirefoxDriver();	
			
		}
		else if (browserName.equals("IE")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/selenium-ie-driver-4.6.0");
			driver = new InternetExplorerDriver();
		}
		else {
			System.out.println("We do not support this browser");
		}
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get(appURL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return driver;
	}
	
	public static void quitBrowser(WebDriver driver) {
		driver.quit();
	}
}
