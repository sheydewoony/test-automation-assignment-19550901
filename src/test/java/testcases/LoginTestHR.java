package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.LoginPage;
import testbase.BaseClass;

public class LoginTestHR extends BaseClass{
	
	 @Test
	 public void loginApp()
	 {
		 logger = report.createTest("Login to Actitime HR");
		 LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		 logger.info("Starting Application");
		 loginPage.loginToHR(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		 if(loginPage.verifyLogin(excel.getStringData("Urls", 0, 1))){
			 logger.pass("Login Success");	 
			 loginPage.logoutFromHR();
			 logger.pass("Logout Success");
		 }
		 else {
			 logger.fail("Login Failed");
		 }
	 }
}
