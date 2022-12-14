package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	WebDriver driver;
	Logger logger;
	
	public LoginPage(WebDriver Idriver) {
		driver = Idriver;
		logger = Logger.getLogger("LoginPage");
	}
	@FindBy(name="username") WebElement uname;
	@FindBy(name="pwd") WebElement pass;
	@FindBy(id="loginButton") WebElement loginButton;
	@FindBy(id="logoutLink") WebElement logoutButton;
	
	public void loginToHR(String usernameApp, String passwordApp)
	{
		logger.info("Login to Actitime HR");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Enter Username");
		uname.sendKeys(usernameApp);
		
		logger.info("Enter Pasword");
		pass.sendKeys(passwordApp);
		
		logger.info("Click Login Button");
		loginButton.click();
	}
	
	public void logoutFromHR()
	{
		logger.info("Logout from Actitime HR");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Click Logout Button");
		logoutButton.click();
	}
	
	public boolean verifyLogin(String expectedUrl) {
		if(expectedUrl.equals(driver.getCurrentUrl())) {
			return true;
		}
		else {
			return false;
		}
	}
}
